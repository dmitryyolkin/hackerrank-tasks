package sandbox.hackerrank.greedy;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionGreedyFlouristTest {
    @Test
    public void testSolution() {
        SolutionGreedyFlourist solution = new SolutionGreedyFlourist();
        assertEquals(
                13,
                solution.calculate(3, new int[]{2, 5, 6})
        );

        assertEquals(
                15,
                solution.calculate(2, new int[]{2, 5, 6})
        );

        assertEquals(
                29,
                solution.calculate(3, new int[]{1, 3, 5, 7, 9})
        );


    }

}
