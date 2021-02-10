package sandbox.hackerrank.sorting;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionFraudulentNotificationsTest {
    @Test
    public void testSolution() {
        SolutionFraudulentNotifications solution = new SolutionFraudulentNotifications();
//        assertEquals(
//                1,
//                solution.calculate(new int[]{10, 20, 30, 40, 50}, 3)
//        );

        assertEquals(
                2,
                solution.calculate(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5)
        );

        assertEquals(
                0,
                solution.calculate(new int[]{1, 2, 3, 4, 4}, 4)
        );

    }

}
