package sandbox.hackerrank.warmup;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionRepeatedStringsTest {
    @Test
    public void testSolution() {
        SolutionRepeatedStrings solution = new SolutionRepeatedStrings();
        assertEquals(
                7,
                solution.calculate("aba", 10)
        );

        assertEquals(
                1000000000000L,
                solution.calculate("a", 1000000000000L)
        );

    }

}
