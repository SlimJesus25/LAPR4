package eapli.elearning.managermanagement.domain;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.managermanagement.dto.ManagerDTO;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Manager")
public class Manager implements AggregateRoot<Integer>, DTOable<ManagerDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id", nullable = false, length = 10)
    private Integer managerID;

    @OneToOne()
    private SystemUser systemUser;
    @Override
    public ManagerDTO toDTO() {
        return new ManagerDTO(managerID);
    }
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Manager that = (Manager) other;
        return Objects.equals(managerID, that.managerID);
    }

    public Manager(Integer managerID) {
        this.managerID = managerID;
    }
    public Manager(){}
    @Override
    public Integer identity() {
        return managerID;
    }
    public void registerUser(){

    }
    public void enableUser(){

    }
    public void disableUser(){

    }
    public void listUsers(){

    }
    public void listStudents(){

    }
    public void listTeachers(){

    }
    public void listManagers(){

    }
    public void createCourse(){

    }
    public void openEnrollmentCourse(){

    }
    public void closeEnrollmentCourse(){

    }
    public void openCourse(){

    }
    public void closeCourse(){

    }
    public void setTeachersCourse(){

    }
    public void bulkEnrollStudents(){

    }
    public void approveStudentApplication(){

    }
    public void rejectStudentApplication(){

    }
}
