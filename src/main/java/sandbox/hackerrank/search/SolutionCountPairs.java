package sandbox.hackerrank.search;

import java.util.HashMap;
import java.util.Map;

public class SolutionCountPairs {

    // https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
    public int calculate(int k, int[] arr) {
        // transform arr to map for performance improvements
        Map<Integer, Integer> value2Count = new HashMap<>();
        for (int value : arr) {
            Integer count = value2Count.computeIfAbsent(value, v -> 0);
            value2Count.put(value, ++count);
        }

        // calculate diff pairs
        int sum = 0;
        for (int value : arr) {
            int candidate = value - k;
            if (candidate >= 0) {
                Integer candidateCount = value2Count.get(candidate);
                if (candidateCount != null && candidateCount > 0) {
                    if (candidate == 0) {
                        // no diff
                        if (candidateCount > 1) {
                            sum++;
                            value2Count.put(candidate, candidateCount - 2);

                        }
                    } else {
                        // candidate > 0
                        sum++;
                        value2Count.put(candidate, --candidateCount);
                    }

                }
            }
        }
        return sum;
    }

}
