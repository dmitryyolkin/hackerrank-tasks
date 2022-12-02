package sandbox;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class SolutionTemplateTest {

    @DataProvider
    public static Object[][] cases() {
        return new Object[][] {
                { "Test 1" },
        };
    }

    @Test
    @UseDataProvider("cases")
    public void testSolution(String description) {
        SolutionTemplate solution = new SolutionTemplate();
        assertEquals(
                description,
                0,
                solution.calculate()
        );
    }

}
