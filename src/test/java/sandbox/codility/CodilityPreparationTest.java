package sandbox.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodilityPreparationTest {

    @Test
    public void testSolution() {
        CodilityPreparation solution = new CodilityPreparation();
        assertEquals(
                5,
                solution.solution(new int[]{1, 3, 6, 4, 1, 2})
        );

        assertEquals(
                4,
                solution.solution(new int[]{1, 2, 3})
        );

        assertEquals(
                1,
                solution.solution(new int[]{ -1, -3 })
        );

    }
}
