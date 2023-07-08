grammar Matching;

matchingQuestion: matchingquestionType '-' matchingquestionText+ matchingalinea+ matchingsolution+ '-' matchingcotacao;

matchingquestionType: 'MatchingQuestion';

matchingalinea: 'OP:' matchingtext+;

matchingsolution: 'RES:' matchingnumber '&' matchingnumber;

matchingcotacao: 'Cotacao:' matchingnumber ';';

matchingquestionText: matchingtext;

matchingtext: WORD1;

matchingnumber: INT1 | FLOAT1;

INT1 : [0-9]+ ;

FLOAT1 : [0-9]+ ('.'|',') [0-9]+ ;

WORD1 : [a-zA-Z0-9_?!"',;]+;

WS: [ \t\r\n]+ -> skip;