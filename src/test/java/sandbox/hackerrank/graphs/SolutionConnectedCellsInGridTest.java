package sandbox.hackerrank.graphs;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionConnectedCellsInGridTest {
    @Test
    public void testSolution() {
        SolutionConnectedCellsInGrid solution = new SolutionConnectedCellsInGrid();
        assertEquals(
                5,
                solution.calculate(
                        new int[][]{
                                {1, 1, 0, 0},
                                {0, 1, 1, 0},
                                {0, 0, 1, 0},
                                {1, 0, 0, 0}
                        }
                )
        );

        assertEquals(
                6,
                solution.calculate(
                        new int[][]{
                                {1, 1, 0, 0},
                                {0, 1, 1, 0},
                                {0, 0, 1, 0},
                                {1, 0, 0, 1}
                        }
                )
        );

        assertEquals(
                9,
                solution.calculate(
                        new int[][]{
                                {1, 1, 0, 0},
                                {0, 1, 1, 0},
                                {0, 0, 1, 0},
                                {1, 1, 1, 1}
                        }
                )
        );


    }

}
