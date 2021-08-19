package sandbox.hackerrank.miscellaneous;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaxFriendshipCircleTest {
    @Test
    public void testSolution() {
        MaxFriendshipCircle solution = new MaxFriendshipCircle();
        assertArrayEquals(
                new int[]{
                        2, 3
                },
                solution.calculate(
                        new int[][]{
                                {1, 2},
                                {1, 3}
                        }
                )
        );

        assertArrayEquals(
                new int[]{
                        2, 2, 2, 4
                },
                solution.calculate(
                        new int[][]{
                                {1000000000, 23},
                                {11, 3778},
                                {7, 47},
                                {11, 1000000000}
                        }
                )
        );

        assertArrayEquals(
                new int[]{
                        2, 2, 4, 4, 4, 7
                },
                solution.calculate(
                        new int[][]{
                                {1, 2},
                                {3, 4},
                                {1, 3},
                                {5, 7},
                                {5, 6},
                                {7, 4}
                        }
                )
        );

    }

}
