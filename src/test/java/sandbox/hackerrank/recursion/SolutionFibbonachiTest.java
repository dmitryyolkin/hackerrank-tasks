package sandbox.hackerrank.recursion;

import org.junit.Test;
import sandbox.hackerrank.recursion.SolutionFibbonachi;

import static org.junit.Assert.assertEquals;

public class SolutionFibbonachiTest {
    @Test
    public void testSolution() {
        SolutionFibbonachi solution = new SolutionFibbonachi();
        assertEquals(
                0,
                solution.calculate(0)
        );

        assertEquals(
                1,
                solution.calculate(1)
        );

        assertEquals(
                1,
                solution.calculate(2)
        );

        assertEquals(
                2,
                solution.calculate(3)
        );

        assertEquals(
                3,
                solution.calculate(4)
        );

        assertEquals(
                5,
                solution.calculate(5)
        );

        assertEquals(
                8,
                solution.calculate(6)
        );


        assertEquals(
                13,
                solution.calculate(7)
        );

    }

}
