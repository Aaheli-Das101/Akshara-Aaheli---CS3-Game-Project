import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class MazeGraphics extends Canvas
{
	//these are instance variables
    private int rows; //size of the maze
    private int cols; //size of the maze
    private Tile[][] grid; //maze tiles (paths, open spaces, and walls)
    private Random rand; //randomizer seed - more stable and predictable like using a seed in Cdf
    private int[][] directions; //randomize directions to go
    private int startX; //where tiles would start (set to 100)
    private int startY; //where tiles would start (set to 100)
    private int size; //how large the tile will be

	
	public MazeGraphics()
	{
        //change however needed. Adding rows = affect vertical span, adding cols = affect horizontal span
        rows= 50;
        cols = 90;

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

        startX = 100;
        startY = 100;
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
        generate();
        //get size of the tile we have to work with
        int avilableWidth = (getWidth() - 2 * startX);
        int avilableHeight = (getHeight() - 2 * startY);
        size = Math.min(avilableWidth / (cols), avilableHeight / (rows)); //space available even with margin

        //background
        window.setColor(Color.black);
        window.fillRect(0, 0, getWidth(), getHeight());

        //walls
        window.setColor(Color.white);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = startX + c * size; //moving left and right and ensuring that it actually moves
                int y = startY + r * size; //moving up and down
                int tileSize = 4;


                //if beginning at index 0 (top and left) no size added. right + bottom have size added to access the very bottom lien
                //wall is 4 pixels wide (hence the 4 in size and height)
                //the 2 comes from moving it around to be directly in the middle of that grid line (half above and half below)
                //size + 4 = 2px before cell + size cell + 2 px after cell
                //adjusted what gets moved around the most as per the wall locations
                if (grid[r][c].hasWall(Tile.topWall)) {
                    window.fillRect(x - tileSize / 2, y - tileSize / 2, size + tileSize,  tileSize);
                }

                if (grid[r][c].hasWall(Tile.bottomWall)) {
                    window.fillRect(x - tileSize / 2, y + size - tileSize / 2, size + tileSize, tileSize / 2);
                }

                if (grid[r][c].hasWall(Tile.rightWall)) {
                    window.fillRect(x + size - tileSize, y - tileSize, tileSize, size + tileSize);
                }
                if (grid[r][c].hasWall(Tile.leftWall)) {
                    window.fillRect(x - tileSize / 2, y - tileSize / 2, tileSize, size + tileSize);
                }

            }
        }
        //TEMPORARY - mark start
        window.setColor(Color.green);
        window.setFont(new Font("Comic Sans", Font.BOLD, 20));
        window.drawString("S", startX + size/2 -6, startY+size/2);

        window.setColor(Color.red);
        window.setFont(new Font("Comic Sans", Font.BOLD, 20));
        window.drawString("E", (startX + (cols -1) * size) + size/2 - 6, (startY + (rows-1) * size) + size/2 + 7);
}
}