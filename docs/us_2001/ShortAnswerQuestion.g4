grammar ShortAnswerQuestion;

shortanswer:shortAnswerQuestion;

shortAnswerQuestion: 'Short Answer - ' questionDescription '-' defaultGrade '-' questionText+'?' (WORD shortAnswer + cotacao)+;

shortAnswer:'-' (WORD|INT)+;


questionText: (WORD|INT)+ ;

defaultGrade: INT;

questionDescription: (WORD|INT)+;

cotacao: 'Cotacao' '-' number;

number : INT | FLOAT ;

INT    : [0-9]+ ;

FLOAT  : [0-9]+ '.' [0-9]* | '.' [0-9]+ ;

WORD: [a-zA-Z0-9_]+;

WS: [ \t\r\n]+ -> skip;