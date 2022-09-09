local t1 = {1, 2, 3} --[[type: [int, int, int].]]
local t2 = {"abc", 42} --[[type: [string, int].]]
function printTuple(x) --[[type: [string, int] -> void.]]
  return print(x)
end
function throwErr(code, err) --[[type: int -> string -> [int, string].]]
  return {code, err}
end
