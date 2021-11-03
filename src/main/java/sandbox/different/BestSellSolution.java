package sandbox.different;

import com.sun.istack.internal.Nullable;

import java.util.Objects;

public class BestSellSolution {

    // n ahead and buy and then sell
    // 10 5 500 100 300
    @Nullable
    public Pair calc(int[] prices) {
        Pair maxPair = null;
        Integer maxPrice = null;
        for (int i = 0; i < prices.length; i++) {
            int priceI = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int priceJ = prices[j];
                int currMaxPrice = priceJ - priceI;
                if (maxPrice == null || currMaxPrice > maxPrice) {
                    maxPrice = currMaxPrice;
                    maxPair = new Pair(i, j);
                }
            }
        }
        return maxPair;
    }

    static class Pair {
        private final int min;
        private final int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
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
