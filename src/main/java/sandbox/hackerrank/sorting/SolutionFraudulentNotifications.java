package sandbox.hackerrank.sorting;

public class SolutionFraudulentNotifications {

    // https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
    // Example
    // expenditure: 2, 3, 4, 2, 3, 6, 8, 4, 5
    // d: 5
    // Result: 2
    public int calculate(int[] expenditure, int d) {
        // We use counting sort here https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D0%BE%D0%B4%D1%81%D1%87%D1%91%D1%82%D0%BE%D0%BC
        // because expenditure values are changed in smaller range (0..200) in comparison with expenditure array length
        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            // in data[expenditure[i]] we keep number of occurences of a specific expenditure
            data[expenditure[i]]++;
        }

        int notifications = 0;
        for (int i = d; i < expenditure.length; i++) {
            double median = median(d, data);
            if (expenditure[i] >= 2 * median) {
                notifications++;
            }

            // modify data because we are iterating through array
            data[expenditure[i]]++;
            data[expenditure[i - d]]--;
        }
        return notifications;
    }

    private static double median(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            // even
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= d/2) {
                    m1 = j;
                }
                if (count >= d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            // odd
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

}
