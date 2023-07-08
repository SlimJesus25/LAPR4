# US1010 —  As Teacher, I want to schedule a class.

## 1. Requirements

**US1010** -  As Teacher, I want to schedule a class.

## 2. Analysis

### 2.1 Identifying problem

When analysing the problem, we confronted ourselves with the following questions:
* What are the validations that must be made in order to schedule a class?
* How will we guarantee that the lecture won't collide with others events?
* What data is needed to be persisted in the database

In order to implement this functionality it is necessary to:
* Verify the teacher courses and enable those to choose;
* Verify the teacher schedule and not let him to schedule a class in a time that he already has an event;
* Verify the course lectures and not let the teacher schedule a class in a time that the course already has a lecture;

### 2.2 Domain Excerpt
![excerpt diagram](domain_excerpt_1010.svg "domain_excerpt_1010.svg")

### 2.3 Unit tests - Business Rules Testing
//TODO: Unit tests
**Test 1:** *Ensure initial date isn't before final date*

**Test 2:** *Ensure initial time isn't before final time*

**Test 3:** *Ensure that any no value is empty or null*

## 3. Design

To solve this problem we first implemented a service responsible for getting the teacher courses. After choosing the
course, the teacher will start choosing datetime related lecture' atributtes, so we decided to implement a service to show
a schedule to the teacher of his lectures on this week to sort of orient him while trying to schedule a new lecture.
Then, after him choosing the date, the time and the weekday, we have access to all the variables needed to verify any
collisions with other events and we implement services responsible to check a collision per each different event. To see
if the lecture won't collide with other events we must check if the lecture weekday is equal and if the "lecture.initialtime"
is not before "event.finaltime" or "lecture.finaldate" is not after "event.initialtime" and the "lecture.initialdate"
is not before "event.finaldate" or "lecture.finaldate" is not after "event.initialdate" then it means the lecture and the event
collide. If they don't we persist the lecture
It was decided to divide this US in three parts:
* The first part is responsible to get and show the Teacher Schedule
* The second part is responsible for teacher to choose the Exam specifications
* The third part is responsible for the lecture's verifications and creation


### 3.1. Realization

* **Sequence Diagram**

![sequence diagram](us_1010_part1\us_1010_Part1_SD.svg "us_1010_part1\us_1010_Part1_SD.svg")
![sequence diagram](us_1010_part2\us_1010_Part2_SD.svg "us_1010_part2\us_1010_Part2_SD.svg")
![sequence diagram](us_1010_part3\us_1010_Part3_SD.svg "us_1010_part3\us_1010_Part3_SD.svg")

* **Class Diagram**

![class diagram](us_1010_part1\us_1010_Part1_CD.svg "us_1010_part1\us_1010_Part1_CD.svg")
![class diagram](us_1010_part2\us_1010_Part2_CD.svg "us_1010_part2\us_1010_Part2_CD.svg")
![class diagram](us_1010_part3\us_1010_Part3_CD.svg "us_1010_part3\us_1010_Part3_CD.svg")


### 3.2. Applied Patterns
* DTO;
* Persistence;
* Application;
* Controller;
* Factory;
* ApplicationService;
* DomainService;
* Domain;
* UI;