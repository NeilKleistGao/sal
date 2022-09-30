local t1 = {1, 2, 3}
 --[type: [int, int, int].]
local t2 = {"abc", 42}
 --[type: [string, int].]
function printTuple(x)
  return print(x)
end
 --[type: [string, int] -> void.]
function throwErr(code, err)
  return {code, err}
end
 --[type: int -> string -> [int, string].]
local v42 = t2[2]
 --[type: int.]
function swap(x)
  return {x[2], x[1]}
end
 --[type: [int, string] -> [string, int].]
local funcs = {function(x) return x end, function(x, y) return (x) + (y) end}
 --[type: [anything -> anything, int -> int -> int].]
