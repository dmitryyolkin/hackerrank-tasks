package sandbox.toptal.tour3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTour3_2Test {

    @Test
    public void testSolution() {
        SolutionTour3_2 solution = new SolutionTour3_2();
        assertEquals(
                7,
                solution.calculate("1 2 3 * +")
        );

        assertEquals(
                1288,
                solution.calculate("1156 12 11 * +")
        );

        assertEquals(
                21,
                solution.calculate("5 2 + 3 *")
        );

        assertEquals(
                24,
                solution.calculate("5 2 * 2 * 4 +")
        );

        assertEquals(
                13,
                solution.calculate("5 2 + 2 + 4 +")
        );

        assertEquals(
                30,
                solution.calculate("3 2 + 2 4 + *")
        );

        assertEquals(
                24,
                solution.calculate("3 2 2 4 + + *")
        );

        assertEquals(
                5,
                solution.calculate("5")
        );

        assertEquals(
                0,
                solution.calculate("0 1 *")
        );

        assertEquals(
                34,
                solution.calculate("5 5 + 6 6 + 1 1 + * +")
        );

    }

}
