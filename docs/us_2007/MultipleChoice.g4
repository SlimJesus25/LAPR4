grammar MultipleChoice;

multipleChoiceQuestion: multiplequestionType '-' multiplequestionText+ multiplealinea+ multiplesolution+ '-' multiplecotacao;

multiplequestionType: 'MultipleChoiceQuestion';

multiplealinea: 'OP:' multipletext+;

multiplesolution: 'RES:' multiplenumber;

multiplecotacao: 'Cotacao:' multiplenumber ';';

multiplequestionText: multipletext | multiplenumber+;

multipletext: WORD2+;

multiplenumber: INT2 | FLOAT2;

INT2 : [0-9]+ ;

FLOAT2 : [0-9]+ ('.'|',') [0-9]+ ;

WORD2 : [a-zA-Z0-9_?!"',;]+;