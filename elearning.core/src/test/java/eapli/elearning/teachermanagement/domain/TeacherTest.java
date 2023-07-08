package eapli.elearning.teachermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class TeacherTest {

    @Test
    public void ensureTeacherAcronymCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Teacher(null
                , "111222333", LocalDate.of(1999, 10, 10), null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Teacher(""
                , "111222333", LocalDate.of(1999, 10, 10), null));

    }

    @Test
    public void ensureTeacherTaxPayerNumberCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Teacher("AABB"
                , "", LocalDate.of(1999, 10, 10), null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Teacher(""
                , null, LocalDate.of(1999, 10, 10), null));

    }

    @Test
    public void ensureTeacherDateOfBirthCantBeNullOrMinorOfAge(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Teacher("AABB"
                , "111222333", null, null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Teacher("AABB"
                , "111222333", LocalDate.of(2010, 10, 10), null));

    }
}
