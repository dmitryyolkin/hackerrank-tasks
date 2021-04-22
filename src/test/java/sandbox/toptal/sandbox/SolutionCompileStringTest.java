package sandbox.toptal.sandbox;

import org.junit.Test;
import sandbox.toptal.sandbox.SolutionCompileString;

import static org.junit.Assert.assertEquals;

public class SolutionCompileStringTest {
    @Test
    public void testSolution() {
        SolutionCompileString solution = new SolutionCompileString();
        assertEquals(
                "PERU",
                solution.calculate(new String[]{"P>E","E>R","R>U"})
        );

        assertEquals(
                "SPAIN",
                solution.calculate(new String[]{"I>N","A>I","P>A","S>P"})
        );

    }

}
