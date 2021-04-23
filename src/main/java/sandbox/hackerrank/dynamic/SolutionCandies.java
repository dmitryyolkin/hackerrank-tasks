package sandbox.hackerrank.dynamic;

public class SolutionCandies {

    // https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
    public long calculate(int n, int[] arr) {
        long candies = 0;

        long prevCandies = 1;
        int prevV = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int currV = arr[i];
            int nextV = arr[i + 1];
            if (currV < nextV) {
                if (i > 0) {
                    if (currV > prevV) {
                        prevCandies++;
                    } else if (currV < prevV) {
                        prevCandies--;
                    }
                }
            } else {
                if (currV > prevV) {
                    // curr > prev and curr > next
                    prevCandies++;

                    // predict how many candies should be bought
                    long buffer = prevCandies - 1;
                    int prevCandidateV = nextV;
                    for (int j = i + 2; j < Math.min(arr.length, i + currV); j++) {
                        int nextCandidateV = arr[j];
                        if (prevCandidateV > nextCandidateV) {
                            buffer--;
                            if (buffer < 1) {
                                prevCandies++;
                            }
                        } else if (prevCandidateV < nextCandidateV) {
                            break;
                        }
                        prevCandidateV = nextCandidateV;
                    }

                } else if (currV < prevV) {
                    // curr < prev and curr > next
                    prevCandies = 2;

                    // predict how many candies should be bought
                    int prevCandidateV = nextV;
                    for (int j = i + 2; j < Math.min(arr.length, i + currV); j++) {
                        int nextCandidateV = arr[j];
                        if (prevCandidateV > nextCandidateV) {
                            prevCandies++;
                        } else if (prevCandidateV < nextCandidateV) {
                            break;
                        }
                        prevCandidateV = nextCandidateV;
                    }

                }

            }

            candies += prevCandies;
            prevV = currV;
        }

        // add last element
        int lastV = arr[arr.length - 1];
        candies += (lastV > prevV ? prevCandies + 1 : 1);
        return candies;
    }

}
