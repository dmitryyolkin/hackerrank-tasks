package sandbox.hackerrank.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class SolutionTwoStrings {

    private static final String YES = "YES";
    private static final String NO = "NO";

    // https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    public String calculate(String s1, String s2) {
        Set<Character> set1 = split(s1);
        for (int i = 0; i < s2.length(); i++) {
            char char2 = s2.charAt(i);
            if (set1.contains(char2)) {
                return YES;
            }
        }
        return NO;
    }

    private Set<Character> split(String s) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
             chars.add(s.charAt(i));
        }
        return chars;
    }

}
