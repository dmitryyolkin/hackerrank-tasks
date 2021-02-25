package sandbox.hackerrank.greedy;

import java.util.Arrays;

public class SolutionMinDiff {

    // https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
    public int calculate(int[] arr) {
        // sorting helps to speed up process
        // if we don't sort then complexity = O(n^2)
        // if we sort (by default is Merge sort with O(n log(n))) then overall complexity = O(n) + O(n log(n))
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

}
