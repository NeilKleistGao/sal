local if_res = nil
if (true) then
  (print)("hello")
else
  (print)("world")
end
local if_res_ = nil
if (false) then
  local x = 41 --[[type: int]]
  (print)(x)
end
local x = false --[[type: bool]]
local y = true --[[type: bool]]
local if_res__ = nil
if (x) then
  (print)("x")
elseif (y) then
  (print)("y")
else
  (print)("z")
end
