package sandbox.hackerrank.string;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionAlternatingCharactersTest {
    @Test
    public void testSolution() {
        SolutionAlternatingCharacters solution = new SolutionAlternatingCharacters();
        assertEquals(
                3,
                solution.calculate("AAAA")
        );

        assertEquals(
                4,
                solution.calculate("BBBBB")
        );

        assertEquals(
                0,
                solution.calculate("ABABABAB")
        );

        assertEquals(
                0,
                solution.calculate("BABABA")
        );

        assertEquals(
                4,
                solution.calculate("AAABBB")
        );

    }

}
