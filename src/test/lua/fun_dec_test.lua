function f()
  return 42
end
 --[type: void -> int.]
function g()
local res = nil
  local x = false
 --[type: bool.]
res = "wuwuwu"
return res
end
 --[type: void -> string.]
function h(x)
  return x
end
 --[type: bool -> bool.]
function m(x, y)
  return ""
end
 --[type: int -> float -> string.]
function n()
local res = nil
  local x = 1.0
 --[type: float.]
return res
end
 --[type: void -> void.]
function p(x)
  return x
end
 --[type: int -> anything.]
function q()
local res = nil
  local x = 4.2
 --[type: float.]
  local _ = false
res = x
return res
end
 --[type: void -> float.]
function r()
  return true
end
 --[type: void -> anything.]
function s()
local res = nil
  local y = nil
 --[type: string.]
return res
end
 --[type: void -> anything.]
function noFun()
local res = nil

return res
end
 --[type: void -> void.]
local xx = h
 --[type: bool -> bool.]
local yy = f
 --[type: void -> int.]
function high(f)
  return f
end
 --[type: (int -> int) -> int -> int.]
function high2()
local res = nil
  function inner()
    return "rua"
  end
 --[type: void -> string.]
res = inner
return res
end
 --[type: void -> void -> string.]
function high3()
local res = nil
  function f(x)
    return "VG is always your home!"
  end
 --[type: bool -> string.]
res = f
return res
end
 --[type: void -> bool -> string.]
function high4()
  return f
end
 --[type: void -> void -> int.]
function highhhh()
local res = nil
  function f()
    return g
  end
 --[type: void -> anything.]
res = f
return res
end
 --[type: void -> anything.]
local mmm = m
 --[type: int -> float -> string.]
local mmm2 = m
 --[type: int -> float -> string.]
local mmm3 = m
 --[type: int -> float -> string.]
local pHigh = high
 --[type: (int -> int) -> int -> int.]
local pHigh2 = high2
 --[type: void -> void -> string.]
local pHigh3 = high
 --[type: (int -> int) -> int -> int.]
function overload(x, y)
  return 1.0
end
 --[type: int | float -> bool -> float.]
local overF = overload(2, false)
 --[type: float.]
function hp(x, y)
  return function(z) return ((x) + (y)) + (z) end
end
 --[type: int -> int -> int -> int.]
local res_hp = (hp(1, 2))(3)
 --[type: int.]
function voidOne(x)
  return function() return x end
end
 --[type: int -> void -> int.]
local xxx = (voidOne(42))()
 --[type: int.]
