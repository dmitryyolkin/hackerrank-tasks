package sandbox.toptal.tour3;

import java.util.ArrayList;
import java.util.List;

public class SolutionTour3_2 {

    public int calculate(String str) {
        String[] letters = str.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            if (letter.equals("*")) {
                int multiply = 1;
                // take last 2 symbols
                for (int j = numbers.size() - 1; j > numbers.size() - 3; j--) {
                    multiply *= numbers.get(j);
                }
                numbers = updateNumbers(numbers, multiply);

            } else if (letter.equals("+")) {
                int sum = 0;
                // take last 2 symbols
                for (int j = numbers.size() - 1; j > numbers.size() - 3; j--) {
                    sum += numbers.get(j);
                }
                numbers = updateNumbers(numbers, sum);

            } else {
                // number
                numbers.add(Integer.parseInt(letter));
            }
        }
        Integer result = numbers.get(0);
        System.out.println("Result = " + result);
        return result;
    }

    private List<Integer> updateNumbers(List<Integer> numbers, int sum) {
        // remove 2 old and add new one
        List<Integer> list = numbers.subList(0, numbers.size() - 2);
        list.add(sum);
        return list;
    }

}
