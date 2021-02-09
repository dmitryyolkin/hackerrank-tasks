package sandbox.hackerrank.sorting;

public class SolutionBubbleSort {

    // https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
    // Example
    // swap    a
    // 0       [6,4,1]
    // 1       [4,6,1]
    // 2       [4,1,6]
    // 3       [1,4,6]
    public int calculate(int[] a) {
        int swaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaps++;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.%n", swaps);
        System.out.printf("First Element: %d%n", a[0]);
        System.out.printf("Last Element: %d%n", a[a.length - 1]);
        return swaps;
    }

    private void swap(int[] a, int i, int j){
        int v = a[i];
        a[i] = a[j];
        a[j] = v;
    }

}
