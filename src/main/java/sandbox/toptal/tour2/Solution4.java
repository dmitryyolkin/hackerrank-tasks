package sandbox.toptal.tour2;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


import java.util.*;

class Solution4 {
    // search whether there is a path between N-first nodes
    // in non-oriented graph
    // A - start edges
    // B - end edges
    public boolean solution(int N, int[] A, int[] B) {
        Map<Integer, Set<Integer>> node2LinkedNodes = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            node2LinkedNodes.computeIfAbsent(a,  v -> new HashSet<>()).add(b);
            node2LinkedNodes.computeIfAbsent(b,  v -> new HashSet<>()).add(a);
        }

        // there is a map of linked nodes
        for (int i = 1; i <= N; i++) {
            Set<Integer> linkedNodes = Optional
                    .ofNullable(node2LinkedNodes.get(i))
                    .orElse(Collections.emptySet());

            int searchable = i < N ? i + 1 : 1; // there is a cycle
            if (!linkedNodes.contains(searchable)) {
                return false;
            }
        }

        return true;
    }
}
