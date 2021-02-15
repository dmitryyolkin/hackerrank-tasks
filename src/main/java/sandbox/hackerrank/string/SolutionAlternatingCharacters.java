package sandbox.hackerrank.string;

public class SolutionAlternatingCharacters {

    // https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
    // Example:
    // AAAA -> 3
    // BBBBB -> 4
    // ABABABAB -> 0
    // BABABA -> 0
    // AAABBB -> 4
    public int calculate(String s) {
        int deletion = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
             char curr = s.charAt(i);
             if (prev == curr) {
                 deletion++;
             } else {
                 prev = curr;
             }
        }
        return deletion;
    }

}
