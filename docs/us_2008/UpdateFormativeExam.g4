grammar UpdateFormativeExam;
start:
        |title '\n' section+
        ;
title:
        |TEXT
        ;
header: header_feedback_grade #headerfgNoText
        |header_feedback_grade TEXT #headerfg
        ;

header_feedback_grade: FEEDBACK left=FEEDBACK_GRADE_TYPE '\n' GRADE rigth=FEEDBACK_GRADE_TYPE
                     ;

section: TEXT '\n' question+ #sectionText
         |question+ #sectionNoText
         ;
question: QUESTION_TYPE '\n'
         ;

FEEDBACK: 'feedback: ' ;
GRADE: 'grade: ' ;
FEEDBACK_GRADE_TYPE: ('none'|'on-submission'|'after-closing') ;
QUESTION_TYPE: ('matching'|'multiple choice'|'short answer'|'numerical'|'select missing words'|'true or false') ;
TEXT: [ a-zA-Z0-9!?",]+ ;
WS: [ \t\r\n]+ -> skip ;
