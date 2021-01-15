package sandbox.toptal;

import org.junit.Assert;
import org.junit.Test;
import sandbox.toptal.Solution1;

public class Solution1Test {
    @Test
    public void testSolution() {
        Solution1 solution = new Solution1();
        Assert.assertEquals(
                "pom",
                solution.solution(
                        new String[]{"pim", "pom"},
                        new String[]{"999999999", "777888999"},
                        "88999"
                )
        );

        Assert.assertEquals(
                "amy",
                solution.solution(
                        new String[]{"sender", "amy", ""},
                        new String[]{"999999999", "777888999"},
                        "88999"
                )
        );

    }

}
