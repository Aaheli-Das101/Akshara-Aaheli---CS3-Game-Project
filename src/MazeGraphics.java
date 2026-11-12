import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class MazeGraphics extends Canvas
{
	//these are instance variables
    private int rows;
    private int cols;
    private Tile[][] grid;
    private Random rand;
    private int[][] directions;

	
	public MazeGraphics()
	{
        rows=10;
        cols = 10;

        grid = new Tile[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Tile();
            }
        }
        rand = new Random();

        directions = new int[][]{
                {-1, 0, Tile.topWall, Tile.bottomWall}, //moving up
                {0, 1, Tile.rightWall, Tile.leftWall}, // moving right
                {1, 0, Tile.bottomWall, Tile.topWall}, // moving down
                {0, -1, Tile.leftWall, Tile.rightWall} //moving left
        };
	}

    public void generate() {
        dfs(0, 0);

        //makes a start and end area
        grid[0][0].removeWall(Tile.topWall);
        grid[rows - 1][cols - 1].removeWall(Tile.bottomWall);
    }

    public void dfs(int r, int c) {

        //check current tile and set it to visited to not go over it again
        Tile current = grid[r][c];
        current.visited = true;

        //morphing array into array list to use Collections.shuffle() method
        ArrayList<int[]> shuffledDirections =
                new ArrayList<>(Arrays.asList(directions));

        //shuffle the directions it is to travel in = random maze each time
        Collections.shuffle(shuffledDirections, rand);

        //go to different directions on each recursve call
        //this essentially lets us transform the matrix to be an actual mze (hypothtically)
        for (int[] d : shuffledDirections) {

            int nr = r + d[0];
            int nc = c + d[1];

            //check if in bounds and on a new spot before adjusting the walls
            if ((nr >= 0 && nr < rows && nc >= 0 && nc < cols) && !grid[nr][nc].visited) {
                current.removeWall(d[2]);
                grid[nr][nc].removeWall(d[3]);

                dfs(nr, nc);
            }
        }
    }

	//code to draw the Brick will go here
	public void paint( Graphics window )
	{
        for (int r = 0; r < rows; r++) {

            // Print top walls
            for (int c = 0; c < cols; c++) {

                if (grid[r][c].hasWall(Tile.topWall)) {
                    System.out.print("+---");
                }
                else {
                    System.out.print("+   ");
                }
            }

            System.out.println("+");

            // Print left and right walls
            for (int c = 0; c < cols; c++) {

                if (grid[r][c].hasWall(Tile.leftWall)) {
                    System.out.print("|");
                }
                else {
                    System.out.print(" ");
                }

                if (r == 0 && c == 0) {
                    System.out.print(" S ");
                }
                else if (r == rows - 1 && c == cols - 1) {
                    System.out.print(" E ");
                }
                else {
                    System.out.print("   ");
                }
            }
            // Print the rightmost wall
            if (grid[r][cols - 1].hasWall(Tile.rightWall)) {
                System.out.println("|");
            }
            else {
                System.out.println(" ");
            }
        }
        // Print the bottom walls
        for (int c = 0; c < cols; c++) {
            if (grid[rows - 1][c].hasWall(Tile.bottomWall)) {
                System.out.print("+---");
            }
            else {
                System.out.print("+   ");
            }
        }
        System.out.println("+");
	}
}