package sandbox.hackerrank.miscellaneous;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionMaximumXorTest {
    @Test
    public void testSolution() {
        SolutionMaximumXor solution = new SolutionMaximumXor();
        assertArrayEquals(
                new int[]{
                        3, 7, 3
                },
                solution.calculate(
                        new int[]{0, 1, 2},
                        new int[]{3, 7, 2}
                )
        );

        assertArrayEquals(
                new int[]{
                        7, 7
                },
                solution.calculate(
                        new int[]{5, 1, 7, 4, 3},
                        new int[]{2, 0}
                )
        );

        assertArrayEquals(
                new int[]{
                        22, 7
                },
                solution.calculate(
                        new int[]{1, 3, 5, 7},
                        new int[]{17, 6}
                )
        );


    }

}
