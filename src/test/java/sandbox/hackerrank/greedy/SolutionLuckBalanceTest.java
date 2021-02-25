package sandbox.hackerrank.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionLuckBalanceTest {
    @Test
    public void testSolution() {
        SolutionLuckBalance solution = new SolutionLuckBalance();
        assertEquals(
                29,
                solution.calculate(
                        3,
                        new int[][]{
                                {5, 1},
                                {2, 1},
                                {1, 1},
                                {8, 1},
                                {10, 0},
                                {5, 0}
                        }
                )
        );
    }

}
