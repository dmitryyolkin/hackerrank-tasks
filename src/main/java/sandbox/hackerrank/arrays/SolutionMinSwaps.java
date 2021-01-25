package sandbox.hackerrank.arrays;

public class SolutionMinSwaps {

    // https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    // You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements.
    // You need to find the minimum number of swaps required to sort the array in ascending order.
    // Example:
    // 2 3 4 1 5
    // min = 3

    // 1 3 5 2 4 6 7
    // min = 3
    public int calculate(int[] arr) {
        int swaps = 0;
        int i = 0;
        while (i < arr.length - 1){
            int currV = arr[i];
            if (currV == (i + 1)) {
                // i - element is on its place
                i++;
            } else {
                swap(arr, i, currV - 1);
                swaps++;
            }
        }
        return swaps;
    }

    private void swap(int[] arr, int i, int j) {
        int v = arr[i];
        arr[i] = arr[j];
        arr[j] = v;
    }

}
