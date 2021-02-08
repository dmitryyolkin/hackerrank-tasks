package sandbox.hackerrank.hashmaps;

import java.util.*;

public class SolutionCountTriplets {

    // https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    // Example:
    // 1 2 2 4
    // result - 2 ([0,1,3], [0,2,3])

    // 1 3 9 9 27 81
    // result - 6
    public long calculate(List<Long> arr, long r) {
        // Details are explained here https://www.thepoorcoder.com/hackerrank-count-triplets-solution/
        // fill two maps (values from right of the value, values from left of the value)
        Map<Long, Integer> value2LeftCount = new HashMap<>();
        Map<Long, Integer> value2RightCount = new HashMap<>();
        for (Long v : arr) {
            Integer cnt = value2RightCount.computeIfAbsent(v, value -> 0);
            value2RightCount.put(v, ++cnt);
        }

        long sum = 0;
        for (long middle : arr) {
            // value is middle of potential triplet
            long left = middle / r;
            long right = middle * r;

            // remove middle value from right map
            Integer prevMiddleCount = value2RightCount.get(middle);
            value2RightCount.put(middle, --prevMiddleCount);

            if (middle % r == 0) {
                // cast to long to exclude int overflow when prevLeftCnt * prevRightCnt
                long prevLeftCnt = (long) Optional.ofNullable(value2LeftCount.get(left)).orElse(0);
                long prevRightCnt = (long) Optional.ofNullable(value2RightCount.get(right)).orElse(0);
                if (prevLeftCnt != 0 && prevRightCnt != 0) {
                    sum += (prevLeftCnt * prevRightCnt);
                }
            }

            // shift middle value left map
            Integer cnt = value2LeftCount.computeIfAbsent(middle, v -> 0);
            value2LeftCount.put(middle, ++cnt);
        }
        return sum;
    }

    // It works via recursion and provides correct answers but
    // it takes too many operations what is not efficient on big arrays
    public long calculateByRecursion(List<Long> arr, long r) {
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            // search triplets starting from each element in initial array
            sum += step(arr, new ArrayList<>(), i, r);
        }
        return sum;
    }

    private long step(List<Long> all, List<Long> candidates, int startIndex, long r) {
        if (candidates.size() == 3) {
            return 1;
        }

        long sum = 0;
        for (int i = startIndex; i < all.size(); i++) {
            Long value = all.get(i);
            if (candidates.isEmpty()) {
                if (value == 1 || (value % r == 0)) {
                    // 1st candidate
                    candidates.add(value);
                }
            } else {
                Long prevValue = candidates.get(candidates.size() - 1);
                if ((prevValue == 1 && value == r) ||
                        (prevValue > 1 && ((double) value) / prevValue == r)) {
                    // geometric regression case
                    List<Long> newCandidates = new ArrayList<>(candidates);
                    newCandidates.add(value);
                    sum += step(
                            all,
                            newCandidates, i + 1, r
                    );
                }
            }
        }
        return sum;
    }

}
