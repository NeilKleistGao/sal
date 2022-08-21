function f(x)
  return x
end
local x = f(42)
function g(x, y)
  return y
end
local hg = function(p) return g(42, p) end
local s = hg("rua")
function h()
  return false
end
local fs = h()
function m()
  local res = nil
  function f(x)
    return x
  end
  res = f
  return res
end
local innerF = function(p) return m(p) end
local res = innerF(42)
function foo(x, y, z)
  local res = nil
  return res
end
local bar = function(p, p_) return foo(42, p, p_) end
print("hello world!")
