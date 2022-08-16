lexer grammar SalLexer;

@header {
  package sal.parser;
}

VAL_KW: 'val';
INT_KW: 'int';
FLOAT_KW: 'float';
BOOL_KW: 'bool';
STRING_KW: 'string';

TRUE_LIT: 'true';
FALSE_LIT: 'false';

STRING_LIT: '"' ('\\"'|~["])* '"';

WS: [ \t\n]+ -> skip;
NUMBER: ('0' .. '9') + ('.' ('0' .. '9') +)?;
COLON_OP: ':';
ASSIGN_OP: '=';

ID: [a-zA-Z_][a-zA-Z_0-9]*;