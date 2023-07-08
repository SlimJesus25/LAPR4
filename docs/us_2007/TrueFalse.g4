grammar TrueFalse;

trueFalseQuestion: questionText+ alinea+ solution+ '-' cotacao;

alinea: 'OP:' questionText;

solution: 'RES:' questionText;

cotacao: 'Cotacao:' number ';';

questionText: WORD;

number: INT | FLOAT;


