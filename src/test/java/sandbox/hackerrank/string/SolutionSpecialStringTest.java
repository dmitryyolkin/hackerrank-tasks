package sandbox.hackerrank.string;

import org.junit.Test;
import sandbox.SolutionTemplate;
import sandbox.hackerrank.sorting.SolutionSpecialString;

import static org.junit.Assert.assertEquals;

public class SolutionSpecialStringTest {
    @Test
    public void testSolution() {
        SolutionSpecialString solution = new SolutionSpecialString();
        assertEquals(
                7,
                solution.calculate(5, "asasd")
        );

        assertEquals(
                10,
                solution.calculate(7, "abcbaba")
        );

        assertEquals(
                10,
                solution.calculate(4, "aaaa")
        );

    }

}
