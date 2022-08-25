Empty = {

}
Num = {
  x = nil,
  y = nil
}
WithDefault = {
  s = "ez"
}
Interface = {
  f =
    function (x, y) --[[type: int -> int -> int]]
      return 42
    end
}
local ez = {
  s = WithDefault.s
} --[[type: rec WithDefault]]
local func = {
  f = Interface.f
} --[[type: rec Interface]]
local n1 = {
  x = 1,
  y = 2
} --[[type: rec Num]]
local n2 = {
  x = 1,
  y = Num.y
} --[[type: rec Num]]
local n3 = {
  x = 3,
  y = 4
} --[[type: rec Num]]
local n4 = {
  x = 4,
  y = 3
} --[[type: rec Num]]
local n5 = {
  x = 3,
  y = 4
} --[[type: rec Num]]
local n6 = {
  x = 4,
  y = 3
} --[[type: rec Num]]
local n7 = {
  x = 5,
  y = Num.y
} --[[type: rec Num]]
local n8 = {
  x = Num.x,
  y = 6
} --[[type: rec Num]]
