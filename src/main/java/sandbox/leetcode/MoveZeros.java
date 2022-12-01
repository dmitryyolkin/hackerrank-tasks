package sandbox.leetcode;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int processed = 0;
        while (i + processed < nums.length) {
            int curr = nums[i];
            if (curr == 0) {
                // shift
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[nums.length - 1] = curr;
                processed++;
            } else {
                i++;
            }
        }
    }

}
