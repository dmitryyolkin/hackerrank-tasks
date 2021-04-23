package sandbox.toptal.tour3;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTour3_1Test {
    @Test
    public void testSolution() {
        SolutionTour3_1 solution = new SolutionTour3_1();
        assertArrayEquals(
                new int[]{1,0,0,0,0,4},
                solution.calculate(5., 0.99)
        );

        assertArrayEquals(
                new int[]{0,1,1,0,0,1},
                solution.calculate(3.14, 1.99)
        );

        assertArrayEquals(
                new int[]{4,0,2,1,1,2},
                solution.calculate(3., 0.01)
        );

        assertArrayEquals(
                new int[]{1,0,1,1,1,0},
                solution.calculate(4., 3.14)
        );

        assertArrayEquals(
                new int[]{1,0,1,0,0,0},
                solution.calculate(0.45, 0.34)
        );


    }

}
