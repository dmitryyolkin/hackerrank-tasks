package sandbox.toptal;

import org.junit.Assert;
import org.junit.Test;
import sandbox.toptal.Solution3;

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
