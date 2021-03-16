package sandbox.hackerrank.search;

import java.util.stream.IntStream;

public class SolutionTripleSum {

    // https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
    public long calculate(int[] a, int[] b, int[] c) {
        // sort for performance
        a = distAndSort(a);
        b = distAndSort(b);
        c = distAndSort(c);

        long sum = 0;
        for (int i = 0; i < b.length; i++) {
            int bElem = b[i];
            long aCounter = countArray(a, bElem);
            long cCounter = countArray(c, bElem);
            sum += (aCounter * cCounter);
        }

        return sum;
    }

    private int[] distAndSort(int[] a) {
        return IntStream.of(a).distinct().sorted().toArray();
    }

    private long countArray(int[] array, int value) {
        long counter = 0;
        for (int aElem : array) {
            if (value >= aElem) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

}
