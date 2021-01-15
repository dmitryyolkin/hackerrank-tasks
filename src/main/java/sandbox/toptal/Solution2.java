package sandbox.toptal;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution2 {
    public String solution(String S) {
        // write your code in Java SE 8
        String numbers = S.replaceAll("[^0-9]","");

        boolean makeLastTwoGroupsByTwo = (numbers.length() % 3) == 1;
        int startLastTwoGroupsIndex = numbers.length() - 4;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length(); i++) {
            result.append(numbers.charAt(i));
            if (i == numbers.length() - 1) {
                // last symbol
                break;
            }

            if (makeLastTwoGroupsByTwo) {
                // group by two
                if (i >= startLastTwoGroupsIndex) {
                    // last 4 letters
                    if (i % 2 == 1) {
                        result.append('-');
                    }
                }
            }

            // standard logic
            if ((i + 1) % 3 == 0 &&
                    (!makeLastTwoGroupsByTwo || i < startLastTwoGroupsIndex)) {
                result.append('-');
            }

        }
        return result.toString();
    }
}
