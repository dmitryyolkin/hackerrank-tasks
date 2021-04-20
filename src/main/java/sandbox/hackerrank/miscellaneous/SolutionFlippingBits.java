package sandbox.hackerrank.miscellaneous;

public class SolutionFlippingBits {

    // https://www.hackerrank.com/challenges/flipping-bits/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
    public long calculate(long n) {
        String binaryString = Long.toBinaryString(n);
        StringBuilder binaryStringInput = new StringBuilder();
        if (binaryString.length() < 32) {
            for (int i = 0; i < 32 - binaryString.length(); i++) {
                binaryStringInput.append('0');
            }
        }
        binaryStringInput.append(binaryString);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryStringInput.length(); i++) {
             if (binaryStringInput.charAt(i) == '0') {
                 result.append('1');
             } else {
                 result.append('0');
             }

        }
        return Long.parseLong(result.toString(), 2);
    }

}
