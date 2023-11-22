package delft;

import java.util.*;
import java.util.stream.*;
import org.assertj.core.data.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static delft.Field.*;
import static delft.Property.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SportsHallPlannerTests {


    // T1: Request list null
    @Test
    void Test1() {
        // Arrange
        var requests = Collections.<Request>emptyList();
        // var halls = Collections.<SportsHall>emptyList();


        var halls = List.of(
          new SportsHall(
            new HashSet<Property>(){{
              add(NEAR_CITY_CENTRE);
              add(HAS_RESTAURANT);
            }},
            new HashMap<Field, Integer>() {{
              put(BADMINTON, 2);
              put(BASKETBALL, 4);
            }}
          )
        );

        // Act
        final Map<SportsHall, Request> result = SportsHallPlanner.planHalls(requests, halls);
        // Assert
        assertThat(result).isEmpty();
    }

    // T2: Sport hall list null
    @Test
    void Test2() {
        // Arrange
        var requests = List.of(
            new Request(
                new HashSet<Property>(){{
                    add(NEAR_CITY_CENTRE);
                    add(HAS_RESTAURANT);
                }},
                BADMINTON,
                    1
            )
        );

        var halls = Collections.<SportsHall>emptyList();
        // Act
        final Map<SportsHall, Request> result = SportsHallPlanner.planHalls(requests, halls);
        // Assert
        assertThat(result).isNull();
    }

    // T3: Same SportHall Twice ==> Error
    @Test
    void Test3() {
        // Arrange
        var requests = List.of(
            new Request(
                new HashSet<Property>(){{
                    add(NEAR_CITY_CENTRE);
                    add(HAS_RESTAURANT);
                }},
                BADMINTON,
                    1
            )
        );

        var halls = List.of(
          new SportsHall(
            new HashSet<Property>(){{
              add(NEAR_CITY_CENTRE);
              add(HAS_RESTAURANT);
            }},
            new HashMap<Field, Integer>() {{
              put(BADMINTON, 2);
              put(BASKETBALL, 4);
            }}
          ),
          new SportsHall(
            new HashSet<Property>(){{
              add(NEAR_CITY_CENTRE);
              add(HAS_RESTAURANT);
            }},
            new HashMap<Field, Integer>() {{
              put(BADMINTON, 2);
              put(BASKETBALL, 4);
            }}
          )
        );

        // Act // Assert

        assertThrows(IllegalArgumentException.class,
                () -> {
                    final Map<SportsHall, Request> result = SportsHallPlanner.planHalls(requests, halls);
                });


        // Assert
        // assertThat(result).isNull();
    }

    // T4: Filter work
    @Test
    void Test4() {
        // Arrange
        var requests = List.of(
            new Request(
                new HashSet<Property>(){{
                    add(NEAR_CITY_CENTRE);
                    add(HAS_RESTAURANT);
                }},
                BADMINTON,
                1
            )
        );

        var halls = List.of(
            new SportsHall(
                new HashSet<Property>(){{
                    add(NEAR_CITY_CENTRE);
                    add(HAS_RESTAURANT);
                }},
                new HashMap<Field, Integer>() {{
                    put(BADMINTON, 2);
                    put(BASKETBALL, 4);
                }}
            )
        );


        // Act
        final Map<SportsHall, Request> result = SportsHallPlanner.planHalls(requests, halls);
        // Assert
        // assertThat(result).isNull();
        assertThat(result).isNotEmpty();
    }

}
