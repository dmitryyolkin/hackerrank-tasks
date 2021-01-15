package sandbox.codility;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodilityPreparation {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        Set<Integer> set = IntStream
                .of(A)
                .boxed()
                .filter(v -> v > 0)
                .collect(Collectors.toSet());

        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return length + 1;
    }
}
