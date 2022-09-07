parser grammar SalParser;

@header {
  package sal.parser;
}

options { tokenVocab=SalLexer; }

lit: NUMBER | TRUE_LIT | FALSE_LIT | STRING_LIT | NIX_LIT;

program: statement* EOF;

statement: value | function | application | record | ifCondition; // here, application is for void function application

blockInner: statement | expression;

block: LEFT_BRACES (blockInner)* RIGHT_BRACES;

typeName: INT_KW | FLOAT_KW | BOOL_KW | STRING_KW | VOID_KW | ANY_KW;
allTypes: LEFT_PARENTHESE allTypes RIGHT_PARENTHESE |
          allTypes BIT_OR_OP allTypes |<assoc=right> allTypes ARROW_OP allTypes | ID | typeName;

value: VAL_KW ID COLON_OP allTypes ASSIGN_OP expression |
       VAL_KW ID ASSIGN_OP expression;

expression: lit | ID | create | ifCondition | expression AS_KW allTypes | lambda |
             expression LEFT_PARENTHESE RIGHT_PARENTHESE                                   | // application
             expression LEFT_PARENTHESE expression (COMMA_OP expression)* RIGHT_PARENTHESE |
             expression DOT_OP ID                                                          | // access
             LEFT_PARENTHESE expression RIGHT_PARENTHESE                                   |
             expression POW_OP expression                                                  |
             (LOGIC_NOT_OP | BIT_NOT_OP) expression                                        |
             expression (MUL_OP | DIV_OP | MOD_OP) expression                              |
             expression (ADD_OP | SUB_OP) expression                                       |
             expression (LEFT_SHIFT_OP | RIGHT_SHIFT_OP) expression                        |
             expression BIT_AND_OP expression                                              |
             expression BIT_XOR_OP expression                                              |
             expression BIT_OR_OP expression                                               |
             expression LOGIC_AND_OP expression                                            |
             expression LOGIC_OR_OP expression;

functionBody: block | expression;

param: ID COLON_OP allTypes | ID;

params: (LEFT_PARENTHESE RIGHT_PARENTHESE) |
        (LEFT_PARENTHESE param (COMMA_OP param)* RIGHT_PARENTHESE);

field: ID COLON_OP allTypes | function | ID COLON_OP allTypes ASSIGN_OP expression;

fields: field (COMMA_OP field)*;

function: FUN_KW ID params COLON_OP allTypes ASSIGN_OP functionBody |
          FUN_KW ID params ASSIGN_OP functionBody;

application: expression LEFT_PARENTHESE RIGHT_PARENTHESE |
             expression LEFT_PARENTHESE expression (COMMA_OP expression)* RIGHT_PARENTHESE;

record: REC_KW ID LEFT_BRACES RIGHT_BRACES |
        REC_KW ID LEFT_BRACES fields RIGHT_BRACES;

initializer: ID ASSIGN_OP expression | expression;

create: NEW_KW ID LEFT_BRACES RIGHT_BRACES |
        NEW_KW ID LEFT_BRACES initializer (COMMA_OP initializer)* RIGHT_BRACES;

ifCondition: IF_KW LEFT_PARENTHESE expression RIGHT_PARENTHESE (block | expression) (elseIfCondition)* elseBlock?;
elseIfCondition: ELSE_KW IF_KW LEFT_PARENTHESE expression RIGHT_PARENTHESE (block | expression);
elseBlock: ELSE_KW (block | expression);

lambda: FUN_KW params COLON_OP allTypes ASSIGN_OP expression |
        FUN_KW params ASSIGN_OP expression;