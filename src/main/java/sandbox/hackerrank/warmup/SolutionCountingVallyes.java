package sandbox.hackerrank.warmup;

public class SolutionCountingVallyes {
    private static final char UP = 'U';
    private static final char DOWN = 'D';

    // https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

    // An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
    //
    //A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
    //A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
    //Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
    //
    //Example
    // [DDUUUUDD]
    // The hiker first enters a valley  units deep. Then they climb out and up onto a mountain  units high.
    // Finally, the hiker returns to sea level and ends the hike.
    public int calculate(int steps, String path) {
        int level = 0;
        int valleysSum = 0;
        for (int i = 0; i < path.length(); i++) {
            char currentChar = path.charAt(i);
            level += (currentChar == UP ? 1 : -1);
            if (level == -1 && currentChar == DOWN) {
                valleysSum++;
            }
        }
        return valleysSum;
    }

}
