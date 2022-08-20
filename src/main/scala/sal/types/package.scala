package sal

package object types {
  lazy val intType = types.BuiltInType("int")
  lazy val floatType = types.BuiltInType("float")
  lazy val boolType = types.BuiltInType("bool")
  lazy val stringType = types.BuiltInType("string")
  lazy val voidType = types.BuiltInType("void")
  lazy val anythingType = types.BuiltInType("anything")
}