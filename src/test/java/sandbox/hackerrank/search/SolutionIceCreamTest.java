package sandbox.hackerrank.search;

import org.junit.Test;
import sandbox.SolutionTemplate;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionIceCreamTest {
    @Test
    public void testSolution() {
        SolutionIceCream solution = new SolutionIceCream();
        assertArrayEquals(
                new int[]{1, 4},
                solution.calculate(new int[]{1, 4, 5, 3, 2}, 4)
        );

        assertArrayEquals(
                new int[]{1, 2},
                solution.calculate(new int[]{2, 2, 4, 3}, 4)
        );

    }

}
