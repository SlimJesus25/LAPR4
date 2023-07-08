grammar ShortAnswerQuestion;

shortAnswerQuestion: 'Short Answer - ' shortquestionDescription '-' shortdefaultGrade '-' shortquestionText+'?' (WORD shortAnswer + shortcotacao)+ ';';

shortAnswer:'-' (WORD|INT)+;

shortquestionText: (WORD|INT)+ ;

shortdefaultGrade: INT;

shortquestionDescription: (WORD|INT)+;

shortcotacao: 'Cotacao' '-' shortnumber;

shortnumber : INT | FLOAT ;

INT    : [0-9]+ ;

FLOAT  : [0-9]+ '.' [0-9]* | '.' [0-9]+ ;

WORD: [a-zA-Z0-9_]+;

WS: [ \t\r\n]+ -> skip;