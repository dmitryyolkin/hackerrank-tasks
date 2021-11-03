package sandbox.different;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTime2SellStockSolutionTest {

    @Test
    public void test() {
        BestTime2SellStockSolution task = new BestTime2SellStockSolution();
        assertEquals(
                new BestTime2SellStockSolution.Pair(1, 2),
                task.calc(new int[]{10, 5, 500, 100, 300})
        );

        assertEquals(
                new BestTime2SellStockSolution.Pair(1, 5),
                task.calc(new int[]{10, 5, 500, 100, 300, 700})
        );

        assertEquals(
                new BestTime2SellStockSolution.Pair(3, 4),
                task.calc(new int[]{500, 400, 300, 200, 150})
        );

        assertEquals(
                new BestTime2SellStockSolution.Pair(1, 2),
                task.calc(new int[]{500, 400, 360, 200, 150})
        );


    }
}
