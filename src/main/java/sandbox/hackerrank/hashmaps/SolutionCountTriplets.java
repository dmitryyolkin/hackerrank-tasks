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
        Set<List<Long>> triplets = new HashSet<>();
        Map<Long, Set<Integer>> value2Indexes = new HashMap<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            Long third = arr.get(i);
            long second = third / r;
            long first = second / r;
            if (first >= 1 && (third % r == 0)) {
                // potential combination
                List<Long> candidates = new ArrayList<>();
                candidates.add(first);
                candidates.add(second);
                candidates.add(third);
                triplets.add(candidates);
            }

            Set<Integer> indexes = value2Indexes.computeIfAbsent(third, v -> new HashSet<>());
            indexes.add(i);
        }

        long sum = 0;
        for (List<Long> triplet : triplets) {
            long cnt = 1;
            for (Long value : triplet) {
                Set<Integer> indexes = value2Indexes.get(value);
                if (indexes == null || indexes.isEmpty()) {
                    // no such triplet in our array
                    cnt = 0;
                    break;
                }

                cnt *= indexes.size();
            }

            if (cnt > 0) {
                sum += cnt;
            }
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
