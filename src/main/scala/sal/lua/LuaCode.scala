package sal.lua

import sal.lua._

sealed trait LuaCode {
  def show(implicit indent: String): String = ???
}

case class LuaProgram(statements: List[LuaCode]) extends LuaCode {
  override def show(implicit indent: String): String =
    statements.foldLeft("")((r, c) => s"$r${c.show}\n")
}

case class LuaAssign(name: String, value: LuaCode, isLocal: Boolean) extends LuaCode {
  override def show(implicit indent: String): String = {
    val text = s"$name = ${value.show("")}"
    if (isLocal) s"${indent}local $text"
    else s"$indent$text"
  }
}

case class LuaBlock(codes: List[LuaCode]) extends LuaCode {
  override def show(implicit indent: String): String = {
    val res = codes.foldLeft("")((r, c) => s"$r${c.show(indent + spaces)}\n")
    if (res.isEmpty()) res else res.dropRight(1)
  }
}

case class LuaFunction(name: String, params: List[String]) extends LuaCode {
  private lazy val paramsString =
    if (params.isEmpty) ""
    else params.reduceLeft((s, p) => s"$s, $p")

  override def show(implicit indent: String): String =
    if (name.isEmpty()) s"${indent}function($paramsString)"
    else s"${indent}function $name($paramsString)"
}

case class LuaLit(value: String) extends LuaCode {
  override def show(implicit indent: String): String = s"$indent$value"
}

case class LuaApplication(fun: LuaCode, params: List[LuaCode]) extends LuaCode {
  private lazy val paramsString =
    if (params.isEmpty) ""
    else params.map(p => p.show("")).reduceLeft((s, p) => s"$s, $p")

  override def show(implicit indent: String): String = fun match {
    case LuaVariable(name) => s"$name($paramsString)"
    case _ => s"(${fun.show})($paramsString)"
  }
}

case class LuaReturn(res: LuaCode) extends LuaCode {
  override def show(implicit indent: String): String =
    s"${indent}return ${res.show("")}"
}

case class LuaIf(cond: LuaCode, isElseIf: Boolean) extends LuaCode {
  override def show(implicit indent: String): String =
    if (!isElseIf) s"${indent}if (${cond.show("")}) then"
    else s"${indent}elseif (${cond.show("")}) then"
}

case class LuaVariable(name: String) extends LuaCode {
  override def show(implicit indent: String): String = s"$indent$name"
}

case class LuaIndex(obj: LuaCode, index: LuaCode) extends LuaCode {
  override def show(implicit indent: String): String = s"${obj.show}[${index.show("")}]"
}

case class LuaUnaryOperator(op: String, exp: LuaCode) extends LuaCode {
  override def show(implicit indent: String): String = s"$indent$op(${exp.show})"
}

case class LuaBinaryOperator(op: String, lhs: LuaCode, rhs: LuaCode) extends LuaCode {
  override def show(implicit indent: String): String = s"$indent(${lhs.show("")}) $op (${rhs.show("")})"
}

case class LuaTable(fields: List[LuaFieldType], isInline: Boolean) extends LuaCode {
  override def show(implicit indent: String): String =
    if (fields.isEmpty) s"$indent{}"
    else {
      val split = if (isInline) ", " else ",\n"
      val fs = fields.map(ft =>
        if (isInline)
          s"${ft._2.show("")}"
        else
          s"${indent + spaces}${ft._1} = ${ft._2.show("")}"
      ).reduceLeft((r, s) => s"$r$split$s")

      if (isInline) s"$indent{$fs}"
      else s"$indent{\n$fs\n$indent}"
    }
}

case class LuaComments(content: String) extends LuaCode {
  override def show(implicit indent: String): String = s" --[$content]"
}

case class LuaSequence(codes: List[LuaCode]) extends LuaCode {
  override def show(implicit indent: String): String = {
    val res = codes.foldLeft("")((r, c) => s"$r${c.show}\n")
    if (res.isEmpty()) res else res.dropRight(1)
  }
}

case class LuaSelection(parent: LuaCode, field: String) extends LuaCode {
  override def show(implicit indent: String): String = parent match {
    case LuaVariable(name) => s"${parent.show}.$field"
    case _ => s"(${parent.show}).$field"
  }
}

case class LuaInlineFunction(params: List[String], exp: LuaCode) extends LuaCode {
  private lazy val paramsString =
    if (params.isEmpty) ""
    else params.reduceLeft((s, p) => s"$s, $p")

  override def show(implicit indent: String): String =
    s"${indent}function($paramsString) ${exp.show("")} end"
}

case object LuaElse extends LuaCode {
  override def show(implicit indent: String): String = s"${indent}else"
}

case object LuaEnd extends LuaCode {
  override def show(implicit indent: String): String = s"${indent}end"
}
