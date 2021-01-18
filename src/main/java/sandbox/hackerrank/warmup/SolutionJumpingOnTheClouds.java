package sandbox.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionJumpingOnTheClouds {

    // There is a new mobile game that starts with consecutively numbered clouds.
    // Some of the clouds are thunderheads and others are cumulus.
    // The player can jump on any cumulus cloud having a number
    // that is equal to the number of the current cloud plus  or .
    // The player must avoid the thunderheads.
    // Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud.
    // It is always possible to win the game.
    //
    //For each game, you will get an array of clouds numbered  if they are safe or  if they must be avoided.

    // Example:
    // values:  0, 0, 0, 0, 1, 0
    // indexes: 0, 1, 2, 3, 4, 5
    // 3
    public int calculate(int[] c) {
        if (c.length == 0) {
            return 0;
        }

        List<Integer> all = IntStream.of(c).boxed().collect(Collectors.toList());
        List<Integer> bestOption = calculate(
                // start from 1st vertex
                new ArrayList<>(all.subList(0, 1)),
                all
        );

        // calculate jumps
        return bestOption.size() - 1;
    }

    private List<Integer> calculate(List<Integer> options, List<Integer> all) {
        int lastIndex = options.stream().max(Integer::compareTo).orElse(-1);
        if (lastIndex == all.size() - 1) {
            // went through all vertexes
            return options;
        }

        List<Integer> bestOption = null;
        for (int i = 1; i <= 2; i++) {
            // we can jum on 1 or 2 steps only
            int candidate = lastIndex + i;
            if (candidate < all.size() && all.get(candidate) == 0) {
                List<Integer> candidateOption = new ArrayList<>(options);
                candidateOption.add(candidate);

                candidateOption = calculate(candidateOption, all);
                if (!candidateOption.isEmpty()
                        && (bestOption == null || candidateOption.size() < bestOption.size())) {

                    bestOption = candidateOption;
                }
            }
        }
        return Optional
                .ofNullable(bestOption)
                .orElse(Collections.emptyList());
    }

}
