package sandbox.hackerrank.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SolutionNewYearChaos {

    // https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    // Example
    // 2, 1, 5, 3, 4
    // 3, Too chaotic = false

    // 2, 5, 1, 3, 4
    // 4, Too chaotic = true
    public NewYearResult calculate(int[] q) {
        int shifts = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return new NewYearResult(true, null);
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) {
                    shifts++;
                }
        }
        System.out.println(shifts);
        return new NewYearResult(false, shifts);
    }

    // this solution works too slow on long arrays
    public NewYearResult calculateWithShifts(int[] t) {
        Map<Integer, Integer> shifts = new HashMap<>();
        int processedV = t.length; // go to backward order
        while (!ordered(t)) {
            for (int i = t.length - 1; i >= 0; i--) {
                int v = t[i];
                if (v != processedV) {
                    // strat ordering from 1st to last
                    continue;
                }

                int expectedV = i + 1;
                boolean changed = false;
                if (v < expectedV) {
                    // swap with left
                    t[i] = t [i - 1];
                    t[i - 1] = v;
                    changed = true;
                } else if (v > expectedV) {
                    // shift with right
                    t[i] = t [i + 1];
                    t[i + 1] = v;
                    changed = true;
                }

                if (t[processedV - 1] == processedV) {
                    // current is fixed
                    processedV--;
                }

                if (changed) {
                    Integer prevShifts = Optional.ofNullable(shifts.get(v)).orElse(0);
                    shifts.put(v, ++prevShifts);
                    break;
                }
            }
        }

        // print values
        for (Integer value : shifts.values()) {
            if (value > 2) {
                System.out.println("Too chaotic");
                return new NewYearResult(true, null);
            }
        }

        int sumShifts = shifts.values().stream().mapToInt(v -> v).sum();
        System.out.println(sumShifts);
        return new NewYearResult(
                false,
                sumShifts
        );
    }

    private boolean ordered(int[] q) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] != (i + 1)) {
                return false;
            }
        }
        return true;
    }

    static class NewYearResult {
        private Boolean tooChaotic;
        private Integer swaps;

        public NewYearResult(Boolean tooChaotic, Integer swaps) {
            this.tooChaotic = tooChaotic;
            this.swaps = swaps;
        }

        public Boolean getTooChaotic() {
            return tooChaotic;
        }

        public Integer getSwaps() {
            return swaps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NewYearResult that = (NewYearResult) o;
            return Objects.equals(tooChaotic, that.tooChaotic) &&
                    Objects.equals(swaps, that.swaps);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tooChaotic, swaps);
        }

        @Override
        public String toString() {
            return "NewYearResult{" +
                    "tooChaotic=" + tooChaotic +
                    ", swaps=" + swaps +
                    '}';
        }
    }

}
