package sandbox.toptal.tour3;

public class SolutionTour3_1 {

    /**
     * Task Description
     * A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1. Your task is to write a program that will be used in a vending machine to return change. Assume that the vending machine will always want to return the least number of coins or notes. Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected, that returns an array of integers representing the number of each denomination to return.
     *
     * Example:
     * getChange(5, 0.99) // should return [1,0,0,0,0,4]
     *
     * getChange(3.14, 1.99) // should return [0,1,1,0,0,1]
     * getChange(3, 0.01) // should return [4,0,2,1,1,2]
     * getChange(4, 3.14) // should return [1,0,1,1,1,0]
     * getChange(0.45, 0.34) // should return [1,0,1,0,0,0]
     */
    public int[] calculate(double cash, double price) {
        int[] result = new int[6];
        double change = (cash - price) * 100. + 0.0000001 ;

        result[5] = (int) (change / 100.0); // dollars
        double tips = change % 100.0;
        if (tips > 50) {
            result[4] = 1; // 50
            tips -= 50;
        }

        if (tips > 25) {
            result[3] = 1; //25
            tips -= 25;
        }

        if (tips > 10) {
            int tenCount = (int) tips / 10;
            result[2] = tenCount; //10
            tips -= (tenCount * 10);
        }

        if (tips > 5) {
            int fiveCount = (int) tips / 5;
            result[1] = fiveCount; //10
            tips -= (fiveCount * 5);

        }

        result[0] = (int) tips; //1
        for (int i = 0; i < result.length; i++) {
            int value = result[i];
            System.out.print(value + ",");
        }
        System.out.println("End");
        return result;
    }

}
