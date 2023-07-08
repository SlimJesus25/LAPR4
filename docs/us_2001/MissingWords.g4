grammar MissingWords;

selectMissingWordsQuestion: questionType '-' questionText+  solution+ '-' cotacao;

questionType: 'MissingWords';

solution: 'RES:' questionText;

cotacao: 'Cotacao:' number ';';

questionText: WORD+;

number: INT | FLOAT;

INT : [0-9]+ ;

FLOAT : [0-9]* ('.'|',') [0-9]+ ;

WORD : [a-zA-Z0-9_?!"',;]+;

WS: [ \t\r\n]+ -> skip;


