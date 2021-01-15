package sandbox;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTemplateTest {
    @Test
    public void testSolution() {
        SolutionTemplate solution = new SolutionTemplate();
        assertEquals(
                0,
                solution.calculate()
        );
    }

}
