
package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

class AutoAssignerTest {

    // helper method to create a ZonedDateTime
    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }

    // T1: Pas de workshop
    @Test
    void Test1() {
        // Arange
        var workshops = Collections.<Workshop>emptyList();

        var students = List.of(
                new Student(1, "Student 1", "student@unamur.be"),
                new Student(2, "Student 2", "student2@unamur.be")
        );
        AutoAssigner autoAssigner = new AutoAssigner();

        // Assert
        final AssignmentsLogger result = autoAssigner.assign(students, workshops);

        // Act
        assertThat(result.getErrors()).isEmpty();
        assertThat(result.getAssignments()).isEmpty();
    }

    // T2: Workshop avec assez de place
    @Test
    void Test2() {
        // Arange
        //var emptyWorkshop = Collections.<Workshop>emptyList();

        var workshops = List.of(
            new Workshop(1, "Workshop", new HashMap<ZonedDateTime, Integer>() {{
                put(date(2023, 1, 1, 10, 0), 10);
                put(date(2023, 1, 5, 10, 0), 10);
            }}),
            new Workshop(2, "Workshop2", new HashMap<ZonedDateTime, Integer>() {{
                put(date(2023, 1, 1, 10, 0), 10);
                put(date(2023, 1, 5, 10, 0), 10);
            }})
        );

        var students = List.of(
            new Student(1, "Student 1", "student@unamur.be"),
            new Student(2, "Student 2", "student2@unamur.be")
        );
        AutoAssigner autoAssigner = new AutoAssigner();

        // Assert
        final AssignmentsLogger result = autoAssigner.assign(students, workshops);

        // Act
        assertThat(result.getErrors()).isEmpty();
        assertEquals(4, result.getAssignments().size());
    }

    // T3: workshop avec asssez de place sur deux dates
    @Test
    void Test3() {
        // Arange
        //var emptyWorkshop = Collections.<Workshop>emptyList();

        var workshops = List.of(
                new Workshop(1, "Workshop", new HashMap<ZonedDateTime, Integer>() {{
                    put(date(2023, 1, 1, 10, 0), 1);
                    put(date(2023, 1, 2, 10, 0), 1);
                }})
        );

        var students = List.of(
                new Student(1, "Student 1", "student@unamur.be"),
                new Student(2, "Student 2", "student2@unamur.be")
        );
        AutoAssigner autoAssigner = new AutoAssigner();

        // Assert
        final AssignmentsLogger result = autoAssigner.assign(students, workshops);

        // Act
        assertThat(result.getErrors()).isEmpty();
        assertEquals(students.size(), result.getAssignments().size());
    }

    // T4: Workshop avec pas suffisament de place
    @Test
    void Test4() {
        // Arange
        //var emptyWorkshop = Collections.<Workshop>emptyList();

        var workshops = List.of(
                new Workshop(1, "Workshop", new HashMap<ZonedDateTime, Integer>() {{
                    put(date(2023, 1, 1, 10, 0), 1);
                }})
        );

        var students = List.of(
                new Student(1, "Student 1", "student@unamur.be"),
                new Student(2, "Student 2", "student2@unamur.be")
        );
        AutoAssigner autoAssigner = new AutoAssigner();

        // Assert
        final AssignmentsLogger result = autoAssigner.assign(students, workshops);

        // Act
        // assertThat(result.getErrors()).isEmpty();
        assertEquals(1, result.getErrors().size());
        assertEquals(1, result.getAssignments().size());
    }

    @Test
    // T5: Workshop sans étudiants
    void Test5() {
        // Arange
        //var emptyWorkshop = Collections.<Workshop>emptyList();

        var workshops = List.of(
                new Workshop(1, "Workshop", new HashMap<ZonedDateTime, Integer>() {{
                    put(date(2023, 1, 1, 10, 0), 1);
                }})
        );

        var students = Collections.<Student>emptyList();

        AutoAssigner autoAssigner = new AutoAssigner();

        // Assert
        final AssignmentsLogger result = autoAssigner.assign(students, workshops);

        // Act
        // assertThat(result.getErrors()).isEmpty();
        assertThat(result.getErrors()).isEmpty();
        assertThat(result.getAssignments()).isEmpty();
    }

}