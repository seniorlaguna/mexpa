grammar Expression;

// Parser
parse: addSub | EOF;

term: NUMBER
    | '(' number=addSub ')'
    ;

constant: term
        | name=IDENTIFIER
        ;

function: constant
        | name=(IDENTIFIER|'√') '(' x=function ')'
        ;

power: function
     | <assoc=right> left=term '^' right=power
     ;

implicitMul: power
           | left=implicitMul right=power
           ;

prefix: implicitMul
      | '-' number=prefix
      ;

suffix: prefix
      | <assoc=right> number=suffix op=('%'|'!')
      ;

mulDiv: suffix
      | left=mulDiv op=('*'|'/') right=suffix
      ;

addSub: mulDiv
      | left=addSub op=('+'|'-') right=mulDiv suf='%'
      | left=addSub op=('+'|'-') right=mulDiv
      ;

// Lexer
IDENTIFIER: [a-z][a-zA-Z0-9]*;

NUMBER: [ 0-9]+ ('.' [0-9]+)?;

WHITESPACE: [ \r\n\t]+ -> skip;