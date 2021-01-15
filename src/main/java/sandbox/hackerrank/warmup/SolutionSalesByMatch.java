package sandbox.hackerrank.warmup;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SolutionSalesByMatch {

    // Alex works at a clothing store. There is a large pile of socks that must be paired by color for sale.
    // Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
    //
    //For example, there are  socks with colors 1, 2, 1, 2, 1, 3, 2.
    // There is one pair of color  and one of color .
    // There are three odd socks left, one of each color. The number of pairs is .
    public int calculate(int socksNumber, int[] colors) {
        return Arrays
                .stream(colors)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.toList()))
                .values()
                .stream()
                .mapToInt(integers -> integers.size() / 2)
                .sum();
    }

}
