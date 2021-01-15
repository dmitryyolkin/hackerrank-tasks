package sandbox.hackerrank;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionStringSeparationTest {
    @Test
    public void testSolution() {
        SolutionStringSeparation solution = new SolutionStringSeparation();
        assertEquals(
                6,
                solution.calculate("abaccadd")
        );
    }

}
