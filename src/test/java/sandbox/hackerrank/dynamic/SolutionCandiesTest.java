package sandbox.hackerrank.dynamic;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SolutionCandiesTest {
    @Test
    public void testSolution() throws URISyntaxException, IOException {
        SolutionCandies solution = new SolutionCandies();
        assertEquals(
                4,
                solution.calculate(3, new int[]{1, 2, 2})
        );

//        assertEquals(
//                18,
//                solution.calculate(3, new int[]{5, 5, 3, 3, 3, 3, 1, 2, 6, 6})
//        );

        assertEquals(
                29,
                solution.calculate(13, new int[]{
                        2,
                        4,
                        2,
                        6,
                        1,
                        7,
                        8,
                        9,
                        8,
                        7,
                        6,
                        5,
                        10
                })
        );

        assertEquals(
                19,
                solution.calculate(10, new int[]{
                        2,
                        4,
                        2,
                        6,
                        1,
                        7,
                        8,
                        9,
                        2,
                        1
                })
        );

        assertEquals(
                12,
                solution.calculate(8, new int[]{
                        2,
                        4,
                        3,
                        5,
                        2,
                        6,
                        4,
                        5
                })
        );

        Map<String, Map.Entry<Integer, Integer>> scenarios = ImmutableMap
                .<String, Map.Entry<Integer, Integer>>builder()
                .put("candles-1.txt", new AbstractMap.SimpleEntry<>(16387, 33556))
//                .put("candles-2.txt", new AbstractMap.SimpleEntry<>(100000, 160929))
                .build();

        for (Map.Entry<String, Map.Entry<Integer, Integer>> scenarioEntry : scenarios.entrySet()) {
            Map.Entry<Integer, Integer> scenarioValue = scenarioEntry.getValue();
            URL resource = ClassLoader.getSystemClassLoader().getResource(scenarioEntry.getKey());
            assertNotNull(resource);
            List<Integer> values = new ArrayList<>();
            Files
                    .lines(Paths.get(resource.toURI()))
                    .forEach(l -> values.add(Integer.parseInt(l)));


            assertEquals(
                    scenarioValue.getValue().longValue(),
                    solution.calculate(scenarioValue.getKey(), values.stream().mapToInt(i->i).toArray())
            );
        }

    }

}
