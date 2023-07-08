# US2003 —  As Teacher, I want to view a list of all exams in a course

## 1. Context

Courses have Exams and the teacher wants to see a list of all the exams a course has.

## 2. Requirements

#### System Specifications Document

- FRE03 - List Course Exams The system displays to a teacher of a course all the exams
  of the course

## 3. Analysis/Breakdown

For the implementation of this us the teaches needs to be showed a list of courses to select which one of those he wishes to see the exams
and after selecting he will be either showed the list of exams or a message saying that the course does not have any exams at the moment.

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Class Diagram

![US_1007_CD](us_1007_CD.svg)

### 4.2. Sequence Diagram

![us_1007_SD](us_1007_SD.svg)

*Notes:*
- The authorization verications all are being done and the diagram of those are on the authorization package
- We decided to not put on the diagram the verifications if the file path is empty, if the file exists and is a csv to simplify a little bit the diagram but those verifications are being done!

### 4.3. Applied Patterns

The applied patterns are:

DTO;
Controller;
Repository;
Domain.

### 4.4. Tests

//

## 5. Implementation

## ListExamsController
````
    public Iterable<ExamDTO> listExams(CourseDTO course){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER, ElearningRoles.POWER_USER);

        Iterable<Exam> exams = repo.listAllExamsOfCourseByCode(new CourseCode(course.getCourseCode()));
        List<ExamDTO> result = new ArrayList<>();
        exams.forEach(a -> result.add(a.toDTO()));
        return result;
    }
    
````

## ListCoursesController
````
    public Iterable<CourseDTO> allCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER,ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        Iterable<Course> courses = repo.listAllCourses();
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }
    
````

## ListExamsUI
````
    protected boolean doShow() {
        Iterable<CourseDTO> courses = coursecontror.allCourses();

        System.out.println("Select a course to list the exams");
        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("All Courses", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
        if(selectedCourse == null){
            System.out.println("Exiting...");
            return false;
        }
        Iterable<ExamDTO> examsLists = examcontror.listExams(selectedCourse);
        int cont = 0;
        for (ExamDTO exam : examsLists) {
            System.out.println(exam);
            cont++;
        }
        if(cont == 0){
            System.out.println("The course doesnt have any Exams!");
        }

        return false;
    }
    
````

## 6. Integration/Demonstration
   In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system

It is also important to explain any scripts or instructions required to execute an demonstrate this functionality

## 7. Observations
   This section should be used to include any content that does not fit any of the previous sections.

The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works

The team should include in this section statements/references regarding third party works that were used in the development this work.





