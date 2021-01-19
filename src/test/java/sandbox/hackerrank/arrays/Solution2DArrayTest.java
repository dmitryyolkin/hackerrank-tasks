package sandbox.hackerrank.arrays;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class Solution2DArrayTest {
    @Test
    public void testSolution() {
        Solution2DArray solution = new Solution2DArray();
        assertEquals(
                19,
                solution.calculate(new int[][]{
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}
                })
        );
    }

}
