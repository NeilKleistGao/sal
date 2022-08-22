function f()
  return 42
end
function g()
  local res = nil
  local x = false --[[type: bool]]
  res = "wuwuwu"
  return res
end
function h(x)
  return x
end
function m(x, y)
  return ""
end
function n()
  local res = nil
  local x = 1.0 --[[type: float]]
  return res
end
function p(x)
  return x
end
function q()
  local res = nil
  local x = 4.2 --[[type: float]]
  local _ = false
  res = x
  return res
end
function r()
  return true
end
function s()
  local res = nil
  local y = nil --[[type: string]]
  return res
end
function noFun()
  local res = nil
  return res
end
local xx = h --[[type: bool -> bool]]
local yy = f --[[type: void -> int]]
function high(f)
  return f
end
function high2()
  local res = nil
  function inner()
    return "rua"
  end
  res = inner
  return res
end
function high3()
  local res = nil
  function f(x)
    return "VG is always your home!"
  end
  res = f
  return res
end
function high4()
  return f
end
function highhhh()
  local res = nil
  function f()
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
