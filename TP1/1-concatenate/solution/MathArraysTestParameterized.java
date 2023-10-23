package delft;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static delft.MathArrays.concatenate;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

/**
 * Autre manière d'écrire des tests que dans la solution MathArraysTest.java. Ici, on utilise
 * des tests paramétriques qui permettent d'avoir moins de redondance de code lorsque les
 * tests utilisent toujours la même structure (voir méthode "concatenateTest").
 * Voir: https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
 */
class MathArraysTest {
    @ParameterizedTest()
    @MethodSource("generator")
    void concatenateTest(double[][] arrays, double[] expectedOutput) {
        assertThat(concatenate(arrays)).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(
                of(doublesOf(doubles(), doubles(1)), doubles(1)), // emptyArray
                of(doublesOf(doubles(1)), doubles(1)), // oneArrayWithOneElement
                of(doublesOf(doubles(1,2,3)), doubles(1,2,3)), // oneArrayWithMultipleElements
                of(doublesOf(doubles(1,2,3), doubles(4,5,6)), doubles(1,2,3,4,5,6)), // twoArraysWithMultipleElements
                of(doublesOf(doubles(1,2), doubles(3,4), doubles(5,5,3)), doubles(1,2,3,4,5,5,3)) // multipleArraysWithMultipleElements
        );
    }

    private static double[] doubles(double... ds) {
        return ds;
    }

    private static double[][] doublesOf(double[]... ds) {
        return ds;
    }
}
