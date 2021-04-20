package sandbox.hackerrank.miscellaneous;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionPrimeTest {
    @Test
    public void testSolution() {
        SolutionPrime solution = new SolutionPrime();
//        assertEquals(
//                "Not prime",
//                solution.calculate(12)
//        );

        assertEquals(
                "Not prime",
                solution.calculate(4)
        );

        assertEquals(
                "Prime",
                solution.calculate(5)
        );

        assertEquals(
                "Prime",
                solution.calculate(7)
        );

        assertEquals(
                "Prime",
                solution.calculate(907)
        );


    }

}
