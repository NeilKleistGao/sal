function f(x)
  return x
end
 --[type: int -> int.]
local x = f(42)
 --[type: int.]
function g(x, y)
  return y
end
 --[type: anything -> string -> string.]
local hg = function(p) return g(42, p) end
 --[type: string -> string.]
local s = hg("rua")
 --[type: string.]
function h()
  return false
end
 --[type: void -> bool.]
local fs = h()
 --[type: bool.]
function m()
local res = nil
  function f(x)
    return x
  end
 --[type: int -> int.]
res = f
return res
end
 --[type: void -> int -> int.]
local innerF = m()
 --[type: int -> int.]
local res = innerF(42)
 --[type: int.]
function foo(x, y, z)
local res = nil

return res
end
 --[type: int -> int -> int -> void.]
local bar = function(p, p_) return foo(42, p, p_) end
 --[type: int -> int -> void.]
print("hello world!")
local p = 1
 --[type: int.]
function foofoo(x, y)
local res = nil

return res
end
 --[type: int -> int -> void.]
local barbar = function(p_) return foofoo(p, p_) end
 --[type: int -> void.]
function n(x, y, z)
  return 42
end
 --[type: int -> int -> int -> int.]
local v42 = n(1, 2, 3)
 --[type: int.]
local v42f = function(p_) return n(4, 5, p_) end
 --[type: int -> int.]
local mf = (m())(42)
 --[type: int.]
function temp(x)
local res = nil
  function gg(y, z)
    return (y) | ((z) & (x))
  end
 --[type: int -> int -> int.]
res = function(p) return gg(2, p) end
return res
end
 --[type: int -> int -> int.]
local temptemp = (temp(1))(3)
 --[type: int.]
function triple(x, y, z)
local res = nil

return res
end
 --[type: anything -> anything -> anything -> void.]
(function(p_) return (function(p_, p__) return triple(1, p_, p__) end)(2, p_) end)(3)
assert(true, "abc")
local mt = getmetatable(temptemp)
 --[type: anything.]
print(_VERSION)
