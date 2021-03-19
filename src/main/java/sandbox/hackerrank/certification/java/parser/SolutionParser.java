package sandbox.hackerrank.certification.java.parser;

import java.util.*;

public class SolutionParser {

    public boolean isBalanced(String candidate) {
        if (candidate.isEmpty()) {
            return true;
        }

        if (candidate.length() % 2 != 0) {
            // there is only half of symbols
            return false;
        }

        Map<Character, List<Integer>> char2Indexes = new HashMap<>();
        for (int i = 0; i < candidate.length(); i++) {
            char symbol = candidate.charAt(i);
            char2Indexes
                    .computeIfAbsent(symbol, v -> new ArrayList<>())
                    .add(i);
        }

        List<Integer> startBrackets = Optional.ofNullable(char2Indexes.get('(')).orElse(Collections.emptyList());
        List<Integer> endBrackets = Optional.ofNullable(char2Indexes.get(')')).orElse(Collections.emptyList());

        List<Integer> startSquareBrackets = Optional.ofNullable(char2Indexes.get('{')).orElse(Collections.emptyList());
        List<Integer> endSquareBrackets = Optional.ofNullable(char2Indexes.get('}')).orElse(Collections.emptyList());

        if (startBrackets.size() != endBrackets.size() ||
                startSquareBrackets.size() != endSquareBrackets.size()) {
            // number of brackets are different 
            return false;
        }

        int middleIndex = candidate.length() / 2;
        return (check(middleIndex, startBrackets, endBrackets) &&
                check(middleIndex, startSquareBrackets, endSquareBrackets));
    }

    private boolean check(int middleIndex,
                          List<Integer> startBrackets,
                          List<Integer> endBrackets) {

        for (int i = 0; i < startBrackets.size(); i++) {
            Integer startIndex = startBrackets.get(i);
            boolean sequential = endBrackets.contains(startIndex + 1);
            if (!sequential) {
                // symbols are not sequential
                // check symmetry
                if (startIndex < middleIndex - 1) {
                    Integer endLastIndex = endBrackets.get(startBrackets.size() - i - 1);
                    if (middleIndex - 1 - startIndex != endLastIndex - middleIndex) {
                        // are not symmetric
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
