# US 1001

## 1. Requirements

**US1001** -  As Manager, I want to be able to register, disable/enable, and list users of the system (Teachers and Students, as well as Managers)

**Acceptance Criteria** - This US has no specific acceptance criteria

## 2. Analysis

### 2.1 Identifying problem
In order to implement this functionality, we divided the documentation in 3 parts:

####US1001_1 Add User

* The manager specifies the parameters that he wants for the user he is adding
* The system will retrieve the input data and persist in the database the user added

####US1001_2 Deactivate User

* The system presents a list of the users in the database that are active
* The user selects a user
* The system will deactivate the user in the database

####US1001_3 List User

* The manager will ask for a list of users
* The system will retrieve them from the database and present them to the manager

### 2.2 Domain Excerpt
![excerpt diagram](domain_excerpt_1001.svg "domain_excerpt_3004.svg")

### 2.3 Unit tests - Business Rules Testing

**Test 1:** *Ensure Username can't be null*

**Test 2:** *Ensure Password can't be null*

**Test 3:** *Ensure FirstName can't be null*

**Test 4:** *Ensure LastName can't be null*

**Test 5:** *Ensure Email can't be null*

**Test 6:** *Ensure User can't be null*

**Test 7:** *Ensure list of users can't be null*



## 3. Design

To solve this problem it is necessary to ask for the parameters for the user (in case we're adding a user), make sure 
they persist in the database to make sure we can solve the US1001_2 and US1001_3.

### 3.1. Realization

###US1001_1 Add User
* **Sequence Diagram**

![sequence diagram](us1001_1/sequence_diagram_addUser.svg "sequence_diagram_1001_1")

* **Class Diagram**

![class diagram](us1001_1/class_diagram_addUser.svg "class_diagram_1001_1")

###US1001_2 Deactivate  User

* **Sequence Diagram**
 
![sequence diagram](us1001_2/sequence_diagram_deactivateUser.svg "sequence_diagram_1001_2")

* **Class Diagram**

![class diagram](us1001_2/class_diagram_deactivateUser.svg "class_diagram_1001_2")

####US1001_3 List User

* **Sequence Diagram**

![sequence diagram](us1001_3/sequence_diagram_listUser.svg "sequence_diagram_1001_3")

* **Class Diagram**

![class diagram](us1001_3/class_diagram_listUser.svg "class_diagram_1001_3")

### 3.2. Applied Patterns
The applied patters are:
* DTO;
* Persistence;
* Application;
* Controller;
* Service;
* Domain;
* UI;