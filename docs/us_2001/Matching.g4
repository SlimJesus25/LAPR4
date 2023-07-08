grammar Matching;

matchingQuestion: questionType '-' questionText+ alinea+ solution+ '-' cotacao;

questionType: 'MatchingQuestion';

alinea: 'OP:' text+;

solution: 'RES:' number '&' number;

cotacao: 'Cotacao:' number ';';

questionText: text | number+;

text: WORD+;

number: INT | FLOAT;

INT : [0-9]+ ;

FLOAT : [0-9]+ ('.'|',') [0-9]+ ;

WORD : [a-zA-Z0-9_?!"',;]+;

WS: [ \t\r\n]+ -> skip;