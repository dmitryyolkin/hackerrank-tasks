package sandbox.hackerrank.recursion;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionDavisStaircaseTest {
    @Test
    public void testSolution() {
        SolutionDavisStaircase solution = new SolutionDavisStaircase();

        assertEquals(
                1,
                solution.calculate(1)
        );

        assertEquals(
                4,
                solution.calculate(3)
        );

        assertEquals(
                13,
                solution.calculate(5)
        );

        assertEquals(
                44,
                solution.calculate(7)
        );


    }

}
