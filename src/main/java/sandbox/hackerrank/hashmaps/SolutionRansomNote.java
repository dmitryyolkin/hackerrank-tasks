package sandbox.hackerrank.hashmaps;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionRansomNote {

    private static final String YES = "Yes";
    private static final String NO = "No";

    // https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    public String calculate(String[] magazine, String[] note) {
        Map<String, Integer> magazineWord2Count = Stream
                .of(magazine)
                .collect(Collectors.groupingBy(v -> v, Collectors.toList()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));

        for (String word : note) {
            Integer count = magazineWord2Count.get(word);
            if (count == null || count == 0) {
                // no required word
                System.out.println(NO);
                return NO;
            } else {
                magazineWord2Count.put(word, --count);
            }
        }

        System.out.println(YES);
        return YES;
    }

}
