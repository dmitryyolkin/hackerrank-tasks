package sandbox.hackerrank.loops;

public class SolutionLoop1 {

    // https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true
    public int[] calculate(int a, int b, int n) {
        int[] result = new int[n];
        int prevV = a;
        for (int i = 0; i < n; i++) {
            int v = prevV + (int) Math.pow(2, i) * b;
            result[i] = v;
            prevV = v;
        }
        return result;
    }

}
