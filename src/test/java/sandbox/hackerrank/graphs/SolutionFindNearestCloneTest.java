package sandbox.hackerrank.graphs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionFindNearestCloneTest {
    @Test
    public void testSolution() {
        SolutionFindNearestClone solution = new SolutionFindNearestClone();
        assertEquals(
                1,
                solution.findShortest(
                        4,
                        new int[]{1, 1, 4},
                        new int[]{2, 3, 2},
                        new long[]{1, 2, 1, 1},
                        1
                )
        );

        assertEquals(
                -1,
                solution.findShortest(
                        4,
                        new int[]{1, 1, 4},
                        new int[]{2, 3, 2},
                        new long[]{1, 2, 3, 4},
                        2
                )
        );

        assertEquals(
                3,
                solution.findShortest(
                        5,
                        new int[]{1, 1, 2, 3},
                        new int[]{2, 3, 4, 5},
                        new long[]{1, 2, 3, 3, 2},
                        2
                )
        );

    }

}
