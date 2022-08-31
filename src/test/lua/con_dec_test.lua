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
local num = (function()
  local if_res___ = nil
  if (true) then
    if_res___ = 42
  else
    if_res___ = 1
  end
  return if_res___
end)() --[[type: int]]
local str = (function()
  local if_res____ = nil
  if (x) then
    if_res____ = ("res: ") .. ("x")
  elseif (y) then
    if_res____ = ("res: ") .. ("y")
  else
    if_res____ = ("res: ") .. ("z")
  end
  return if_res____
end)() --[[type: string]]
local if_res_____ = nil
if (true) then
  if_res_____ = false
end
local if_res______ = nil
if (true) then
  if_res______ = 1
elseif (false) then
  if_res______ = 2
end
