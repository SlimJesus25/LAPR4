grammar US2001;

exam: 'Exam Title:' title 'Exam Header:' header 'Course Code:' courseCode (section)+ 'InicialDate:' inicaldate 'FinalDate:' finaldate;

inicaldate: NUMBER'-'NUMBER'-'NUMBER ' ' NUMBER':'NUMBER;
finaldate: NUMBER'-'NUMBER'-'NUMBER ' ' NUMBER':'NUMBER;

title : TEXT;

header: value+;

courseCode: value+;

value: TEXT | NUMBER;

section: 'Section:' value (question)+; // Section: example

question: 'Question:' statement '?'
          ('Options:' (options)+ )?
          'Solution:' solution
          'Type:' questionType
          'Value:' quotation
          'FeedBack:' feedback?;

statement: value+;
solution: matchingsolution+ | multiplesolution+ | shortsolution+ | textsolution ;
matchingsolution: NUMBER'&'NUMBER'|';
multiplesolution: NUMBER'|';
shortsolution: value+'|';
textsolution: value+;

feedback: value+;
options: value+ '|';

questionType: 'MATCHING' | 'MULTIPLE_CHOICE' |
              'SHORT_ANSWER' | 'NUMERICAL' |
              'MISSING_WORDS' | 'TRUE_OR_FALSE';

quotation : ' ' NUMBER | NUMBER;

NUMBER: [0-9]+;
TEXT: [a-zA-Z-!,;+ _-]+;
//TEXT: [a-zA-ZÀ-ÿ-!,; _-]+;
WS: [ \t\r\n]+ -> skip;