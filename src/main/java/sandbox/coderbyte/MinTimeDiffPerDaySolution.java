package sandbox.coderbyte;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.format.DateTimeFormatterBuilder;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.time.LocalTime;

class MinTimeDiffPerDaySolution {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("h:mma")
            .toFormatter(Locale.US);

    public static String calculate(String[] strArr) {
        // code goes here
        List<LocalTime> times = Stream
                .of(strArr)
                .map(time -> LocalTime.parse(time, DATE_TIME_FORMATTER))
                .sorted() // sort by time
                .collect(Collectors.toList());

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < times.size(); i++) {
            if (i < times.size() - 1) {
                LocalTime currTime = times.get(i);
                LocalTime nextTime =  times.get(i + 1);
                int currMinutes = currTime.toSecondOfDay() / 60;
                int nextMinutes = nextTime.toSecondOfDay() / 60;

                int diffCandidate = nextMinutes - currMinutes;
                if (diffCandidate < diff) {
                    diff = diffCandidate;
                }
            }
            else {
                // compare 1st element in day with last
                LocalTime currTime = times.get(i);
                LocalTime nextTime =  times.get(0);
                int currMinutes = currTime.toSecondOfDay() / 60;
                int nextMinutes = nextTime.toSecondOfDay() / 60;
                int maxMinutesInDay = 24 * 60;

                int diffCandidate = (maxMinutesInDay - currMinutes) + nextMinutes;
                if (diffCandidate < diff) {
                    diff = diffCandidate;
                }

            }

        }
        return String.valueOf(diff);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(calculate(new String[] {"1:10pm", "4:40am", "5:00pm"}));
    }

}