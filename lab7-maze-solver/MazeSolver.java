public class MazeSolver {
    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    // This prints out the maze row by row so we can see what it looks like
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    // This is the public method that finds the starting position S and kicks off the recursion
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;

        // Here this is the loop through the maze to find where S is
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        // If we found S we start solving from there
        if (startRow != -1) {
            return solve(startRow, startCol);
        }

        // Here there is no starting position found
        return false;
    }

    // This is the core recursive method that basically does all the work
    private boolean solve(int row, int col) {

        // Base case: if we went out of bounds this path is invalid
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }

        // Base case: if we hit a wall or already visited this cell it is a stop
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        // Base case: if we reached the finish that means we found the path
        if (maze[row][col] == 'F') {
            return true;
        }

        //so we dont visit it again we mark this cell as part of our current path 
        maze[row][col] = '.';

        // Here we try moving in all four directions
        if (solve(row - 1, col)) return true; // North
        if (solve(row, col + 1)) return true; // East
        if (solve(row + 1, col)) return true; // South
        if (solve(row, col - 1)) return true; // West

        // None of the directions worked so this is a dead end
        // Backtrack by unmarking this cell and returning false
        maze[row][col] = ' ';
        return false;
    }

    public static void main(String[] args) {

        // Maze 1 -> this one has a solution
        char[][] mazeWithSolution = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        System.out.println("Maze 1 - Original:");
        MazeSolver solver1 = new MazeSolver(mazeWithSolution);
        solver1.printMaze();

        if (solver1.solve()) {
            System.out.println("Maze 1 - Solution Found:");
        } else {
            System.out.println("Maze 1 - No Solution Found:");
        }
        solver1.printMaze();

        // Maze 2 -> this one has no solution because F is completely blocked by walls
        char[][] mazeNoSolution = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', 'F', '#', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        System.out.println("Maze 2 - Original:");
        MazeSolver solver2 = new MazeSolver(mazeNoSolution);
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Maze 2 - Solution Found:");
        } else {
            System.out.println("Maze 2 - No Solution Found:");
        }
        solver2.printMaze();
    }
}
