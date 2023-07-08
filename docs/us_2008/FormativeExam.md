# Formative Exam

## Context
This document explains how to use and shows pragmatical examplesa about a Formative Exam

## How to use

In order to create valid "Formative Exam" some requirements are mandatory,
the format must follow this structure:
```
Title:  [Formative Exam title text]
Header: header_feedback_grade and Header Text (optional)
Header_Feedback_Grade: FEEDBACK [Feedback Text] FEEDBACK_GRADE_TYPE [Feedback_Grade_Type Value] GRADE [Grade Text] FEEDBACK_GRADE_TYPE [Feedback_Grade_Type Value] 
Section: [Section text] (Optional) question (Can have multiple questions)
Question: [Question type value]
```

## Test Files

**Test 1: Valid formative exam** *.*

```
Programming Language Final Exam 2023
feedback: none
grade: none
Regular Expressions
multiple choice
short answer
numerical
State Machine
multiple choice
select missing words
true or false
matching
Bison and Flex
multiple choice
multiple choice
ANTLR
true or false
```

**Test 2 - Invalid formative exam (every section needs at least 1 question type)** *.*

```
Programming Language Final Exam 2023
feedback: none
grade: none
Regular Expressions
multiple choice
short answer
numerical
State Machine
multiple choice
select missing words
true or false
matching
Bison and Flex
multiple choice
multiple choice
ANTLR
```

**Test 3 - Valid formative exam (a section can contain (1 or more) question types and every question type might be the same (or not)).** *.*

```
Programming Language Final Exam 2023
feedback: none
grade: none
Regular Expressions
multiple choice
short answer
numerical
State Machine
multiple choice
select missing words
true or false
matching
Bison and Flex
multiple choice
multiple choice
ANTLR
numerical
numerical
numerical
numerical
numerical
```