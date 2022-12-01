package sandbox.leetcode;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MozeZerosTest {
    @Test
    public void testSolution() {
        MoveZeros solution = new MoveZeros();

        // 1
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1,3,12,0,0},
                nums
        );

        // 2
        nums = new int[]{0};
        solution.moveZeroes(nums);
        assertArrayEquals(
                new int[]{0},
                nums
        );

        // 3
        nums = new int[]{0,0,1};
        solution.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1,0,0},
                nums
        );
    }

}
