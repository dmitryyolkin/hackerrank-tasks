package sandbox.hackerrank.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionCountPairsTest {
    @Test
    public void testSolution() {
        SolutionCountPairs solution = new SolutionCountPairs();
        assertEquals(
                3,
                solution.calculate(2, new int[]{1, 5, 3, 4, 2})
        );
    }

}
