grammar Expression;

// Parser
entrypoint: expression | EOF;

expression:
            '-' expression # unaryMinus
          |  '(' expression ')' #brackets
          | left=expression '^' right=expression #pow
          | left=expression op=('*' | '/') right=expression #mulOrDiv
          | left=expression op=('+' | '-') right=expression #addOrSub
          | left=expression right=expression #implicitMul
          | NUMBER #number
          ;

// Lexer
NUMBER: [ 0-9]+;

WHITESPACE: [ \r\n\t]+ -> skip;