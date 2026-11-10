public class Tile
{
	/*
	* 4 Static Indexes to go through the 4 walls and see if we can connect tiles to make consecutive paths
	* (one need 4 indexes due to it being a square tile pixel each time)
	* Needed to form empty paths for player to go through
	*/

	public static int topWall = 0; //index 0 in the walls array = top wall of tile
	public static int bottomWall = 1; //index 1 in the walls array = bottom wall of tile
	public static int leftWall = 2; //index 2 in the walls array = left wall of tile
	public static int rightWall = 3; //index 3 in the walls array = right wall of tile

	boolean[] wall = {true, true, true, true}; //check if there is wall there in that direction

	boolean visited = false;


	//actually forms the path by saying there should not be a wall in the indicated direction
	public void removeWall(int walls)
	{
		wall[walls] = false;
	}


	//Checks if there is a wall present
	//Important in making the graphics for it (needs to create a rectangle there)
	public boolean hasWall(int walls)
	{
		return wall[walls];
	}

}