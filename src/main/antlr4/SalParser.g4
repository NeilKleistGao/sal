parser grammar SalParser;

@header {
  package sal.parser;
}

options { tokenVocab=SalLexer; }

lit: NUMBER | TRUE_LIT | FALSE_LIT | STRING_LIT | NIX_LIT;

program: statement* EOF;

statement: value | function | application | record; // here, application is for void function application

blockInner: statement | expression;

block: LEFT_BRACES (blockInner)* RIGHT_BRACES;

typeName: INT_KW | FLOAT_KW | BOOL_KW | STRING_KW | VOID_KW | ANY_KW;
allTypes: typeName | typeName ARROW_OP allTypes | LEFT_PARENTHESE allTypes RIGHT_PARENTHESE |
          LEFT_PARENTHESE allTypes RIGHT_PARENTHESE ARROW_OP allTypes;

value: VAL_KW ID COLON_OP allTypes ASSIGN_OP expression |
       VAL_KW ID ASSIGN_OP expression;

expression: lit | ID | application | access | create;

functionBody: block | expression;

param: ID COLON_OP allTypes | ID;

params: (LEFT_PARENTHESE RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param (COMMA_OP param)* RIGHT_PARENTHESE);

field: ID COLON_OP allTypes | function | ID COLON_OP allTypes ASSIGN_OP expression;

fields: field (COMMA_OP field)*;

function: FUN_KW ID params COLON_OP allTypes ASSIGN_OP functionBody |
          FUN_KW ID params ASSIGN_OP functionBody;

application: ID LEFT_PARENTHESE RIGHT_PARENTHESE |
             ID LEFT_PARENTHESE expression (COMMA_OP expression)* RIGHT_PARENTHESE;

record: REC_KW ID LEFT_BRACES RIGHT_BRACES |
        REC_KW ID LEFT_BRACES fields RIGHT_BRACES;

access: ID DOT_OP ID;

initializer: ID ASSIGN_OP expression | expression;

create: NEW_KW ID LEFT_BRACES RIGHT_BRACES |
        NEW_KW ID LEFT_BRACES initializer (COMMA_OP initializer)* RIGHT_BRACES;