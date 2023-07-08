# US1010 —  As Teacher, I want to update a class.

## 1. Requirements

**US1010** -  As Teacher, I want to update a class.

## 2. Analysis

### 2.1 Identifying problem

When analysing the problem, we confronted ourselves with the following questions:
* What are the validations that must be made in order to update an extra class?
* What differences there will be comparing to simply creating a class?
                                                                       
In order to implement this functionality it is necessary to:
* Verify the teacher courses and enable those to choose;
* Verify the teacher schedule and not let him to schedule a class in a time that he already has an event;
* Verify the course lectures and not let the teacher schedule a class in a time that the course already has a lecture;

### 2.3 Unit tests - Business Rules Testing
**Test 2:** *Ensure initial date isn't before final date*

**Test 2:** *Ensure initial time isn't before final time*

**Test 3:** *Ensure that there are no repeated students*

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
**The difference between this us implementation and US 1010 is that when updating the initial date or initial time
we must force the user to update the final date or final time, respectively.**
It was decided to divide this US in three parts:
* The first part is responsible to get and show the Teacher Schedule
* The second part is responsible for teacher to choose the Exam specifications
* The third part is responsible for the lecture's verifications and creation 

### 2.2 Domain Excerpt
![excerpt diagram](docs\domain_excerpt_1010.svg "docs\domain_excerpt_1010.svg")

### 3.1. Realization

* **Sequence Diagram**

![sequence diagram](docs\us_1010_part1\us_1010_Part1_SD.svg "docs\us_1010_part1\us_1010_Part1_SD.svg")
![sequence diagram](docs\us_1010_part2\us_1010_Part2_SD.svg "docs\us_1010_part2\us_1010_Part2_SD.svg")
![sequence diagram](docs\us_1010_part3\us_1010_Part3_SD.svg "docs\us_1010_part3\us_1010_Part3_SD.svg")

* **Class Diagram**

![class diagram](docs\us_1010_part1\us_1010_Part1_CD.svg "docs\us_1010_part1\us_1010_Part1_CD.svg")
![class diagram](docs\us_1010_part2\us_1010_Part2_CD.svg "docs\us_1011_part2\us_1010_Part2_CD.svg")
![class diagram](docs\us_1010_part3\us_1010_Part3_CD.svg "docs\us_1011_part3\us_1010_Part3_CD.svg")


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
