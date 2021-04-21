package sandbox.hackerrank.greedy;

import java.util.Arrays;

public class SolutionMinMaxUnfairness {

    // https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
    public int calculate(int k, int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int diff = arr[i + k - 1] - arr[i];
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

}
