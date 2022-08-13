lexer grammar SalLexer;

WS: [ \t\r\n]+ -> skip;
NUMBER: ('0' .. '9') + ('.' ('0' .. '9') +)?;