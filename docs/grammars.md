# Grammars Docs
## Constant Values
Everything in `sal` is constant:

```lua
val x: int = 10
val y = "abc"
x = 20 // wrong!
```

## Functions
You can create a function like this:
```lua
fun add(x: int, y: int) = x + y
```

This is equal to:
```lua
val add: (int -> int -> int) = fun(x, y) => x + y
// or
// val add = fun(x: int, y: int) => x + y
```

## Records
You can declare a record to contain several variables at the same time:
```lua
rec Foo {
  bar: int,
  f: float,
  s: string
}
```

When you create an instance of a record, you need to provide all parameters:
```lua
val foo = new Foo(42, 3.14, "foo")
```

Or like this:
```lua
val foo = new Foo(f=3.14, s="foo", bar=42)
```

## Types
You can define a new type:
```lua
type NewType = int | string
type NewRec = Foo & Bar 
```

## If/Else
You can use `if`/`else if`/`else` in `sal`:
```lua
val x = if (y == 20) "ok" else "nop"

if (z) {
  // do something
}
else if (y > 10) {
  // do something
}
else {
  // do something
}
```

Notably, there is no loop in `sal`, please use recursive functions instead.

## Pattern Matching
`sal` has a scala-styled pattern matching:
```lua
some_val match {
  case nil => print("1")
  case SomeRec(a, b, _, d) => print(d)
  case _ => print("err")
}
```

## Type variables
Type variables are supported:
```lua
type Option<T> = T | Nil
val x: Option<string> = "abcd"
val y: Option<string> = nil
```