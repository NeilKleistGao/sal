package sal.types

import org.antlr.v4.runtime.{ParserRuleContext}
import java.lang.StringBuilder
import sal.types._
import sal.{SalException, ExpressionNode, FieldNode, InitializerNode, LitNode, UnOpExpression, BiOpExpression, TypeNameNode}

class Typer {
  import Typer._
  import sal.Operator._
  import sal.OperatorParser
  import sal.parser.SalParser

  private val errors = new StringBuilder("\n")

  private def report(s: String) = errors.append(s)
  private def report(s: String, line: Int) = errors.append(SalException.format(s, line))
  
  def getErrorMessage(): Option[String] =
    if (errors.length() <= 1) None
    else Some(errors.toString())

  def getTypeName(ctx: ParserRuleContext, typeName: String)(implicit typeCtx: Context) = {
    val tp: Type = try typeCtx?typeName
      catch {
        case SalException(info) => {
          report(info, at(ctx))
          anythingType  // shield other type checking.
        }
      }
    tp
  }

  def addType(ctx: ParserRuleContext, name: String, tp: Type, expType: Type)(implicit typeCtx: Context) = {
    try
      typeCtx += (name, tp)
    catch {
      case SalException(info) => report(info, at(ctx))
    }

    if (!typeCtx.require(name, expType))
      report(s"$name got ${expType}, but ${tp} is required.", at(ctx))
  }

  def assertType(ctx: ParserRuleContext, from: Type, to: Type) = {
    if (from.as(to)) to
    else {
      report(s"${from} can't be asserted as ${to}", at(ctx))
      from // shield other type checking.
    }
  }

  def getOperatorType(ctx: SalParser.ExpressionContext, op: Operator)(implicit typeCtx: Context) = {
    val op = OperatorParser(ctx)
    (try typeCtx.query(op)
      catch {
        case SalException(info) =>
          report(info, at(ctx)); FunctionType(anythingType, anythingType) // shield other type checking.
      }).asInstanceOf[FunctionType]
  }

  def checkOperatorParameters(ctx: ParserRuleContext, op: Operator, vType: Type, opType: Type): Unit =
    if (opType !== FunctionType(vType, anythingType))
      report(s"operator $op is $opType, but the parameter is $vType", at(ctx))

  def checkOperatorParameters(ctx: ParserRuleContext, op: Operator, lhsType: Type, rhsType: Type, opType: Type): Unit =
    if (opType !== FunctionType(lhsType, FunctionType(rhsType, anythingType)))
      report(s"operator $op is $opType, but parameters are $lhsType and $rhsType", at(ctx))

  def addFunction(ctx: ParserRuleContext, name: String, retType: Type, bodyType: Type, funType: Type)(implicit typeCtx: Context) = {
    if (retType !== bodyType)
      report(s"return value of $name got $bodyType, but $retType is required.", at(ctx))

    try typeCtx += (name, funType)
    catch {
      case SalException(info) => report(info, at(ctx))
    }
  }

  def getApplicationType(ctx: ParserRuleContext, func: ExpressionNode, funcType: Type, params: List[ExpressionNode]) =
    try matchApplicationType(funcType, 0)(func, params)
    catch {
      case SalException(info) => report(info, at(ctx)); anythingType // shield other type checking.
    }
  
  def checkField(ctx: ParserRuleContext, name: String, tp: Type, init: Type) =
    if (tp !== init)
      report(s"field $name requires $tp, but got $init", at(ctx))

  def addFields(ctx: ParserRuleContext, list: List[FieldNode])(implicit typeCtx: Context) =
    try
      list.foreach((n) => typeCtx += (n.id, n.salType))
    catch {
      case SalException(info) => report(info, at(ctx))
    }

  def getFieldType(ctx: ParserRuleContext, node: ExpressionNode, fieldName: String, recType: Type) =
    try
      recType match {
        case rt: RecordType => rt.get(fieldName)
        case _ => throw SalException(s"${node.toLua(0)} is not a record.")
      }
    catch {
      case SalException(info) => {
        report(info, at(ctx))
        anythingType // shield other type checking.
      }
    }

  def getInitializer(ctx: ParserRuleContext, id: String, inits: List[InitializerNode])(implicit typeCtx: Context): (RecordType, List[InitializerNode]) =
    try typeCtx?id match {
      case rt @ RecordType(_, fields) => {
        if (inits.length > rt.fields.length)
          throw SalException(s"too many arguments when creating $id.") // format later

        val namedInit = inits.filter((i) => !i.param._1.isEmpty).map((i) => (i.param._1.get, i.param._2)).toMap
        val defaultInit = inits.filter((i) => i.param._1.isEmpty).map((i) => i.param._2).iterator

        namedInit.foreach((i) => if (!rt.contains(i._1)) throw SalException(s"${i._1} is not a member of $id."))

        fields.foreach((f) =>
          if (namedInit.contains(f._1)) {
            if (namedInit(f._1).salType !== f._2)
              throw SalException(s"${f._1} requires ${f._2}, but got ${namedInit(f._1).salType}.") // format later
          }
          else if (defaultInit.hasNext) {
            val node = defaultInit.next()
            if (node.salType !== f._2)
              throw SalException(s"${f._1} requires ${f._2}, but got ${node.salType}.") // format later
          }
        )

        (rt, inits)
      }
        
      case _ => throw SalException(s"$id is not a record.") // format later
    }
    catch {
      case SalException(info) => {
        report(info, at(ctx))
        (RecordType("", List()), List()) // shield other type checking.
      }
    }

  def checkIfElse(ctx: ParserRuleContext, expType: Type) =
    if (expType !== boolType)
      report(s"if/else if requires bool, but got $expType", at(ctx))

  def checkLambda(ctx: ParserRuleContext, expType: Type, retType: Type) =
    if (retType !== expType)
      report(s"return value of lambda got $expType, but $retType is required.", at(ctx))

  def excludeNix(ctx: ParserRuleContext, node: ExpressionNode): Unit = node.exp match {
    case UnOpExpression(exp, _, _) => excludeNix(ctx, exp)
    case BiOpExpression(lhs, rhs, _, _) => {
      excludeNix(ctx, lhs)
      excludeNix(ctx, rhs)
    }
    case LitNode(lit) if (lit.equals("nix")) => report(s"can't use nix as operands.", at(ctx))
    case _ => {}
  }

  def checkIndex(ctx: ParserRuleContext, parentType: Type, lit: LitNode): Boolean =
    lit.salType match {
      case BuiltInType(name) if (name.equals("int")) => parentType match {
        case TupleType(fields) => {
          val index = lit.toInt
          if (index > -1 && index < fields.length) true
          else { report("tuple index out of range.", at(ctx)); false }
        }
        case _ => { report("indexing is not support.", at(ctx)); false }
      }
      case _ => report("only int can be used for indexing.", at(ctx)); false
    }

  def mixRecords(ctx: ParserRuleContext, from: List[FieldNode], withList: List[String])(implicit typeCtx: Context) =
    withList.foldLeft(from)((res, name) => (try typeCtx?name catch {
      case SalException(info) => {
        report(info, at(ctx))
        anythingType // shield other type checking.
      }
    }) match {
      case RecordType(_, fields) => fields.foldLeft(res)((lst, f) =>
        if (from.exists(node => node.id.equals(f._1))) {
          report(s"the field ${f._1} has existed in $name", at(ctx))
          lst
        }
        else (FieldNode(f._1, TypeNameNode(f._2)) +: lst)
      )
      case _ => res
    })
}

object Typer {
  def apply() = new Typer()

  private def at(ctx: ParserRuleContext) = ctx.getStart().getLine()

  private def matchApplicationType(fun: Type, index: Int)(implicit funcNode: ExpressionNode, params: List[ExpressionNode]): Type = fun match {
    case FunctionType(p, r, _) =>
      if (p === voidType && params.isEmpty) r
      else if (index == params.length - 1)
        if (p === params(index).salType) r
        else throw SalException(s"${funcNode.toLua(0)}'s parameters[$index] requires $p, but got ${params(index).salType}.")
      else
        if (p === params(index).salType) matchApplicationType(r, index + 1)
        else throw SalException(s"${funcNode.toLua(0)}'s parameters[$index] requires $p, but got ${params(index).salType}.")
    case _ => throw SalException(s"${funcNode.toLua(0)} is not a function.")
  }
}
