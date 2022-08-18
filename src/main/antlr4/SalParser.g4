parser grammar SalParser;

@header {
  package sal.parser;
}

options { tokenVocab=SalLexer; }

lit: NUMBER | TRUE_LIT | FALSE_LIT | STRING_LIT;

program: statement* EOF;

statement: value;

block: LEFT_BRACES statement* RIGHT_BRACES;

typeName: INT_KW | FLOAT_KW | BOOL_KW | STRING_KW;

value: VAL_KW ID COLON_OP typeName ASSIGN_OP expression;

expression: lit;

functionBody: statement | block;

param: ID COLON_OP typeName;

params: (LEFT_PARENTHESE RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param (COMMA_OP param)* RIGHT_PARENTHESE);

function: FUN_KW ID params COLON_OP typeName ASSIGN_OP functionBody;