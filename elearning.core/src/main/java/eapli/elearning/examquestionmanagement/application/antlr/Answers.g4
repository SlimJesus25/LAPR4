grammar Answers;

start: (answers '\n')+;

answers: 'MISSING_WORDS' '-' (WORD)? (';')? #MissingWords
         | 'MATCHING' '-' (matching)? (';')? #Matchings
         | 'MULTIPLE_CHOICE' '-' (multiple)? (';')? #MultipleChoice
         | 'TRUE_OR_FALSE' '-' (truefalse)? (';')? #TrueOrFalse
         | 'NUMERICAL' '-' (f=FLOAT|i=INTEGER|fe=FLOATEXPO)? (';')? #Numericals
         | 'SHORT_ANSWER' '-' (WORD)? (';')? #ShortAnswer
         ;


truefalse: 'true;' | 'True;' | 'TRUE;' | 'false;' | 'False;' | 'FALSE;' | 'T;' | 't;' | 'F;' | 'f;';

matching: (left=INTEGER'&'right=INTEGER';')+;
multiple: (INTEGER';')+;

INTEGER: ([1-9][0-9]*|'0') ;

FLOAT: INTEGER('.'|',')[0-9]+ ;
FLOATEXPO: FLOAT'E+'INTEGER;

WORD: [a-zA-Z_?!"';.]+;
WS: [ \t\r\n]+ -> skip;