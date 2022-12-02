package sandbox.leetcode;

public class ValidatePalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder revert = new StringBuilder();
        String trimmedStr = s
                .toUpperCase()
                .replaceAll("[^a-zA-Z0-9]+", "");
        for (int i = trimmedStr.length() - 1; i >= 0; i--) {
            revert.append(trimmedStr.charAt(i));
        }
        String result = revert.toString();
        return result.isEmpty() || result.equals(trimmedStr);
    }

}
