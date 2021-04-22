package sandbox.toptal.tour2;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Optional;

class Solution1 {
    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8

        String candidate = null;
        for (int i = 0; i < B.length; i++) {
            String number = B[i];
            if (number.contains(P)) {
                String addressee = A[i];
                if (candidate == null || addressee.compareTo(candidate) < 0) {
                    candidate = addressee;
                }
            }
        }
        return Optional
                .ofNullable(candidate)
                .orElse("NO CONTACT");
    }
}