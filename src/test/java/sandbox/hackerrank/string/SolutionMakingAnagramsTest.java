package sandbox.hackerrank.string;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionMakingAnagramsTest {
    @Test
    public void testSolution() {
        SolutionMakingAnagrams solution = new SolutionMakingAnagrams();
        assertEquals(
                4,
                solution.calculate("cde", "abc")
        );
    }

}
