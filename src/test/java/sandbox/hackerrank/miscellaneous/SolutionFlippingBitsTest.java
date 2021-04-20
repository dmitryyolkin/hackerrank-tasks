package sandbox.hackerrank.miscellaneous;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionFlippingBitsTest {
    @Test
    public void testSolution() {
        SolutionFlippingBits solution = new SolutionFlippingBits();
        assertEquals(
                2147483648L,
                solution.calculate(2147483647)
        );
    }

}
