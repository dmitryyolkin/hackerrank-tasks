package sandbox.hackerrank.search;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionMinTimeRequiredTest {
    @Test
    public void testSolution() {
        SolutionMinTimeRequired solution = new SolutionMinTimeRequired();
        assertEquals(
                6,
                solution.calculate(new long[]{2, 3}, 5)
        );

        assertEquals(
                7,
                solution.calculate(new long[]{1, 3, 4}, 10)
        );

        assertEquals(
                20,
                solution.calculate(new long[]{4, 5, 6}, 12)
        );

        assertEquals(
                82,
                solution.calculate(new long[]{63, 2, 26, 59, 16, 55, 99, 21, 98, 65}, 56)
        );

    }

}
