package sandbox.hackerrank.hashmaps;

import org.junit.Test;
import sandbox.SolutionTemplate;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionFrequencyQueriesTest {
    @Test
    public void testSolution() {
        SolutionFrequencyQueries solution = new SolutionFrequencyQueries();
        assertEquals(
                Arrays.asList(0, 1, 1),
                solution.calculate(Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 3),
                        Arrays.asList(3, 2),
                        Arrays.asList(1, 4),
                        Arrays.asList(1, 5),
                        Arrays.asList(1, 5),
                        Arrays.asList(1, 4),
                        Arrays.asList(3, 2),
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 2)
                ))
        );


        assertEquals(
                Arrays.asList(0, 1),
                solution.calculate(Arrays.asList(
                        Arrays.asList(1, 5),
                        Arrays.asList(1, 6),
                        Arrays.asList(3, 2),
                        Arrays.asList(1, 10),
                        Arrays.asList(1, 10),
                        Arrays.asList(1, 6),
                        Arrays.asList(2, 5),
                        Arrays.asList(3, 2)
                ))
        );

        assertEquals(
                Arrays.asList(0, 1),
                solution.calculate(Arrays.asList(
                        Arrays.asList(3, 4),
                        Arrays.asList(2, 1003),
                        Arrays.asList(1, 16),
                        Arrays.asList(3, 1)
                ))
        );

    }

}
