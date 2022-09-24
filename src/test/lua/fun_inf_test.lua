function f() --[[type: void -> int.]]
  return 42
end
function g() --[[type: void -> string.]]
  local res = nil
  local x = false --[[type: bool.]]
  res = "wuwuwu"
  return res
end
function h(x) --[[type: bool -> bool.]]
  return x
end
function m(x, y) --[[type: anything -> anything -> string.]]
  return ""
end
function high(x) --[[type: int -> anything -> int.]]
  local res = nil
  function inner(y) --[[type: anything -> int.]]
    return x
  end
  res = inner
  return res
end
function hgih(x) --[[type: anything -> float -> anything.]]
  local res = nil
  function outer(y) --[[type: float -> anything.]]
    return x
  end
  res = outer
  return res
end
function n() --[[type: void -> int.]]
  local res = nil
  local x = 42 --[[type: int.]]
  res = x
  return res
end

function fact(x) --[[type: int -> int.]]
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
