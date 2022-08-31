function f() --[[type: void -> int]]
  return 42
end
function g() --[[type: void -> string]]
  local res = nil
  local x = false --[[type: bool]]
  res = "wuwuwu"
  return res
end
function h(x) --[[type: bool -> bool]]
  return x
end
function m(x, y) --[[type: int -> float -> string]]
  return ""
end
function n() --[[type: void -> void]]
  local res = nil
  local x = 1.0 --[[type: float]]
  return res
end
function p(x) --[[type: int -> anything]]
  return x
end
function q() --[[type: void -> float]]
  local res = nil
  local x = 4.2 --[[type: float]]
  local _ = false
  res = x
  return res
end
function r() --[[type: void -> anything]]
  return true
end
function s() --[[type: void -> anything]]
  local res = nil
  local y = nil --[[type: string]]
  return res
end
function noFun() --[[type: void -> void]]
  local res = nil
  return res
end
local xx = h --[[type: bool -> bool]]
local yy = f --[[type: void -> int]]
function high(f) --[[type: (int -> int) -> int -> int]]
  return f
end
function high2() --[[type: void -> void -> string]]
  local res = nil
  function inner() --[[type: void -> string]]
    return "rua"
  end
  res = inner
  return res
end
function high3() --[[type: void -> bool -> string]]
  local res = nil
  function f(x) --[[type: bool -> string]]
    return "VG is always your home!"
  end
  res = f
  return res
end
function high4() --[[type: void -> void -> int]]
  return f
end
function highhhh() --[[type: void -> anything]]
  local res = nil
  function f() --[[type: void -> anything]]
    return g
  end
  res = f
  return res
end
local mmm = m --[[type: int -> float -> string]]
local mmm2 = m --[[type: int -> float -> string]]
local mmm3 = m --[[type: int -> float -> string]]
local pHigh = high --[[type: (int -> int) -> int -> int]]
local pHigh2 = high2 --[[type: void -> void -> string]]
local pHigh3 = high --[[type: (int -> int) -> int -> int]]
function overload(x, y) --[[type: int | float -> bool -> float]]
  return 1.0
end
local overF = (overload)(2, false) --[[type: float]]
