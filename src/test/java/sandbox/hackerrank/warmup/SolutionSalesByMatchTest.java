package sandbox.hackerrank.warmup;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionSalesByMatchTest {
    @Test
    public void testSolution() {
        SolutionSalesByMatch solution = new SolutionSalesByMatch();
        assertEquals(
                2,
                solution.calculate(7, new int[]{1, 2, 1, 2, 1, 3, 2})
        );

        assertEquals(
                3,
                solution.calculate(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20})
        );

    }

}
