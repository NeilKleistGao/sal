function f(x)
  return x
end
local x = f(42) --[[type: int]]
function g(x, y)
  return y
end
local hg = function(p) return g(42, p) end --[[type: string -> string]]
local s = hg("rua") --[[type: string]]
function h()
  return false
end
local fs = h() --[[type: bool]]
function m()
  local res = nil
  function f(x)
    return x
  end
  res = f
  return res
end
local innerF = function(p) return m(p) end --[[type: int -> int]]
local res = innerF(42) --[[type: int]]
function foo(x, y, z)
  local res = nil
  return res
end
local bar = function(p, p_) return foo(42, p, p_) end --[[type: int -> int -> void]]
print("hello world!")
local p = 1 --[[type: int]]
function foofoo(x, y)
  local res = nil
  return res
end
local barbar = function(p_) return foofoo(p, p_) end --[[type: int -> void]]
function n(x, y, z)
  return 42
end
local v42 = n(1, 2, 3) --[[type: int]]
local v42f = function(p_) return n(4, 5, p_) end --[[type: int -> int]]
