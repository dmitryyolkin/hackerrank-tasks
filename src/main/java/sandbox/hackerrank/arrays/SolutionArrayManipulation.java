package sandbox.hackerrank.arrays;

public class SolutionArrayManipulation {

    // https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    // Example
    // 5 3
    // 1 2 100
    // 2 5 100
    // 3 4 100

    // Result: 200
    public long calculate(int n, int[][] queries) {
        long[] arr = new long[n];
        long max = 0;
        for (int[] row : queries) {
            int startIndex = row[0] - 1;
            int endIndex = row[1] - 1;
            int value = row[2];
            for (int k = startIndex; k <= endIndex; k++) {
                long prevValue = arr[k];
                long newValue = (prevValue + value);
                arr[k] = newValue;
                if (newValue > max) {
                    max = newValue;
                }
            }
        }
        return max;
    }

}
