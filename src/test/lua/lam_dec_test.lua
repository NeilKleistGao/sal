local f1 = function(x, y) return (x) + (y) end
 --[type: int -> int -> int.]
local f2 = function() return 42 end
 --[type: void -> int.]
local f3 = function(x) print(x) end
 --[type: string -> void.]
local f4 = function(x) return function(y) return (x) + (y) end end
 --[type: int -> float -> float.]
local f5 = function(x) return x end
 --[type: anything -> anything.]
