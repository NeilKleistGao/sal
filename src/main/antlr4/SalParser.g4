parser grammar SalParser;

@header {
  package sal.parser;
}

options { tokenVocab=SalLexer; }

lit: NUMBER | TRUE_LIT | FALSE_LIT;

program: statement* EOF;

statement: value;

typeName: INT_KW | FLOAT_KW | BOOL_KW;

value: VAL_KW ID COLON_OP typeName ASSIGN_OP expression;

expression: lit;