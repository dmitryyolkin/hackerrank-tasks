package sandbox.hackerrank.miscellaneous;

import java.util.Arrays;

public class SolutionMaximumXor {

    // https://www.hackerrank.com/challenges/maximum-xor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
    // current solution works not so fast
    // ideally it can be solved
    //      via Trie -> https://en.wikipedia.org/wiki/Trie
    //      here Python example -> https://programs.programmingoneonone.com/2021/03/hackerrank-maximum-xor-solution.html
    public int[] calculate(int[] arr, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            result[i] = Arrays
                    .stream(arr)
                    .map(v -> query ^ v)
                    .max()
                    .orElseThrow(IllegalArgumentException::new);
        }
        return result;
    }

}
