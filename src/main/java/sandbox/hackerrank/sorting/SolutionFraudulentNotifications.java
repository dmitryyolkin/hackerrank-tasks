package sandbox.hackerrank.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionFraudulentNotifications {

    // https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
    // Example
    // 2, 3, 4, 2, 3, 6, 8, 4, 5
    // 5
    public int calculate(int[] expenditure, int d) {
        if (expenditure.length <= d) {
            return 0;
        }

        int prev = -1;
        LinkedList<Integer> learningArr = IntStream
                .of(Arrays.copyOf(expenditure, d))
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        int notifications = 0;
        for (int i = d; i < expenditure.length; i++) {
            int curr = expenditure[i];
            if (prev >= 0) {
                // 2nd iteration and later
                learningArr.remove((Integer) expenditure[i - d - 1]);

                boolean wasAdded = false;
                for (int j = 0; j < learningArr.size(); j++) {
                    if (learningArr.get(j) >= prev) {
                        learningArr.add(j, prev);
                        wasAdded = true;
                        break;
                    }
                }

                if (!wasAdded) {
                    learningArr.add(prev);
                }
            }

            double median;
            if (d % 2 == 0) {
                // it's even
                median = (learningArr.get(d / 2 - 1) + learningArr.get(d / 2)) / 2.;
            } else {
                // it's odd
                median = learningArr.get(d / 2);
            }

            if (curr >= median * 2) {
                notifications++;
            }
            prev = curr;
        }
        return notifications;
    }

}
