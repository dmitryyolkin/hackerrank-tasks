package sandbox.hackerrank.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionCastleOnTheGridTest {
    @Test
    public void testSolution() {
        SolutionCastleOnTheGrid solution = new SolutionCastleOnTheGrid();
        assertEquals(
                2,
                solution.calculate(
                        new String[]{
                                "...",
                                ".X.",
                                "..."
                        },
                        0,0,
                        1,2
                )
        );

        assertEquals(
                3,
                solution.calculate(
                        new String[]{
                                ".X.",
                                ".X.",
                                "..."
                        },
                        0,0,
                        0,2
                )
        );

    }

}
