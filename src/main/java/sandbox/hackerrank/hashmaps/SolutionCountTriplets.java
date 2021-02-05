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
        Set<Triplet> triplets = new HashSet<>();
        Map<Long, List<Integer>> value2Indexes = new HashMap<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            Long third = arr.get(i);
            if (third % r == 0) {
                long second = third / r;
                long first = second / r;
                if (first >= 1) {
                    // potential combination
                    triplets.add(new Triplet(first, second, third));
                }
            }

            List<Integer> indexes = value2Indexes.computeIfAbsent(third, v -> new ArrayList<>());
            indexes.add(i);
        }

        long sum = 0;
        for (Triplet triplet : triplets) {

            List<Integer> firstIndexes = value2Indexes.get(triplet.getFirst());
            List<Integer> secondIndexes = value2Indexes.get(triplet.getSecond());
            List<Integer> thirdIndexes = value2Indexes.get(triplet.getThird());
            if (firstIndexes == null || firstIndexes.isEmpty() ||
                    secondIndexes == null || secondIndexes.isEmpty() ||
                    thirdIndexes == null || thirdIndexes.isEmpty()) {
                // no such triplex
                continue;
            }

            for (Integer firstIndex : firstIndexes) {
                for (Integer secondIndex : secondIndexes) {
                    if (secondIndex <= firstIndex) {
                        // second can't be before first
                        break;
                    }

                    Integer breakIndex = null;
                    for (int i = 0; i < thirdIndexes.size(); i++) {
                        Integer thirdIndex = thirdIndexes.get(i);
                        if (thirdIndex <= secondIndex) {
                            // third can't be before second
                            breakIndex = i;
                            break;
                        }
                    }

                    sum += (breakIndex != null ? breakIndex : thirdIndexes.size());
                }
            }
        }

        return sum;
    }

    private static class Triplet{
        private final long first;
        private final long second;
        private final long third;

        public Triplet(long first, long second, long third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public long getFirst() {
            return first;
        }

        public long getSecond() {
            return second;
        }

        public long getThird() {
            return third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return first == triplet.first &&
                    second == triplet.second &&
                    third == triplet.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
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
