package sandbox.hackerrank.hashmaps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionRansomNoteTest {
    @Test
    public void testSolution() {
        SolutionRansomNote solution = new SolutionRansomNote();
        assertEquals(
                "Yes",
                solution.calculate(
                        new String[]{"give", "me", "one", "grand", "today", "night"},
                        new String[]{"give", "one", "grand", "today"}
                )
        );

        assertEquals(
                "No",
                solution.calculate(
                        new String[]{"two", "times", "three", "is", "not", "four"},
                        new String[]{"two", "times", "two", "is", "four"}
                )
        );

    }

}
