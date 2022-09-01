lexer grammar SalLexer;

@header {
  package sal.parser;
}

VAL_KW: 'val';
INT_KW: 'int';
FLOAT_KW: 'float';
BOOL_KW: 'bool';
STRING_KW: 'string';
FUN_KW: 'fun';
VOID_KW: 'void';
ANY_KW: 'anything';
REC_KW: 'rec';
NEW_KW: 'new';
IF_KW: 'if';
ELSE_KW: 'else';
AS_KW: 'as';

TRUE_LIT: 'true';
FALSE_LIT: 'false';
NIX_LIT: 'nix';

STRING_LIT: '"' ('\\"'|~["])* '"';

LEFT_BRACES: '{';
RIGHT_BRACES: '}';
LEFT_PARENTHESE: '(';
RIGHT_PARENTHESE: ')';

WS: [ \t\n]+ -> skip;
NUMBER: ('0' .. '9') + ('.' ('0' .. '9') +)?;
COLON_OP: ':';
ASSIGN_OP: '=';
COMMA_OP: ',';
ARROW_OP: '->';
DOT_OP: '.';
BIT_AND_OP: '&';
BIT_OR_OP: '|';
BIT_NOT_OP: '~';
BIT_XOR_OP: '^';
LEFT_SHIFT_OP: '<<';
RIGHT_SHIFT_OP: '>>';
LOGIC_AND_OP: '&&';
LOGIC_OR_OP: '||';
LOGIC_NOT_OP: '!';
ADD_OP: '+';
SUB_OP: '-';
MUL_OP: '*';
DIV_OP: '/';
MOD_OP: '%';
POW_OP: '^^';

ID: [a-zA-Z_][a-zA-Z_0-9]*;