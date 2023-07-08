package eapli.elearning.studentmanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class StudentTest {
    @Test
    public void ensureStudentTaxPayerNumberCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(""
                ,LocalDate.of(2005, 4, 14), null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(null
                ,LocalDate.of(2005, 4, 14), null));
    }

    @Test
    public void ensureStudentDateOfBirthCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("111222333"
                ,null, null));
    }

    @Test
    public void ensureStudentMechanographicalNumberIsAutomaticallyGenerated(){
        Student s1 = new Student("111222333"
                ,LocalDate.of(2005, 4, 14), null);

        Assertions.assertNotNull(s1.identity());
        Assertions.assertSame(s1.identity().studentMechanograpicalNumber().length(), 9);

    }

}
