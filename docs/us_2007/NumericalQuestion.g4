grammar NumericalQuestion;

numericalQuestion: description '\n' statement '\n' default_question_grade '\n' penalty_factor '\n' general_feedback '\n' first_accepted_answer '\n' error_accepted_answer '\n' grade '\n' accepted_answer_feedback '\n' (units '\n')?
     ;

description: 'Description: ' TEXT
           ;
statement: 'Statement: ' TEXT
         ;
default_question_grade: 'Default question grade: ' NUMERIC_VALUE
                      ;
penalty_factor: 'Penalty Factor: ' NUMERIC_VALUE
              ;
general_feedback: 'General feedback: ' TEXT
                ;
first_accepted_answer: 'First accepted answer: ' NUMERIC_VALUE UNIT
                     ;
error_accepted_answer: 'Error accepted answer: ' NUMERIC_VALUE UNIT
                     ;
grade: 'Grade: ' NUMERIC_VALUE
     ;
accepted_answer_feedback: 'Accepted answer feedback: ' TEXT* (INTEGER|FLOAT|FLOATEXPO)* TEXT*
                        ;
units: 'Units: ' UNIT
     ;

NUMERIC_VALUE: FLOAT|INTEGER|FLOATEXPO ;
FLOAT: INTEGER('.'|',')[0-9]+ ;
INTEGER: ([1-9][0-9]*|'0') ;
FLOATEXPO: FLOAT'E+'INTEGER;
UNIT: [a-zA-Z]+ ;
TEXT: [a-zA-Z0-9.? ]+ ;
WS: [ \t\r\n]+ -> skip ;