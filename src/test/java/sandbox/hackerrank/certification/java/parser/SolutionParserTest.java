package sandbox.hackerrank.certification.java.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionParserTest {
    @Test
    public void testSolution() {
        SolutionParser solution = new SolutionParser();

        assertTrue(
                solution.isBalanced("({()})")
        );

        assertTrue(
                solution.isBalanced("{}{}")
        );

        assertTrue(
                solution.isBalanced("{}()")
        );

        assertTrue(
                solution.isBalanced("{()}")
        );

        assertTrue(
                solution.isBalanced("({}{})")
        );

        assertFalse(
                solution.isBalanced("{}(")
        );

        assertFalse(
                solution.isBalanced("({)}")
        );

        assertFalse(
                solution.isBalanced("((")
        );

        assertFalse(
                solution.isBalanced("}{")
        );

        assertTrue(
                solution.isBalanced("((({}{}(){})))")
        );

    }

}
