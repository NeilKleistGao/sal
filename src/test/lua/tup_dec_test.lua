local t1 = {1, 2, 3} --[[type: [int, int, int].]]
local t2 = {"abc", 42} --[[type: [string, int].]]
function printTuple(x) --[[type: [string, int] -> void.]]
  return print(x)
end
function throwErr(code, err) --[[type: int -> string -> [int, string].]]
  return {code, err}
end
local v42 = t2[2] --[[type: int.]]
function swap(x) --[[type: [int, string] -> [string, int].]]
  return {x[2], x[1]}
end
