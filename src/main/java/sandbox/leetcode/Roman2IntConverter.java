package sandbox.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Roman2IntConverter {
    private static final Map<String, Integer> STR_2_INT = new HashMap<>();
    static {
        STR_2_INT.put("I", 1);
        STR_2_INT.put("V", 5);
        STR_2_INT.put("X", 10);
        STR_2_INT.put("L", 50);
        STR_2_INT.put("C", 100);
        STR_2_INT.put("D", 500);
        STR_2_INT.put("M", 1000);
        STR_2_INT.put("IV", 4);
        STR_2_INT.put("IX", 9);
        STR_2_INT.put("XL", 40);
        STR_2_INT.put("XC", 90);
        STR_2_INT.put("CD", 400);
        STR_2_INT.put("CM", 900);
    }

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            for (int j = 2; j > 0; j--) {
                int endIndex = i + j;
                if (endIndex <= s.length()) {
                    String candidateStr = s.substring(i, endIndex);
                    Integer value = STR_2_INT.get(candidateStr);
                    if (value != null) {
                        result += value;
                        i += j;
                        break;
                    }
                }
            }
        }
        return result;
    }

}
