package sandbox.hackerrank.hashmaps;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionTwoStringsTest {
    @Test
    public void testSolution() {
        SolutionTwoStrings solution = new SolutionTwoStrings();
        assertEquals(
                "YES",
                solution.calculate(
                        "hello", "world"
                )
        );

        assertEquals(
                "NO",
                solution.calculate(
                        "hi", "world"
                )
        );

    }

}
