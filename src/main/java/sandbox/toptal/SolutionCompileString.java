package sandbox.toptal;

import java.util.ArrayList;
import java.util.List;

public class SolutionCompileString {

    // Task Description
    // A precedence rule is given as "P>E", which means that letter "P" is followed directly by the letter "E".
    // Write a function, given an array of precedence rules, that finds the word represented by the given rules.
    // Note: Each represented word contains a set of unique characters,
    // i.e. the word does not contain duplicate letters.

    //Examples:
    //findWord(["P>E","E>R","R>U"]) // PERU
    //findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
    public String calculate(String[] array) {

        List<String> result = new ArrayList<>();
        for (String s : array) {
            String[] parts = s.split(">");

            String left = parts[0];
            String right = parts[1];
            int leftIndex = result.indexOf(left);
            int rightIndex = result.indexOf(right);
            if (leftIndex < 0) {
                if (rightIndex < 0) {
                    // add to the end
                    result.add(left);
                } else {
                    result.add(rightIndex, left);
                }
            }

            if (rightIndex < 0) {
                result.add(right);
            }
        }
        return String.join("", result);
    }

}
