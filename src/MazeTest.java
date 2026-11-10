    public class MazeTest {

        public static void main(String[] args) {

            Maze maze = new Maze(10, 10);

            maze.generate();

            maze.printMaze();

            System.out.println("Solvable: " + maze.hasPath());
        }
    }
