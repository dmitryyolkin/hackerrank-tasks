package sandbox.hackerrank.miscellaneous;

public class SolutionPrime {
    private static final String PRIME = "Prime";
    private static final String NOT_PRIME = "Not prime";

    public String calculate(int n) {
        if (n < 6) {
            return n == 1 || n == 4 ? NOT_PRIME : PRIME;
        }

        for (int i = 2; i < n / 2; i++) {
             if (n % i == 0) {
                 return NOT_PRIME;
             }
        }
        return PRIME;
    }

}
