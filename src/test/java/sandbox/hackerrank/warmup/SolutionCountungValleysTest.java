package sandbox.hackerrank.warmup;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionCountungValleysTest {
    @Test
    public void testSolution() {
        SolutionCountingVallyes solution = new SolutionCountingVallyes();
        assertEquals(
                1,
                solution.calculate(8, "UDDDUDUU")
        );

        assertEquals(
                1,
                solution.calculate(8, "DDUUUUDD")
        );

    }

}
