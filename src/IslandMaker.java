import java.util.concurrent.ThreadLocalRandom;

// class creates a grid consisting of squares that are either land ("X"), or water ("O")
// an island is made up land squares connected either vertically or horizontally (not diagonally)
public class IslandMaker {
    private String[][] grid;
    private int rows;
    private int cols;
    private int odds;

    public IslandMaker(int rows, int cols, int odds) {
        this.rows = rows;
        this.cols = cols;
        this.odds = odds;
        this.grid = createGrid();
    }

    // creates a row x col grid of land and water
    private String[][] createGrid() {
        String grid[][] = new String[rows][cols];
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                grid[row][col] = this.generateRandomInt(1, 100) <= odds ? "X" : "O";
            }
        }
        return grid;
    }

    //generates a random number, used to determine whether a square is land or water
    private int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // prints out the grid
    public void printGrid() {
        for (int row = 0; row < grid.length; row++) {
            String[] line = this.grid[row];
            for (int j = 0; j < line.length; j++) {
                System.out.print(line[j]);
            }
            System.out.print("\n");
        }
    }

    // method for counting the number of island
    public int countIslands() {
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //if square is unvisited land increment count and visit all squares part of this island
                if (this.grid[row][col] == "X") {
                    count += 1;
                    travelIsland(row, col);
                }
            }
        }
        //make a new grid
        this.grid = createGrid();
        return count;
    }

    //recursively check surrounding tiles
    private void travelIsland(int row, int col) {
        // if element is off the grid, return
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        // if square is not unvisted land return
        if (this.grid[row][col] != "X") {
            return;
        }
        // mark the current square as visited
        this.grid[row][col] = "#";
        // check all adjacent elements
        travelIsland(row - 1, col);
        travelIsland(row + 1, col);
        travelIsland(row, col - 1);
        travelIsland(row, col + 1);
    }
}
