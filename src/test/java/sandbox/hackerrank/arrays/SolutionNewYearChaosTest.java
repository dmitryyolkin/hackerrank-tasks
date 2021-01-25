package sandbox.hackerrank.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionNewYearChaosTest {
    @Test
    public void testSolution() {
        SolutionNewYearChaos solution = new SolutionNewYearChaos();
        assertEquals(
                new SolutionNewYearChaos.NewYearResult(false, 3),
                solution.calculate(new int[]{2, 1, 5, 3, 4})
        );

        assertEquals(
                new SolutionNewYearChaos.NewYearResult(true, null),
                solution.calculate(new int[]{2, 5, 1, 3, 4})
        );

        assertEquals(
                new SolutionNewYearChaos.NewYearResult(false, 7),
                solution.calculate(new int[]{1, 2, 5, 3, 7, 8, 6, 4})
        );


    }

}
