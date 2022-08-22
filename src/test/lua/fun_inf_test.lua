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
function m(x, y) --[[type: anything -> anything -> string]]
  return ""
end
