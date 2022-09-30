local x = (true) and (false)
 --[type: bool.]
local y = (x) or (true)
 --[type: bool.]
local z = not(y)
 --[type: bool.]
local w = (2) << (3)
 --[type: int.]
local m = (9) >> (1)
 --[type: int.]
local n = (w) & (m)
 --[type: int.]
local p = (w) | (m)
 --[type: int.]
local q = (w) ~ (m)
 --[type: int.]
local r = ~(q)
 --[type: int.]
local a = ((1) + (2)) - (3)
 --[type: int.]
local b = ((3) * (4)) % (5)
 --[type: int.]
local c = (2.3) * (1.2)
 --[type: float.]
local d = (5) // (2)
 --[type: int.]
local e = (5.0) / (2)
 --[type: float.]
local f = (5) / (2.0)
 --[type: float.]
local g = (12) % (5)
 --[type: int.]
local h = ("abc") .. ("def")
 --[type: string.]
local nop = (function()
  local if_res = nil
  if ((1) > (2)) then
    if_res = false
  else
    if_res = true
  end
  return if_res
end)()
 --[type: bool.]
local yep = (function()
  local if_res_ = nil
  if ((3.14) > (0)) then
    if_res_ = true
  else
    if_res_ = false
  end
  return if_res_
end)()
 --[type: bool.]
local ss = ("abc") > ("ab")
 --[type: bool.]
