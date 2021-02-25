package sandbox.hackerrank.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionMinDiffTest {
    @Test
    public void testSolution() {
        SolutionMinDiff solution = new SolutionMinDiff();
        assertEquals(
                1,
                solution.calculate(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75})
        );

        assertEquals(
                3,
                solution.calculate(new int[]{1, -3, 71, 68, 17})
        );

    }

}
