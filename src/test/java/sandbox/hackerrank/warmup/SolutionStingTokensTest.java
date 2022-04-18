package sandbox.hackerrank.warmup;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionStingTokensTest {
    @Test
    public void testSolution() {
        SolutionStringTokens solution = new SolutionStringTokens();
        assertArrayEquals(
                new String[]{
                        "He",
                        "is",
                        "a",
                        "very",
                        "very",
                        "good",
                        "boy",
                        "isn",
                        "t",
                        "he"
                },
                solution.calculate("He is a very very good boy, isn't he?")
        );
    }

}
