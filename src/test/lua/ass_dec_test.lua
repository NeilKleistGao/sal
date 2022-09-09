local x = 42 --[[type: anything.]]
local y = x --[[type: int.]]
local x2 = (3.14) + (6.28) --[[type: anything.]]
local y2 = x2 --[[type: float.]]
local x3 = "xxx" --[[type: string.]]
local y3 = x3 --[[type: string.]]
function add(x, y) --[[type: int -> int -> int.]]
  return (x) + (y)
end
local f = add --[[type: anything.]]
local add2 = f --[[type: int -> int -> int.]]
local n = nil --[[type: string | bool.]]
local s = n --[[type: string.]]
local b = n --[[type: bool.]]
local s42 = tostring(x) --[[type: string.]]
local pi = tonumber("3.14159265") --[[type: float.]]
local c = (tonumber("42")) - (tonumber(13)) --[[type: int.]]
print(type(c))
