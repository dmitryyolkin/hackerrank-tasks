package sandbox.hackerrank.hashmaps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionSherlockAndAnagramsTest {
    @Test
    public void testSolution() {
        SolutionSherlockAndAnagrams solution = new SolutionSherlockAndAnagrams();
        assertEquals(
                4,
                solution.calculate("abba")
        );

        assertEquals(
                0,
                solution.calculate("abcd")
        );

        assertEquals(
                3,
                solution.calculate("ifailuhkqq")
        );

        assertEquals(
                10,
                solution.calculate("kkkk")
        );

    }

}
