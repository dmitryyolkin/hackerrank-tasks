package sandbox.hackerrank;

public class SolutionStringSeparation {

    // How many ways to seperate a string "abaccadd" in to 3 strings
    // so that each of them contain same amount of "a"s
    public int calculate(String s) {
        // abaccadd

        // a ba ccadd
        // a bac cadd
        // a bacc add

        // ab a ccadd
        // ab aс cadd
        // ab acc add

        int count = 1;
        int currAIndex = s.indexOf("a");
        while (currAIndex > -1) {
            int nextAIndex = s.indexOf("a", currAIndex + 1);
            if (nextAIndex > -1) {
                count *= (nextAIndex - currAIndex);
            }
            currAIndex = nextAIndex;
        }
        return count;
    }

    // число сочетаний k элементов из n штук
    // Неупорядоченные выборки называются сочетаниями из n элементов по m и обозначаются Сnm
    private int combinations(int k, int n) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    // число размещений m элементов по n группам
    // Размещениями из n элементов по m (мест) называются такие выборки, которые имея по m элементов, выбранных из числа данных n элементов,
    // отличаются одна от другой либо составом элементов, либо порядком их расположения.
    private int positions(int m, int n) {
        return factorial(n) / factorial(n - m);
    }

    // Перестановками называются такие выборки элементов, которые отличаются только порядком расположения элементов,
    // но не самими элементами.
    //
    //Если перестановки производятся на множестве из n элементов, их число определяется по формуле
    //Pn = n·(n−1)·(n−2)...3·2·1 = n!
    private int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

}
