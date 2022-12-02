package sandbox.leetcode;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class ValidatePalindromeTest {

    @DataProvider
    public static Object[][] cases() {
        return new Object[][] {
                { "Test 1", "race a car", false },
                { "Test 2", " ", true },
                { "Test 3", "A man, a plan, a canal: Panama", true }
        };
    }

    @Test
    @UseDataProvider("cases")
    public void testSolution(String description,
                             String input,
                             boolean expectedResult) {
        ValidatePalindrome solution = new ValidatePalindrome();
        assertEquals(
                description,
                expectedResult,
                solution.isPalindrome(input)
        );
    }

}
