package sandbox.hackerrank.sorting;

public class SolutionSpecialString {

    // https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
    // Example
    // abcbaba
    // a, b, c, b, a, b, a, bcb, bab, aba,
    public int calculate(int n, String s) {
        int result = s.length();

        for (int i = 2; i <= s.length(); i++) { // iter by groups (2, 3, .., length)
            //calculate combinations
            int medianIndex = i / 2;
            for (int j = 0; j < s.length(); j++) { // iter by letters
                char ch = s.charAt(j);
                if (j + i > s.length()) {
                    // no options
                    break;
                }

                boolean valid = true;
                for (int k = 1; k < i; k++) { // build a group of a certain langth
                    char c = s.charAt(j + k);
                    if (i % 2 == 1 && k == medianIndex) {
                        // odd letters - in the middle can be another letter
                        // ignore it
                    } else if (c != ch) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    result++;
                }

            }

        }
        return result;
    }

}
