package sandbox.hackerrank.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionJumpingOnTheCloudsTest {
    @Test
    public void testSolution() {
        SolutionJumpingOnTheClouds solution = new SolutionJumpingOnTheClouds();
        assertEquals(
                3,
                solution.calculate(new int[]{0, 0, 0, 0, 1, 0})
        );

        assertEquals(
                4,
                solution.calculate(new int[]{0, 0, 1, 0, 0, 1, 0})
        );

        assertEquals(
                3,
                solution.calculate(new int[]{0, 0, 0, 1, 0, 0})
        );

    }

}
