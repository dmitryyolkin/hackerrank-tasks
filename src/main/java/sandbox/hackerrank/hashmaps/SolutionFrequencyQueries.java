package sandbox.hackerrank.hashmaps;

import java.util.*;

public class SolutionFrequencyQueries {

    // https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    // 1x: Insert x in your data structure.
    // 2y: Delete one occurence of y from your data structure, if present.
    // 3z: Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
    public List<Integer> calculate(List<List<Integer>> queries) {
        Map<Integer, Integer> value2Count = new HashMap<>();
        Map<Integer, Set<Integer>> count2Values = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            Integer cmd = query.get(0);
            Integer value = query.get(1);
            if (cmd < 3) {
                // modify map
                int prevValue = value2Count.computeIfAbsent(value, v -> 0);
                int newValue = (cmd == 1) ?
                        prevValue + 1 :
                        prevValue - 1;

                // remove old value from count2values
                Set<Integer> values = count2Values.get(prevValue);
                if (values != null) {
                    values.remove(value);
                    if (values.isEmpty()) {
                        count2Values.remove(prevValue);
                    }
                }

                // modify new value
                if (newValue >= 0) {
                    value2Count.put(value, newValue);
                    count2Values
                            .computeIfAbsent(newValue, v -> new HashSet<>())
                            .add(value);
                }

            } else {
                // switch into result
                boolean match = !count2Values.computeIfAbsent(value, v -> new HashSet<>()).isEmpty();
                result.add(match ? 1 : 0);
            }
        }

        return result;
    }

}
