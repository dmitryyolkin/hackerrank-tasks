package sandbox.hackerrank.warmup;

public class SolutionStringTokens {
    private static final String PATTERN = "[ |!|,|?|.|_|'|@]+";

    public String[] calculate(String s) {
        return s.split(PATTERN);
    }

}
