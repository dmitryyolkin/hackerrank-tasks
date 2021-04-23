package sandbox.hackerrank.dynamic;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionCandiesTest {
    @Test
    public void testSolution() {
        SolutionCandies solution = new SolutionCandies();
        assertEquals(
                4,
                solution.calculate(3, new int[]{1, 2, 2})
        );

        assertEquals(
                19,
                solution.calculate(10, new int[]{
                        2,
                        4,
                        2,
                        6,
                        1,
                        7,
                        8,
                        9,
                        2,
                        1
                })
        );

        assertEquals(
                12,
                solution.calculate(8, new int[]{
                        2,
                        4,
                        3,
                        5,
                        2,
                        6,
                        4,
                        5
                })
        );

    }

}
