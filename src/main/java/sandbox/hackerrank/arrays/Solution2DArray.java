package sandbox.hackerrank.arrays;

public class Solution2DArray {

    // https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    // calculate hourglass sum
    public int calculate(int[][] arr) {
        int dimension = 0;
        for (int[] rows : arr) {
            if (dimension == 0 || rows.length > dimension) {
                dimension = rows.length;
            }
        }

        if (dimension != arr.length) {
            throw new IllegalArgumentException("Matrix is not square");
        }

        Integer max = null;
        for (int i = 0; i < dimension - 2; i++) {
            int[] topRow = arr[i];
            int[] middleRow = arr[i + 1];
            int[] bottomRow = arr[i + 2];

            // calculate top row
            for (int j = 0; j < dimension - 2; j++) {
                int sum = 0;
                // calculate according to hourglass shape
                sum += (topRow[j] + topRow[j + 1] + topRow[j + 2]);
                sum += (middleRow[j + 1]);
                sum += (bottomRow[j] + bottomRow[j + 1] + bottomRow[j + 2]);

                if (max == null || sum > max) {
                    max = sum;
                }
            }
        }
        return max != null ? max : 0;
    }

}
