lexer grammar SalLexer;

@header {
  package sal.parser;
}

WS: [ \t\r\n]+ -> skip;
NUMBER: ('0' .. '9') + ('.' ('0' .. '9') +)?;
COLON_OP: ':';
ASSIGN_OP: '=';

ID: [a-zA-Z_][a-zA-Z_0-9]*;

VAL_KW: 'val';
INT_KW: 'int';