package sandbox.toptal.tour2;

import org.junit.Assert;
import org.junit.Test;
import sandbox.toptal.tour2.Solution3;

public class Solution3Test {
    @Test
    public void testSolution() {
        Solution3 solution = new Solution3();
        Assert.assertEquals(
                7,
                solution.solution(2014, "April", "May", "Wednesday")
        );


    }

}
