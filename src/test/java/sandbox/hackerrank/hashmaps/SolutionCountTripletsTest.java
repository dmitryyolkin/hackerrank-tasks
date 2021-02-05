package sandbox.hackerrank.hashmaps;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionCountTripletsTest {
    @Test
    public void testSolution() {
        SolutionCountTriplets solution = new SolutionCountTriplets();
        assertEquals(
                2,
                solution.calculate(Arrays.asList(1L, 2L, 2L, 4L), 2)
        );

        assertEquals(
                6,
                solution.calculate(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)
        );

        assertEquals(
                161700,
                solution.calculate(Arrays.asList(
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L
                ), 1)
        );


    }

}
