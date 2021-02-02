package sandbox.hackerrank.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class SolutionSherlockAndAnagrams {

    // https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    // Example
    // abba
    // 1. a, a
    // 2. ab, ba
    // 3. b, b
    // 4. abb, bba
    public int calculate(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int k = 1; k < (s.length() - i); k++) {
                // how much letters are checked
                Map<Character, Integer> currSet = split(s.substring(i, i + k));
                for (int j = s.length() - 1; j > (i + k - 1); j--) {
                    if (currSet.equals(split(s.substring(j - k + 1, j + 1)))) {
                        sum++;
                    }
                }

            }
        }

        return sum;
    }

    private Map<Character, Integer> split(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer cnt = chars.computeIfAbsent(ch, k -> 0);
            chars.put(ch, ++cnt);
        }
        return chars;
    }

}
