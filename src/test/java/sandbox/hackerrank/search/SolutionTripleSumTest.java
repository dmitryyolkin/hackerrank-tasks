package sandbox.hackerrank.search;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionTripleSumTest {
    @Test
    public void testSolution() {
        SolutionTripleSum solution = new SolutionTripleSum();
        assertEquals(
                8,
                solution.calculate(
                        new int[]{1, 3, 5},
                        new int[]{2, 3},
                        new int[]{1, 2, 3}
                )
        );

        assertEquals(
                5,
                solution.calculate(
                        new int[]{1, 4, 5},
                        new int[]{2, 3, 3},
                        new int[]{1, 2, 3}
                )
        );

        assertEquals(
                12,
                solution.calculate(
                        new int[]{1, 3, 5, 7},
                        new int[]{5, 7, 9},
                        new int[]{7, 9, 11, 13}
                )
        );

    }

}
