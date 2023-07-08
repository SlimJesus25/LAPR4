grammar TrueFalse;

trueFalseQuestion: tfquestionType '-' tfquestionText+ tfalinea+ tfsolution+ '-' tfcotacao;

tfquestionType: 'TrueFalse';

tfalinea: 'OP:' tfquestionText;

tfsolution: 'RES:' tfquestionText;

tfcotacao: 'Cotacao:' tfnumber ';';

tfquestionText: WORD+;

tfnumber: INT | FLOAT;

INT : [0-9]+ ;

FLOAT : [0-9]* ('.'|',') [0-9]+ ;

WORD : [a-zA-Z0-9_?!"',;]+;

WS: [ \t\r\n]+ -> skip;


