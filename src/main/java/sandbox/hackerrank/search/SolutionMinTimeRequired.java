package sandbox.hackerrank.search;

import java.util.Arrays;

public class SolutionMinTimeRequired {

    // https://www.hackerrank.com/challenges/minimum-time-required/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
    public long calculate(long[] machines, long goal) {
        // sort for performance
        Arrays.sort(machines);

        long maxDaysPerOnemachine = machines[machines.length - 1];
        long minDays = 0;
        long maxDays = maxDaysPerOnemachine * goal;
        long result = -1;
        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;
            long units = 0;
            // calculate how many machines will be produced for middle days count
            for (long machine : machines) {
                units += (mid / machine);
            }

            if (units < goal) {
                minDays = mid +1;
            } else {
                result = mid;
                maxDays = mid;
            }
        }
        return result;
    }

}
