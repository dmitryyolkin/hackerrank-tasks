package sandbox.hackerrank.miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxFriendshipCircle {

    // https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous

    // solution below can have some performance issues
    // it's recommended to use something like Disjoint Set Union (Union Find)
    // Examples:
    //      https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
    //      https://www.hackerrank.com/challenges/friend-circle-queries/forum?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
    public int[] calculate(int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Set<Integer>> friends = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a = query[0];
            int b = query[1];

            Set<Integer> aFriends = friends.computeIfAbsent(a, v -> new HashSet<>());
            Set<Integer> bFriends = friends.computeIfAbsent(b, v -> new HashSet<>());

            aFriends.add(b);
            bFriends.add(a);

            // find common friends
            Set<Integer> commonFriends = new HashSet<>();
            commonFriends.addAll(aFriends);
            commonFriends.addAll(bFriends);

            boolean canContinue;
            do {
                canContinue = false;
                Set<Integer> temp = new HashSet<>(commonFriends);
                for (Integer commonFriend : commonFriends) {
                    Set<Integer> neighbours = friends.get(commonFriend);
                    if (neighbours != null) {
                        canContinue |= temp.addAll(neighbours);
                    }
                }

                commonFriends.addAll(temp);
            } while (canContinue);

            int maxQueue = i == 0 ? commonFriends.size() : Math.max(result[i - 1], commonFriends.size());
            result[i] = maxQueue;

        }
        return result;
    }

}
