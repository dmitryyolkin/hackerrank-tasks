package sandbox.hackerrank.arrays;

public class SolutionLeftRotation {

    // https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    // Example:
    // 1, 2, 3, 4, 5
    // 4
    // Expected result: 5, 1, 2, 3, 4
    public int[] calculate(int[] a, int d) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int newIndex = i - d;
            if (newIndex < 0) {
                newIndex += a.length;
            }
            result[newIndex] = a[i];
        }
        return result;
    }

}
