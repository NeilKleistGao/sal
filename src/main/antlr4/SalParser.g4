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

value: VAL_KW ID COLON_OP typeName ASSIGN_OP expression;

expression: lit | ID;

functionBody: block | expression;

param: ID COLON_OP typeName;

params: (LEFT_PARENTHESE RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param (COMMA_OP param)* RIGHT_PARENTHESE);

function: FUN_KW ID params COLON_OP typeName ASSIGN_OP functionBody;