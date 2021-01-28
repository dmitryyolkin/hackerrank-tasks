package sandbox.hackerrank.arrays;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionArrayManipulationTest {
    @Test
    public void testSolution() {
        SolutionArrayManipulation solution = new SolutionArrayManipulation();
        // 1  2  3  4  5  6  7  8   9  10
        // 0  8  8  8  8  8  0  0   0  0
        // 0  8  15 15 15 8  0  0   0  0
        // 1  9  16 16 16 16 16 1   0  0
        // 1  9  16 16 31 31 31 16  15 0
        assertEquals(
                31,
                solution.calculate(10, new int[][]{
                        {2, 6, 8},
                        {3, 5, 7},
                        {1, 8, 1},
                        {5, 9, 15}
                })
        );

        assertEquals(
                200,
                solution.calculate(5, new int[][]{
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                })
        );
    }

}
