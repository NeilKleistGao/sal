local x = 10
 --[type: int.]
local y = 3.14
 --[type: float.]
local z1 = false
 --[type: bool.]
local z2 = true
 --[type: bool.]
local w = "\"abc\""
 --[type: string.]
local n1 = nil
 --[type: anything.]
function f(x)
local res = nil
  local y = x
 --[type: int.]
return res
end
 --[type: int -> void.]
function g()
  return 3.14
end
 --[type: void -> float.]
local pi = g()
 --[type: float.]
function h(x, y)
local res = nil
  function hh(xx)
    return y
  end
 --[type: string -> bool.]
res = hh
return res
end
 --[type: string -> bool -> string -> bool.]
local hh = h
 --[type: string -> bool -> string -> bool.]
local hhh = function(p) return h("rua", p) end
 --[type: bool -> string -> bool.]
local hhhh = hh("rua", false)
 --[type: string -> bool.]
