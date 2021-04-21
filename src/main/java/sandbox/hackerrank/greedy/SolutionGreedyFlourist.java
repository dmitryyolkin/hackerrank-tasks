package sandbox.hackerrank.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionGreedyFlourist {

    // https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
    public int calculate(int k, int[] c) {
        Arrays.sort(c);
        int minOverallPrice = 0;
        Map<Integer, Integer> buyer2Count = new HashMap<>();
        for (int i = c.length - 1; i >= 0; i--) {
            int originalPrice = c[i];
            int buyerNumber = i % k;
            Integer currentBuyerCount = buyer2Count.computeIfAbsent(buyerNumber, v -> 0);
            minOverallPrice += (++currentBuyerCount) * originalPrice;
            buyer2Count.put(buyerNumber, currentBuyerCount);
        }
        return minOverallPrice;
    }

}
