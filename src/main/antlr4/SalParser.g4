parser grammar SalParser;

@header {
  package sal.parser;
}

options { tokenVocab=SalLexer; }

lit: NUMBER | TRUE_LIT | FALSE_LIT | STRING_LIT | NIX_LIT;

program: statement* EOF;

statement: value | function;

blockInner: statement | expression;

block: LEFT_BRACES (blockInner)* RIGHT_BRACES;

typeName: INT_KW | FLOAT_KW | BOOL_KW | STRING_KW | VOID_KW | ANY_KW;
allTypes: typeName | typeName ARROW_OP allTypes | LEFT_PARENTHESE allTypes RIGHT_PARENTHESE |
          LEFT_PARENTHESE allTypes ARROW_OP allTypes RIGHT_PARENTHESE;

value: VAL_KW ID COLON_OP allTypes ASSIGN_OP expression;

expression: lit | ID;

functionBody: block | expression;

param: ID COLON_OP allTypes;

params: (LEFT_PARENTHESE RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param (COMMA_OP param)* RIGHT_PARENTHESE);

function: FUN_KW ID params COLON_OP allTypes ASSIGN_OP functionBody;