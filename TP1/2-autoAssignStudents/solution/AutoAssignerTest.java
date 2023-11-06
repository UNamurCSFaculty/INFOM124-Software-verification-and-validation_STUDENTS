package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.within;
import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

class AutoAssignerTest {

    @Test
    void all_students_in_the_same_first_date() {
        List<Student> students = Arrays.asList(
            new Student(1, "Jérôme", "jerome@unamur.be"),
            new Student(2, "Boris", "boris@unamur.be")
        );

        List<Workshop> workshops = Arrays.asList(
            new Workshop(1, "Java", new HashMap<>() {{
                put(date(2022, 1, 1, 14, 0), 5);
            }}),
            new Workshop(2, "Networks", new HashMap<>() {{
                put(date(2022, 1, 2, 14, 0), 5);
            }})
        );

        AutoAssigner assigner = new AutoAssigner();
        AssignmentsLogger result = assigner.assign(students, workshops);

        assertThat(result.getErrors()).isEmpty();
        assertThat(result.getAssignments()).containsExactlyInAnyOrder(
            "Java,Jérôme,01/01/2022 14:00",
            "Java,Boris,01/01/2022 14:00",
            "Networks,Jérôme,02/01/2022 14:00",
            "Networks,Boris,02/01/2022 14:00"
        );
    }

    @Test
    void uses_different_dates() {
        List<Student> students = Arrays.asList(
            new Student(1, "Jérôme", "jerome@unamur.be"),
            new Student(2, "Boris", "boris@unamur.be"),
            new Student(3, "Martin", "martin@unamur.be"),
            new Student(4, "Sara", "sara@unamur.be")
        );

        List<Workshop> workshops = Arrays.asList(
            new Workshop(1, "Java", new HashMap<>() {{
                put(date(2022, 1, 1, 14, 0), 1);
                put(date(2022, 1, 1, 17, 0), 2);
                put(date(2022, 1, 1, 19, 0), 1);
            }}),
            new Workshop(2, "Networks", new HashMap<>() {{
                put(date(2022, 1, 2, 14, 0), 1);
                put(date(2022, 1, 2, 17, 0), 2);
                put(date(2022, 1, 2, 19, 0), 1);
            }})
        );

        AutoAssigner assigner = new AutoAssigner();
        AssignmentsLogger result = assigner.assign(students, workshops);

        assertThat(result.getErrors()).isEmpty();
        assertThat(result.getAssignments()).containsExactlyInAnyOrder(
            "Java,Jérôme,01/01/2022 14:00",
            "Java,Boris,01/01/2022 17:00",
            "Java,Martin,01/01/2022 17:00",
            "Java,Sara,01/01/2022 19:00",
            "Networks,Jérôme,02/01/2022 14:00",
            "Networks,Boris,02/01/2022 17:00",
            "Networks,Martin,02/01/2022 17:00",
            "Networks,Sara,02/01/2022 19:00"
        );
    }

    @Test
    void no_spaces_for_everybody() {
        List<Student> students = Arrays.asList(
            new Student(1, "Jérôme", "jerome@example.com"),
            new Student(2, "Boris", "boris@example.com")
        );

        List<Workshop> workshops = Arrays.asList(
            new Workshop(1, "Java", new HashMap<>() {{
                put(date(2022, 1, 1, 14, 0), 1);
            }}),
            new Workshop(2, "Networks", new HashMap<>() {{
                put(date(2022, 1, 2, 14, 0), 1);
            }})
        );

        AutoAssigner assigner = new AutoAssigner();
        AssignmentsLogger result = assigner.assign(students, workshops);

        assertThat(result.getErrors()).containsExactlyInAnyOrder(
            "Java,Boris",
            "Networks,Boris"
        );
        assertThat(result.getAssignments()).containsExactlyInAnyOrder(
            "Java,Jérôme,01/01/2022 14:00",
            "Networks,Jérôme,02/01/2022 14:00"
        );
    }

    // corner cases
    @Test
    void everything_full() {
        List<Student> students = Arrays.asList(
            new Student(1, "Jérôme", "jerome@example.com"),
            new Student(2, "Boris", "boris@example.com")
        );

        List<Workshop> workshops = Arrays.asList(
            new Workshop(1, "Java", new HashMap<>() {{
                put(date(2022, 1, 1, 14, 0), 0);
                put(date(2022, 1, 1, 17, 0), 0);
            }}),
            new Workshop(2, "Networks", new HashMap<>() {{
                put(date(2022, 1, 2, 14, 0), 0);
                put(date(2022, 1, 2, 17, 0), 0);
            }})
        );

        AutoAssigner assigner = new AutoAssigner();
        AssignmentsLogger result = assigner.assign(students, workshops);

        assertThat(result.getErrors()).containsExactlyInAnyOrder(
            "Java,Jérôme","Networks,Jérôme",
            "Java,Boris","Networks,Boris");
        assertThat(result.getAssignments()).isEmpty();
    }

    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }


}
