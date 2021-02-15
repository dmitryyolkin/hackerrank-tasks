package sandbox.hackerrank.string;

import java.util.Map;
import java.util.stream.Collectors;

public class SolutionMakingAnagrams {

    // https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
    public int calculate(String a, String b) {
        Map<Character, Integer> a2Count = string2CharsMap(a);
        Map<Character, Integer> b2Count = string2CharsMap(b);

        int sum = 0;
        // check a
        for (Map.Entry<Character, Integer> entry : a2Count.entrySet()) {
            Integer aCnt = entry.getValue();
            Integer bCnt = b2Count.get(entry.getKey());
            if (bCnt == null || bCnt == 0) {
                sum += aCnt;
            } else {
                sum += Math.abs(aCnt - bCnt);
            }
        }

        // check b
        for (Map.Entry<Character, Integer> entry : b2Count.entrySet()) {
            if (!a2Count.containsKey(entry.getKey())) {
                sum += entry.getValue();
            }
        }

        return sum;
    }

    private Map<Character, Integer> string2CharsMap(String str) {
        return str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.toList()
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));
    }

}
