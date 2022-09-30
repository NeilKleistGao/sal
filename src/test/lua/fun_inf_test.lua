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
 --[type: anything -> anything -> string.]
function high(x)
local res = nil
  function inner(y)
    return x
  end
 --[type: anything -> int.]
res = inner
return res
end
 --[type: int -> anything -> int.]
function hgih(x)
local res = nil
  function outer(y)
    return x
  end
 --[type: float -> anything.]
res = outer
return res
end
 --[type: anything -> float -> anything.]
function n()
local res = nil
  local x = 42
 --[type: int.]
res = x
return res
end
 --[type: void -> int.]
function fact(x)
  return (function()
  local if_res = nil
  if ((x) < (2)) then
    if_res = 1
  else
    if_res = (fact((x) - (1))) * (x)
  end
  return if_res
end)()
end
 --[type: int -> int.]
