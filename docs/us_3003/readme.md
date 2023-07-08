# US 3004

## As Project Manager, I want the team to "explore" the synchronization problems related to the shyncronization of shared boards and design a conceptual solution based on practical evidence.

## 1. Context

This functional part of the system has very specific technical requirements, particularly some concerns about synchronization problems.
In fact, several clients will try to concurrently update boards. As such, to explore and study this concurrency scenario a "model" of a solution must be implemented and evaluated in C, using processes and semaphores.
Specific requirements will be provided in SCOMP.

## 2. Requirements

The respective requirements for this US were:

- NFR11. This functional part of the system
  has very specific technical requirements, particularly some concerns about synchronization problems. In fact, several clients will try to concurrently update boards. As
  such, to explore and study this concurrency scenario a "model" of a solution must be implemented and evaluated exceptionally using the C programming language, and using
  processes and semaphores.

Regarding this requirement we understand that it relates to the shared board synchronization.

## 3. Analysis

 Many users will try to update something on the shared board, meaning that concurrently access is going to exist.
There are many problems linked with concurrent access, for instance data inconsistency (two or more users changing the
same Post-It content, etc...). That kind of problem is what we want to avoid, so we are going to implement a
synchronization mechanism, semaphores!
The solution is simple, there is need of only one semaphore that will control the access to the critical zone (where the
critical zone is going to be the shared board) and a synchronization semaphore to notifie all the users when changes
have been made to the shared memory. For that, both a mutual exclusion and synchronization semaphores are used.To see
the practical evidence, there is a C implementation on "PracticalEvidence.c" file.

## 4. Design

### 4.1. Applied Patterns
 - Mutual Exclusion;
 - Synchronization;
 - Client-Server (Sleeping Barber inspiration).

## 5. Implementation

* See on PracticalEvidence.c *

## 6. Integration/Demonstration

## 7. Observations