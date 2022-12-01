package sandbox.leetcode;

public class RemoveElement {

    public int calculate(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int k = 0;
        for (int num : nums) {
            if (num != val) {
                temp[k++] = num;
            }
        }

        System.arraycopy(temp, 0, nums, 0, temp.length);
        return k;
    }

}
