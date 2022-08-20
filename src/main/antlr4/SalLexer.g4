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

ID: [a-zA-Z_][a-zA-Z_0-9]*;