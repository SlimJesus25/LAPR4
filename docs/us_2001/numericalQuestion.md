# Numerical Question

## Context
This document explains how to use and shows pragmatical examples.

## How to use

In order to create valid "Numerical Question" some requirements are mandatory,
the format must follow this structure:
```
Description: [Descriptive text]
Statement: [Statement text]
Default question grade: [Grade value (it can be integer, float or cientific notation) and it might contain unit or not]
Penalty Factor: [Penalty factor value (it can be integer or float) and it might contain unit or not]
General feedback: [General feedback text]
First accepted answer: [First accepted answer value (it can be integer, float or cientific notation) and it might contain unit or not]
Error accepted answer: [Error accepted answer value (it can be integer, float or cientific notation) and it might contain unit or not]
Grade: [Grade value (it can be integer, float or cientific notation) and it might contain unit or not and must be between 0 and 20]
Accepted answer feedback: [Accepted answer feedback text]
Units: [It might exist or not and should have text]
```

## Test Files

**Test 1:** *Valid file.*

```
Description: Velocity question
Statement: A car travels a distance of 200 meters in a time of 20 seconds. What is the average velocity of the car in this constant linear motion?
Default question grade: 0,5v
Penalty Factor: 0,2v
General feedback: Adsa.
First accepted answer: 10,0ms
Error accepted answer: 0,01ms
Grade: 1,0v
Accepted answer feedback: The wanted answer is 10ms
Units: ms

```

**Test 2:** *Valid file (using +E notation).*

```
Description: Velocity question
Statement: A car travels a distance of 200 meters in a time of 20 seconds. What is the average velocity of the car in this constant linear motion?
Default question grade: 0,5v
Penalty Factor: 0,2v
General feedback: Adsa.
First accepted answer: 2,34E+1ms
Error accepted answer: 0,01ms
Grade: 1,0v
Accepted answer feedback: The wanted answer is 10ms
Units: ms

```

**Test 3:** *Valid file (without using units).*

```
Description: Velocity question
Statement: A car travels a distance of 200 meters in a time of 20 seconds. What is the average velocity of the car in this constant linear motion?
Default question grade: 0,5v
Penalty Factor: 0,2v
General feedback: Adsa.
First accepted answer: 2,34E+1ms
Error accepted answer: 0,01ms
Grade: 1,0v
Accepted answer feedback: The wanted answer is 10ms

```

**Test 4:** *Invalid file not using "Description:".*

```
Velocity question
Statement: A car travels a distance of 200 meters in a time of 20 seconds. What is the average velocity of the car in this constant linear motion?
Default question grade: 0,5v
Penalty Factor: 0,2v
General feedback: Adsa.
First accepted answer: 2,34E+1ms
Error accepted answer: 0,01ms
Grade: 1,0v
Accepted answer feedback: The wanted answer is 10ms

```