package sandbox.hackerrank.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionCrosswordPuzzleTest {
    @Test
    public void testSolution() {
        SolutionCrosswordPuzzle solution = new SolutionCrosswordPuzzle();

        assertArrayEquals(
                new String[]{
                        "+C++++++++",
                        "+A++T+++++",
                        "+NIGERIA++",
                        "+A++L+++++",
                        "+D++A+++++",
                        "+A++V+++++",
                        "++++I+++++",
                        "++++V+++++",
                        "++++++++++",
                        "CALIFORNIA"
                },
                solution.calculate(
                        new String[]{
                                "+-++++++++",
                                "+-++-+++++",
                                "+-------++",
                                "+-++-+++++",
                                "+-++-+++++",
                                "+-++-+++++",
                                "++++-+++++",
                                "++++-+++++",
                                "++++++++++",
                                "----------"
                        },
                        "CALIFORNIA;NIGERIA;CANADA;TELAVIV"
                )
        );

        assertArrayEquals(
                new String[]{
                        "+L++++++++",
                        "+O++++++++",
                        "+N++++++++",
                        "+DELHI++++",
                        "+O+++C++++",
                        "+N+++E++++",
                        "+++++L++++",
                        "++ANKARA++",
                        "+++++N++++",
                        "+++++D++++"
                },
                solution.calculate(
                        new String[]{
                                "+-++++++++",
                                "+-++++++++",
                                "+-++++++++",
                                "+-----++++",
                                "+-+++-++++",
                                "+-+++-++++",
                                "+++++-++++",
                                "++------++",
                                "+++++-++++",
                                "+++++-++++"
                        },
                        "LONDON;DELHI;ICELAND;ANKARA"
                )
        );

        assertArrayEquals(
                new String[]{
                        "+E++++++++",
                        "+N++++++++",
                        "+GWALIOR++",
                        "+L++++++++",
                        "+A++++++++",
                        "+NORWAY+++",
                        "+D+++G++++",
                        "+++++R++++",
                        "+++++A++++",
                        "++++++++++"
                },
                solution.calculate(
                        new String[]{
                                "+-++++++++",
                                "+-++++++++",
                                "+-------++",
                                "+-++++++++",
                                "+-++++++++",
                                "+------+++",
                                "+-+++-++++",
                                "+++++-++++",
                                "+++++-++++",
                                "++++++++++"
                        },
                        "AGRA;NORWAY;ENGLAND;GWALIOR"
                )
        );

        assertArrayEquals(
                new String[]{
                        "++++++I+++",
                        "++MEXICO++",
                        "++++++E+++",
                        "++++++L+++",
                        "+++PANAMA+",
                        "++++++N+L+",
                        "++++++D+M+",
                        "++++++++A+",
                        "++++++++T+",
                        "++++++++Y+"
                },
                solution.calculate(
                        new String[]{
                                "++++++-+++",
                                "++------++",
                                "++++++-+++",
                                "++++++-+++",
                                "+++------+",
                                "++++++-+-+",
                                "++++++-+-+",
                                "++++++++-+",
                                "++++++++-+",
                                "++++++++-+"
                        },
                        "ICELAND;MEXICO;PANAMA;ALMATY"
                )
        );
    }

}
