package sandbox.different;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestSellSolutionTest {

    @Test
    public void test() {
        BestSellSolution task = new BestSellSolution();
        assertEquals(
                new BestSellSolution.Pair(1, 2),
                task.calc(new int[]{10, 5, 500, 100, 300})
        );

        assertEquals(
                new BestSellSolution.Pair(1, 5),
                task.calc(new int[]{10, 5, 500, 100, 300, 700})
        );

        assertEquals(
                new BestSellSolution.Pair(3, 4),
                task.calc(new int[]{500, 400, 300, 200, 150})
        );

        assertEquals(
                new BestSellSolution.Pair(1, 2),
                task.calc(new int[]{500, 400, 360, 200, 150})
        );


    }
}
