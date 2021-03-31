package sandbox.different;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BuyAndSellSolutionTest {
    @Test
    public void testSolution() {
        BuyAndSellSolution solution = new BuyAndSellSolution();
        assertArrayEquals(
                new int[][]{
                        {0, 0, 0, 5, 0},
                        {10, 0, 5, 0, 35},
                        {0, 20, 0, 0, 0},
                        {0, 0, 0, 25, 0}
                },
                solution.calculate(
                        new int[]{10, 20, 5, 30, 35}, // sell
                        new int[]{5, 50, 20, 25}, // buy
                        new int[][]{ //restrictions
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 0, 1},
                                {0, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1}
                        }
                )
        );
    }

}
