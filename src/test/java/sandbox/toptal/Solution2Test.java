package sandbox.toptal;

import org.junit.Assert;
import org.junit.Test;
import sandbox.toptal.Solution2;

public class Solution2Test {
    @Test
    public void testSolution() {
        Solution2 solution = new Solution2();
        Assert.assertEquals(
                "004-448-555-583-61",
                solution.solution("00-44  48 5555 8361")
        );

        Assert.assertEquals(
                "022-198-53-24",
                solution.solution("0 - 22 1985--324")
        );

    }

}
