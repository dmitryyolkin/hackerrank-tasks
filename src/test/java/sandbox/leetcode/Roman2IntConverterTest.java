package sandbox.leetcode;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class Roman2IntConverterTest {

    @DataProvider
    public static Object[][] cases() {
        return new Object[][] {
                { "Test 1", "III", 3 },
                { "Test 2", "LVIII", 58 },
                { "Test 3", "MCMXCIV", 1994 }
        };
    }

    @Test
    @UseDataProvider("cases")
    public void testSolution(String description,
                             String input,
                             int result) {
        Roman2IntConverter solution = new Roman2IntConverter();
        assertEquals(
                description,
                result,
                solution.romanToInt(input)
        );
    }

}
