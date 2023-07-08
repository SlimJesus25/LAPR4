# US2006 —  As Teacher, I want to view a list of the grades of exams of my courses.

## 1. Requirements

**Acceptance Criteria** - A Student takes an exam and answer its questions.
At the end of the exam, the system should display the feedback and result (i.e., grade) of the exam.
The feedback and grade of the exam should be automatically calculated by a parser based on the grammar defined for exams structure.

### Questions
> **Q** - Regarding this user story, the provided excel file reads as follows:
>"As Teacher, I want to view a list of the grades of exams of my courses"
>A teacher should be able to see the grades of a specific course, of all his courses at the same time, or both?
>
> **A** -  I think it would be interesting to have all the possibilities you mentioned. As a suggestion, maybe present the professor's courses and he could indicate which courses he wants to see or "all".

> **Q** - Should grades from formative exams be listed as well? Or would only the grades of the "normal" exams be listed?
>
> **A** - Formative exams are generated automatically, and since there is no record of the questions and answers from those exams, I don't think it makes sense to store the results of those grades. However, the system should display for these exams the feedback and the grade at the end.

## 2. Analysis

### 2.1 Identifying problem

This use case is going to allow a teacher to view the grades of the exams of his courses.

In order to implement this functionality it necessary to:
* Ask the teacher if he wants to see the grades of a course or all of them;
  * If he chooses to see all the courses we show him the list of all the grades of courses that he is associated to!
  * If the teacher chooses to just see the grades of one course we need the list of exam grades only beloining to that course;

### 2.2 Domain Excerpt
![us_2006_CD](us_2006_CD.PNG)

## 3. Design

The desing of this US e pretty simple, the UI asks the teacher if he wants to see all grades or just the ones refering to a unique course!

In the case of wanting to see all the grades we need to gather all of the teachers courses and then only get the exams that belong to one of those courses and then list the grades.

When the teacher wants to see just the grades of one course we to ask which course he wants to see and then list the grades of that course.

### 3.1. Realization
![us_2006_SD](us_2006_SD.PNG  )

### 3.2. Applied Patterns
The applied patters are:
* DTO;
* Persistence;
* Application;
* Controller;
* Service;
* Domain;
* UI;