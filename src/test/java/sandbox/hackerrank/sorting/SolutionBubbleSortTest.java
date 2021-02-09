package sandbox.hackerrank.sorting;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionBubbleSortTest {
    @Test
    public void testSolution() {
        SolutionBubbleSort solution = new SolutionBubbleSort();
        assertEquals(
                3,
                solution.calculate(new int[]{3, 2, 1})
        );
    }

}
