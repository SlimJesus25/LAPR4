grammar MissingWords;

selectMissingWordsQuestion: questionType '-' questionText+ alinea+ solution+ '-' cotacao;

questionType: 'MissingWords';

alinea: 'OP:' questionText;

solution: 'RES:' questionText;

cotacao: 'Cotacao:' number ';';

questionText: WORD+;

number: INT | FLOAT;

