package sandbox.hackerrank.arrays;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionMinSwapsTest {
    @Test
    public void testSolution() {
        SolutionMinSwaps solution = new SolutionMinSwaps();
        assertEquals(
                3,
                solution.calculate(new int[]{4, 3, 1, 2})
        );

        assertEquals(
                3,
                solution.calculate(new int[]{2, 3, 4, 1, 5})
        );

        assertEquals(
                3,
                solution.calculate(new int[]{1, 3, 5, 2, 4, 6, 7})
        );

    }

}
