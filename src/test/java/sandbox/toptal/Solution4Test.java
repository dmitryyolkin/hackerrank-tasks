package sandbox.toptal;

import org.junit.Assert;
import org.junit.Test;
import sandbox.toptal.Solution4;

public class Solution4Test {
    @Test
    public void testSolution() {
        Solution4 solution = new Solution4();
        Assert.assertEquals(
                true,
                solution.solution(4, new int[]{1, 2, 4, 4, 3}, new int[]{2, 3, 1, 3, 1})
        );

        Assert.assertEquals(
                false,
                solution.solution(3, new int[]{1, 2, 3, 2}, new int[]{2, 3, 4, 4})
        );

        Assert.assertEquals(
                true,
                solution.solution(3, new int[]{1, 2, 3, 3}, new int[]{2, 3, 4, 1})
        );

        Assert.assertEquals(
                false,
                solution.solution(4, new int[]{1, 2, 3, 1}, new int[]{2, 3, 1, 3})
        );

    }

}
