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
