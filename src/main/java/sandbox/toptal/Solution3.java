package sandbox.toptal;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

class Solution3 {
    private static final List<String> MONTHS = Arrays.asList(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );

    private static final String MONDAY = "Monday";
    private static final String SUNDAY = "Sunday";


    public int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 8
        LocalDate startVacation = LocalDate.of(Y, MONTHS.indexOf(A) + 1, 1);
        LocalDate firstDayOfLastMonth = LocalDate.of(Y, MONTHS.indexOf(B) + 1, 1);
        // to get last day of the month 28 (29) / 30 / 31
        LocalDate endVacation = firstDayOfLastMonth.withDayOfMonth(firstDayOfLastMonth.lengthOfMonth());

        // search fist flight date
        LocalDate firstFlightDate = startVacation;
        for (int i = 0; i <= 7; i++) {
            LocalDate candidate = startVacation.plusDays(i);
            if (candidate.getDayOfWeek().name().equalsIgnoreCase(MONDAY)) {
                firstFlightDate = candidate;
                break;
            }
        }

        // search last flight date
        LocalDate lastFlightDate = endVacation;
        for (int i = 0; i <= 7; i++) {
            LocalDate candidate = endVacation.minusDays(i);
            if (candidate.getDayOfWeek().name().equalsIgnoreCase(SUNDAY)) {
                lastFlightDate = candidate;
                break;
            }
        }

        // add one day to lastFlightDate because last date is exclusive
        return (int) ChronoUnit.WEEKS.between(firstFlightDate, lastFlightDate.plusDays(1));
    }
}
