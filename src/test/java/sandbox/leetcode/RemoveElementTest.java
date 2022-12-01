package sandbox.leetcode;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static java.util.Arrays.sort;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveElementTest {
    @Test
    public void testSolution() {
        testElements(
                new int[]{3,2,2,3},
                3,
                new int[]{2,2}
        );
        testElements(
                new int[]{0,1,2,2,3,0,4,2},
                2,
                new int[]{0,0,1,3,4}
        );

    }

    private void testElements(int[] nums, int val, int[] expectedNums) {
        RemoveElement solution = new RemoveElement();
        int k = solution.calculate(nums, val); // Calls your implementation

        assertEquals(expectedNums.length, k);
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

}
