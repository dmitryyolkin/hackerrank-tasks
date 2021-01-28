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
        // Solution
        // 1     2     3        4     5
        // 0     0     0        0     0     - start
        // 100   0     -100     0     0     - 1st
        // 100   100   -100     0     0     - 2nd
        // 100   100   0        0     -100  - 3rd
        long[] arr = new long[n];
        for (int[] row : queries) {
            int startIndex = row[0];
            int endIndex = row[1];
            int value = row[2];

            arr[startIndex - 1] += value;
            if (endIndex < n) {
                // inclusive
                arr[endIndex] -= value;
            }
        }

        long max = 0;
        long x = 0;
        for (long value : arr) {
            x += value;
            if (max < x) {
                max = x;
            }
        }
        return max;
    }

    public long calculateUsual(int n, int[][] queries) {
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
