grammar Question;

//import NumericalQuestion;
//numericalQuestion
//import shortAnswerQuestion;
//shortAnswerQuestion
question: multipleChoiceQuestion | matchingQuestion | selectMissingWordsQuestion | trueFalseQuestion;
                /*
        | 'Short Answer - ' shortAnswerQuestion
        | 'Numerical' '\n' numericalQuestion
        | 'MissingWords - ' selectMissingWordsQuestion
        | 'TrueFalse - ' trueFalseQuestion
        ;
        */

//---------------------------------------------------------------------------------------------------------------------||
matchingQuestion: matchingquestionType '-' matchingquestionText+ matchingalinea+ matchingsolution+ '-' matchingcotacao (feedback)?;

matchingquestionType: 'MATCHING';

matchingalinea: 'OP:' matchingtext+;

matchingsolution: 'RES:' matchingnumber '&' matchingnumber;

matchingcotacao: 'Cotacao:' matchingnumber ';';

matchingquestionText: matchingtext;

matchingtext: WORD;

matchingnumber: INT | FLOAT;
//---------------------------------------------------------------------------------------------------------------------||
multipleChoiceQuestion: multiplequestionType '-' multiplequestionText+ multiplealinea+ multiplesolution+ '-' multiplecotacao (feedback)?;

multiplequestionType: 'MULTIPLE_CHOICE';

multiplealinea: 'OP:' multipletext+;

multiplesolution: 'RES:' multiplenumber;

multiplecotacao: 'Cotacao:' multiplenumber ';';

multiplequestionText: multipletext | multiplenumber+;

multipletext: WORD;

multiplenumber: INT | FLOAT;
//---------------------------------------------------------------------------------------------------------------------||
selectMissingWordsQuestion: missingquestionType '-' missingquestion+ missingalinea+ missingsolution+ '-' missingcotacao (feedback)?;

missingquestionType: 'MISSING_WORDS';

missingalinea: 'OP:' missingquestionText;

missingsolution: 'RES:' missingquestionText;

missingcotacao: 'Cotacao:' missingnumber ';';

missingquestion: missingquestionText;

feedback: WORD+;

missingquestionText: WORD+;

missingnumber: INT | FLOAT;
//---------------------------------------------------------------------------------------------------------------------||
trueFalseQuestion: tfquestionType '-' tfquestionText+ tfsolution '-' tfcotacao (feedback)?;

tfquestionType: 'TRUE_OR_FALSE';

tfsolution: 'RES:' truefalseOptions;
truefalseOptions: 'true' | 'True' | 'TRUE' | 'false' | 'False' | 'FALSE' | 'T' | 't' | 'F' | 'f';

tfcotacao: 'Cotacao:' tfnumber ';';

tfquestionText: WORD;

tfnumber: INT | FLOAT;
//---------------------------------------------------------------------------------------------------------------------||

//---------------------------------------------------------------------------------------------------------------------||

//---------------------------------------------------------------------------------------------------------------------||


//---------------------------------------------------------------------------------------------------------------------||
INT : [0-9]+ ;

FLOAT : [0-9]+ ('.'|',') [0-9]+ ;

WORD : [a-zA-Z0-9_?!"',;]+;

WS: [ \t\r\n]+ -> skip;