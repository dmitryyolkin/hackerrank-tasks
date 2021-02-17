package sandbox.hackerrank.string;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionValidString {

    // https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
    // Example
    // abc -> YES
    // abcc -> YES
    // aabbcd -> NO
    public String calculate(String s) {
        Map<Character, Integer> char2Count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer cnt = char2Count.computeIfAbsent(ch, v -> 0);
            char2Count.put(ch, ++cnt);
        }

        // transform char2Count to counts2Chars
        Map<Integer, List<Map.Entry<Character, Integer>>> count2Chars = char2Count
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.toList()));

        if (count2Chars.size() == 1) {
            // all letters occurred the same amount of times
            return "YES";
        } else if (count2Chars.size() == 2) {
            // border case
            List<Map.Entry<Character, Integer>> single = count2Chars.get(1);
            if (single != null && single.size() == 1) {
                // there is one letter occurring one time only
                // we can remove it and all is ok
                return "YES";
            }

            // find max
            int maxOccurrences = count2Chars.keySet().stream().mapToInt(i -> i).max().orElse(0);
            List<Map.Entry<Character, Integer>> maxChars = count2Chars.get(maxOccurrences);
            if (maxChars.size() == 1 && count2Chars.get(maxOccurrences - 1) != null) {
                // we can remove one occurrence of max element
                // and its count will be the same as for other letters
                return "YES";
            }
        }
        return "NO";
    }

}
