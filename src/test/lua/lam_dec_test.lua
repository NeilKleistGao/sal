local f1 = (function (x, y) return (x) + (y) end) --[[type: int -> int -> int]]
local f2 = (function () return 42 end) --[[type: void -> int]]
local f3 = (function (x) print(x) end) --[[type: string -> void]]
