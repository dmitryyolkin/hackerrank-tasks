package sandbox.hackerrank;

public class SolutionFibbonachi {

    public int calculate(int n) {
        // order = 0, 1, 2, 3, 4, 5, 6, ...
        // value = 0, 1, 1, 2, 3, 5, 8, ...
        if (n <= 1) {
            return n;
        }

        return calculate(n - 2) + calculate(n - 1);

//        via cycles
//        int prevBeforePrev = 0;
//        int prev = 1;
//        int curr = 0;
//        for (int i = 2; i <= n; i++) {
//            curr = prevBeforePrev + prev;
//            prevBeforePrev = prev;
//            prev = curr;
//        }
//        return curr;
    }
}
