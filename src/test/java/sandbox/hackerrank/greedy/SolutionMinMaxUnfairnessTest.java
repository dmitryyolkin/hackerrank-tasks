package sandbox.hackerrank.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionMinMaxUnfairnessTest {
    @Test
    public void testSolution() {
        SolutionMinMaxUnfairness solution = new SolutionMinMaxUnfairness();
        assertEquals(
                2,
                solution.calculate(3, new int[]{
                        100,
                        200,
                        300,
                        350,
                        400,
                        401,
                        402
                })
        );

        assertEquals(
                20,
                solution.calculate(3, new int[]{
                        10,
                        100,
                        300,
                        200,
                        1000,
                        20,
                        30
                })
        );

        assertEquals(
                3,
                solution.calculate(4, new int[]{
                        1,
                        2,
                        3,
                        4,
                        10,
                        20,
                        30,
                        40,
                        100,
                        200
                })
        );

        assertEquals(
                0,
                solution.calculate(2, new int[]{
                        1,
                        2,
                        1,
                        2,
                        1
                })
        );

    }

}
