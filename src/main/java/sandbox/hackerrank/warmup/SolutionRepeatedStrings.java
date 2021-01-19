package sandbox.hackerrank.warmup;

public class SolutionRepeatedStrings {

    // There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer,
    // find and print the number of letter a's in the first  letters of the infinite string.

    // Example
    // sample aba
    // 10
    // 7
    public long calculate(String s, long n) {
        if (s.isEmpty()) {
            return 0;
        }

        long aInSample = calculateACount(s, s.length());
        long fullCount = aInSample * (n / s.length());
        int partiallyCount = (int) (n % s.length());
        return fullCount + calculateACount(s, partiallyCount);
    }

    private long calculateACount(String s, int length) {
        long count = 0;
        for (int i = 0; i < length; i++) {
             if (s.charAt(i) == 'a') {
                 count++;
             }
        }
        return count;
    }

}
