package sandbox.different;

import java.util.Objects;

public class BestSellSolution {

    // Search array indexes when it's the most profitable to buy and sell a stock (difference is max)
    // Complexity: O(n)
    // Test cases:
    //      * 1st: 10 5 500 100 300 -> (1, 2)
    //      * 2nd: 500 400 300 200 150 -> (3,4)
    public Pair calc(int[] prices) {
        if (prices.length < 2) {
            // too few elements
            return null;
        }

        // Initialize initial values
        int minIndex = 0;
        int maxIndex = 1;

        int currDiff = prices[maxIndex] - prices[minIndex];
        int maxDiff = currDiff;
        for (int i = 1; i < prices.length - 1; i++) {
            // Calculate current diff
            int j = i + 1;
            int diff = prices[j] - prices[i];

            int minIndexCandidate = minIndex;
            if (currDiff > 0) {
                // continue looking for next max
                currDiff += diff;
            } else {
                // assign currDiff to diff
                currDiff = diff;
                minIndexCandidate = i;
            }

            // Update max sum, if needed
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
                minIndex = minIndexCandidate;
                maxIndex = j;
            }
        }

        return new Pair(minIndex, maxIndex);
    }

    // instead of it
    // data class can be used in Kotlin
    // @Data can be used with Java + Lombok
    // record starting with JDK17
    static class Pair {
        private final int min;
        private final int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return min == pair.min && max == pair.max;
        }

        @Override
        public int hashCode() {
            return Objects.hash(min, max);
        }
    }

}
