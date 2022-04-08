package sandbox.hackerrank.loops;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionLoop1Test {
    @Test
    public void testSolution() {
        SolutionLoop1 solution = new SolutionLoop1();
        assertArrayEquals(
                new int[]{2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046},
                solution.calculate(0, 2, 10)
        );

        assertArrayEquals(
                new int[]{8, 14, 26, 50, 98},
                solution.calculate(5, 3, 5)
        );

    }

}
