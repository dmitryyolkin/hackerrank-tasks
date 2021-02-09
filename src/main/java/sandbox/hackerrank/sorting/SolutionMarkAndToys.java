package sandbox.hackerrank.sorting;

import java.util.Arrays;

public class SolutionMarkAndToys {

    // https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

    // prices: 1 12 5 111 200 1000 10
    // budget: 50
    // max toys: 4
    public int calculate(int[] prices, int k) {
        Arrays.sort(prices);
        int limit = k;
        int count = 0;
        for (int price : prices) {
            limit -= price;
            if (limit < 0) {
                break;
            }
            count++;
        }
        return count;
    }

}
