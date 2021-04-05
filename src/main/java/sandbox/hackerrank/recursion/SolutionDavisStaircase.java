package sandbox.hackerrank.recursion;

import java.util.HashMap;
import java.util.Map;

public class SolutionDavisStaircase {

    // https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
    public int calculate(int n) {
        return check(new int[]{1, 2, 3}, n, new HashMap<>());
    }

    // cache is used to speed up calculations
    // not to calculate the same rest twice
    private int check(int[] steps, int rest, Map<Integer, Integer> cache) {
        Integer cachedValue = cache.get(rest);
        if (cachedValue != null) {
            return cachedValue;
        }

        int counter = 0;
        for (int step : steps) {
            int newRest = rest - step;
            if (newRest <= 0) {
                if (newRest == 0) {
                    counter++;
                }
                break;
            } else {
                counter += check(steps, newRest, cache);
            }
        }
        cache.put(rest, counter);
        return counter;
    }
}
