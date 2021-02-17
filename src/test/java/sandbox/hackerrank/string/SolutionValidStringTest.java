package sandbox.hackerrank.string;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SolutionValidStringTest {
    @Test
    public void testSolution() throws URISyntaxException, IOException {
        SolutionValidString solution = new SolutionValidString();
        assertEquals(
                "YES",
                solution.calculate("abc")
        );

        assertEquals(
                "YES",
                solution.calculate("abcc")
        );

        assertEquals(
                "NO",
                solution.calculate("aabbcd")
        );

        assertEquals(
                "NO",
                solution.calculate("aabbccddeefghi")
        );

        assertEquals(
                "YES",
                solution.calculate("abcdefghhgfedecba")
        );

        assertEquals(
                "YES",
                solution.calculate("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd")
        );


        URL resource = ClassLoader.getSystemClassLoader().getResource("validString-1.txt");
        assertNotNull(resource);
        StringBuilder builder = new StringBuilder();
        Files
                .lines(Paths.get(resource.toURI()))
                .forEach(builder::append);
        assertEquals(
                "YES",
                solution.calculate(builder.toString())
        );


    }

}
