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
    private Maze maze;
    private int startX; //where tiles would start (set to 100)
    private int startY; //where tiles would start (set to 100)
    private int size; //how large the tile will be

	
	public MazeGraphics()
	{
        size = 95; //pixels per tile
        maze = null;
        rows = 0;
        cols = 0;
	}



	//code to draw the Brick will go here
	public void paint( Graphics window )
	{
        int availableWidth = getWidth() - 200;
        int availableHeight = getHeight() - 200;

        cols = availableWidth / size;
        rows = availableHeight / size;

        maze = new Maze(rows, cols);
        maze.generate();

        int mazeWidth = cols * size;
        startX = (getWidth() - mazeWidth) / 2; //center in middle
        startY = 100;


        //background
        window.setColor(Color.black);
        window.fillRect(0, 0, getWidth(), getHeight());

        //check available spaceto work with

        //walls
        window.setColor(Color.white);
        int wall = 4;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = startX + c * size; //moving left and right and ensuring that it actually moves
                int y = startY + r * size; //moving up and down


                //if beginning at index 0 (top and left) no size added. right + bottom have size added to access the very bottom lien
                //wall is 4 pixels wide (hence the 4 in size and height)
                //the 2 comes from moving it around to be directly in the middle of that grid line (half above and half below)
                //size + 4 = 2px before cell + size cell + 2 px after cell
                //adjusted what gets moved around the most as per the wall locations
                if (maze.getGrid()[r][c].hasWall(Tile.topWall)) {
                    window.fillRect(x - wall/2, y - wall/2, size + wall, wall);
                }

                if (maze.getGrid()[r][c].hasWall(Tile.bottomWall)) {
                    window.fillRect(x - wall / 2, y + size - wall / 2, size + wall, wall);
                }

                if (maze.getGrid()[r][c].hasWall(Tile.rightWall)) {
                    window.fillRect(x + size - wall / 2, y - wall / 2, wall, size + wall);
                }
                if (maze.getGrid()[r][c].hasWall(Tile.leftWall)) {
                    window.fillRect(x - wall / 2, y - wall / 2, wall, size + wall);
                }

            }
        }
        //TEMPORARY - mark start
        window.setColor(Color.green);
        window.setFont(new Font("Comic Sans", Font.BOLD, 20));
        window.drawString("S", startX + size/2 -6, startY+size/2);

        window.setColor(Color.red);
        window.setFont(new Font("Comic Sans", Font.BOLD, 20));
        window.drawString("E", (startX + (cols -1) * size) + size / 2 + 6, (startY + (rows-1) * size) + size/2 -7);
//        window.fillRect(, , size, size); //DOOR WAY TO BE ADDED
}
}