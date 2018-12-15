/**
 * Created by ianbulmer on 12/15/18.
 */
public class Main {
    public static void main(String[] args) {
        //"X" squares are land. "O" squares are water
        //island is made up of vertically and horizontally adjacent land squares.
        // Below there are 7 land squares and 18 water squares

        /**
        OOOOO
        OXOXX
        OOOOX
        OXOXO
        XOOOO
         **/

        //above you can see 5 islands. Below you can see the same island numbered.

        /**
        OOOOO
        O1O22
        OOOO2
        O3O4O
        5OOOO
         **/

        // The program can set the odds of an individual square being land.
        // Here the odds of any one square being an island is 30%.
        IslandMaker islandMaker = new IslandMaker(5, 5, 30);
        islandMaker.printGrid();
        System.out.println("There are " + islandMaker.countIslands() + " islands");

        System.out.println("\n");

        double[] islandAverages = new double[100];

        //Below we will calculate how changing the odds of a square being an land affects how many islands are created
        // odds from 1 to 100
        for (int round = 1; round <= 100; round++) {
            // the odds of an individual square being land is equal to the round. The first round,
                //the odds are 1%. The last round, the odds are 100%;
            int odds = round;
            int rows = 100;
            int cols = 100;
            islandMaker = new IslandMaker(rows, cols, odds);

            // run 1000 trials and count how many islands were created with various odds.
            int trials = 1000;
            int sum = 0;
            for (int trial = 0; trial < trials; trial++) {
                int islands = islandMaker.countIslands();
                sum += islands;
            }
            double averageIslands = sum / (double)(trials);
            islandAverages[round - 1] = averageIslands;
            System.out.println(averageIslands + " average islands in a " + rows + " x " + cols + " grid if the odds of a square being land is " + odds + " percent.");
        }

        // find which round had on average the most number of islands
        int maxOdds = Helpers.getMaxIndex(islandAverages) + 1;
        System.out.println("The most number of islands were created when the odds of a square being land was " + maxOdds + " percent.");

    }
}
