package sandbox.hackerrank.search;

import java.util.HashMap;
import java.util.Map;

public class SolutionIceCream {

    // https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
    public int[] calculate(int[] cost, int money) {
        Map<Integer, Integer> candidate2FirstFlavorIndex = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int iCost = cost[i];
            if (iCost < money) {
                Integer firstIndex = candidate2FirstFlavorIndex.get(money - iCost);
                if (firstIndex != null) {

                    int i1 = firstIndex + 1;
                    int i2 = i + 1;
                    System.out.println(i1 + " " + i2);
                    return new int[]{i1, i2};
                } else {
                    candidate2FirstFlavorIndex.put(iCost, i);
                }
            }
        }
        return new int[]{};
    }

}
