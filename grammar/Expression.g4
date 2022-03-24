grammar Expression;

// Parser
parse: addSub | EOF;

term: NUMBER
    | '(' number=addSub ')'
    ;

power: term
     | <assoc=right> left=term '^' right=power
     ;

implicitMul: power
           | left=implicitMul right=power
           ;

prefix: implicitMul
      | '-' number=prefix
      ;

suffix: prefix
      | <assoc=right> number=suffix '%'
      ;

mulDiv: suffix
      | left=mulDiv op=('*'|'/') right=suffix
      ;

addSub: mulDiv
      | left=addSub op=('+'|'-') right=mulDiv
      ;

// Lexer
NUMBER: [ 0-9]+;

WHITESPACE: [ \r\n\t]+ -> skip;