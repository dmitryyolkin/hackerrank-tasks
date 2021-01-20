package sandbox.hackerrank.arrays;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SolutionLeftRotationTest {
    @Test
    public void testSolution() {
        SolutionLeftRotation solution = new SolutionLeftRotation();
        assertEquals(
                array2List(5, 1, 2, 3, 4),
                array2List(solution.calculate(new int[]{1, 2, 3, 4, 5}, 4))
        );
    }

    private List<Integer> array2List(int... array) {
        return IntStream.of(array).boxed().collect(Collectors.toList());
    }

}
