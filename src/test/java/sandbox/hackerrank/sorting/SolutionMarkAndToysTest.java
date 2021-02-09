package sandbox.hackerrank.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionMarkAndToysTest {
    @Test
    public void testSolution() {
        SolutionMarkAndToys solution = new SolutionMarkAndToys();
        assertEquals(
                4,
                solution.calculate(new int[]{1, 12, 5, 111, 200, 1000, 10}, 50)
        );
    }

}
