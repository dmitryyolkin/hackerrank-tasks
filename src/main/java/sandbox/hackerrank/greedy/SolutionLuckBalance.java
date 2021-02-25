package sandbox.hackerrank.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionLuckBalance {

    // https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
    public int calculate(int k, int[][] contests) {
        int overallImportant = 0;
        for (int[] contest : contests) {
            if (contest[1] > 0) {
                overallImportant++;
            }
        }

        // sort by luck factor to decrease algorithm's complexity
        Arrays.sort(contests, Comparator.comparingInt(a -> a[0]));
        int sum = 0;
        int possibleLoses = overallImportant - k;
        for (int[] contest : contests) {
            int luck = contest[0];
            int importance = contest[1];
            if (importance == 0) {
                sum += luck;
            } else {
                possibleLoses--;
                sum += (possibleLoses < 0 ? luck : -luck);
            }
        }
        return sum;
    }

}
