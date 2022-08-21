function f(x)
  return x
end
local x = f(42)
function g(x, y)
  return y
end
local hg = function(p) return g(42, p) end
local s = hg("rua")
