import java.util.Scanner;

/**
 * <h1>Generate a K-Turtle Maze!</h1>
 * The program generates a (rectangular) maze and then prints the required k-turtle instructions
 * to print it.
 * <p>
 * The maze is generated using the <b>Depth First Search Algorithm</b>
 * <p>
 * <b>Note:</b> The maximum square size (before a stackOverflowError occurs) is around
 * 120 x 120
 *
 * @author Anuvrat Patil
 */
public class Main {


    private static final Scanner sc = new Scanner(System.in);


    /**
     * <h2>Depth First Search!</h2>
     * (Normally) Starting from a random point in the maze, iterates over the entire maze
     * using the Depth-First-Search algorithm to open up the grid into a perfect maze
     * <p>
     * <b>Note:</b> A perfect maze is a maze where every cell can be accessed by any other cell,
     * and no loops exist, i.e. only one path exists between any 2 cells
     *
     * @param g the maze being generated
     * @param r row # of the cell currently being iterated over
     * @param c column # of the cell currently being iterated over
     * @exception IndexOutOfBoundsException when r or c are out of bounds of the maze
     * @author Anuvrat Patil
     */
    public void depthFirstSearch(Maze g, int r, int c) {

        if (r < 0 || r > g.getRows()-1 || c < 0 || c > g.getCols()-1)
            throw new IndexOutOfBoundsException();

        g.getCell(r, c).setOpen(true);

        this.borderChecks(g, r, c);
        this.neighbourChecks(g, r, c);

        while (g.getCell(r, c).getNeighboursOpened() != 4) {

            int toTest = (int) (Math.random() * 4) + 1;
            final int testUp = 1, testDown = 2, testLeft = 3, testRight = 4;

            if (toTest == testUp) {
                if (r == 0 || g.getCell(r-1, c).getOpen() || g.getCell(r, c).getUp()) {
                    continue;
                }
                g.getCell(r, c).setUp(true);
                g.getCell(r-1, c).setDown(true);
                depthFirstSearch(g, r-1, c);
            }

            else if (toTest == testDown) {
                if (r == g.getRows()-1 || g.getCell(r+1, c).getOpen() || g.getCell(r, c).getDown()) {
                    continue;
                }
                g.getCell(r, c).setDown(true);
                g.getCell(r+1, c).setUp(true);
                depthFirstSearch(g, r+1, c);
            }

            else if (toTest == testLeft) {
                if (c == 0 || g.getCell(r, c-1).getOpen() || g.getCell(r, c).getLeft()) {
                    continue;
                }
                g.getCell(r, c).setLeft(true);
                g.getCell(r, c-1).setRight(true);
                depthFirstSearch(g, r, c-1);
            }

            else if (toTest == testRight) {
                if (c == g.getCols()-1 || g.getCell(r, c+1).getOpen() || g.getCell(r, c).getRight()) {
                    continue;
                }
                g.getCell(r, c).setRight(true);
                g.getCell(r, c+1).setLeft(true);
                depthFirstSearch(g, r, c+1);
            }

        }

    }

    /**
     * Checks if the provided cell of the maze is a border cell
     * If it is a border cell, adds respective neighbour counts
     *
     * @param g maze being worked on
     * @param r row # of the cell we are checking
     * @param c column # of the cell we are checking
     * @author Anuvrat Patil
     */
    public void borderChecks(Maze g, int r, int c) {
        if (r == 0)                 g.getCell(r, c).addNeighboursOpened(true);
        if (r == g.getRows()-1)     g.getCell(r, c).addNeighboursOpened(true);
        if (c == 0)                 g.getCell(r, c).addNeighboursOpened(true);
        if (c == g.getCols()-1)     g.getCell(r, c).addNeighboursOpened(true);
    }

    /**
     * Checks if the provided cell has neighbours on every border
     * Every neighbour gets an opened neighbour added to them
     *
     * @param g maze being worked
     * @param r row # of the cell we are checking neighbours of
     * @param c column # of the cell we are checking neighbours of
     * @exception IndexOutOfBoundsException when r or c are out of bounds of the maze
     * @author Anuvrat Patil
     */
    public void neighbourChecks(Maze g, int r, int c) {
        if (r < 0 || r > g.getRows()-1 || c < 0 || c > g.getCols()-1)
            throw new IndexOutOfBoundsException();

        if (r != 0)                 g.getCell(r-1,c).addNeighboursOpened(true);
        if (r != g.getRows()-1)     g.getCell(r+1,c).addNeighboursOpened(true);
        if (c !=0)                  g.getCell(r,c-1).addNeighboursOpened(true);
        if (c != g.getCols()-1)     g.getCell(r,c+1).addNeighboursOpened(true);
    }

    /**
     * Sets the start and stop of a maze by opening up the left and right borders of a left edge and
     * right edge cell respectively
     *
     * @param g the maze whose start and stop is being set
     * @author Anuvrat Patil
     */
    public void setStartAndStop(Maze g) {
        g.getCell(g.getStart(), 0).setLeft(true);
        g.getCell(g.getStart(), g.getCols()-1).setRight(true);
    }


    /**
     * <h2>Instruction Prints!</h2>
     * Prints the K-turtle instructions to print the provided maze
     * and then move the turtle to the starting position
     *
     * @param g the maze that is to be printed
     * @author Anuvrat Patil
     */
    public void printInstructions(Maze g) {

        System.out.println("\n\nreset");
        System.out.println("canvassize " + (g.getCols() * 40 + 80) + ", " + (g.getRows() * 40 + 80));
        System.out.println("pd");

        for (int i = 0; i < g.getRows(); i++) {
            for (int j = 0; j < g.getCols(); j++) {

                System.out.println("go " + (j*40 + 40) +  ", " + (i*40 + 40));

                System.out.println("dir 90");
                if (g.getCell(i,j).getUp()) System.out.println("pu");
                System.out.println("fw 40");
                if (g.getCell(i,j).getUp()) System.out.println("pd");

                System.out.println("dir 180");
                if (g.getCell(i,j).getRight()) System.out.println("pu");
                System.out.println("fw 40");
                if (g.getCell(i,j).getRight()) System.out.println("pd");

                System.out.println("dir 270");
                if (g.getCell(i, j).getDown()) System.out.println("pu");
                System.out.println("fw 40");
                if (g.getCell(i, j).getDown()) System.out.println("pd");

                System.out.println("dir 0");
                if (g.getCell(i, j).getLeft()) System.out.println("pu");
                System.out.println("fw 40");
                if (g.getCell(i, j).getLeft()) System.out.println("pd");

            }
        }

        System.out.println("go 20, " + (g.getStart()*40 + 60));
        System.out.println("dir 90");

    }


    /**
     * <h2>Main method</h2>
     * <p>
     * - takes the size input of the maze
     * <p>
     * - picks a random start and stop positions
     * <p>
     * - generates a perfect-maze (always solvable) of provided size using DFS
     * <p>
     * - prints K-turtle instructions to print said maze
     *
     * @param args convention; unused
     * @author Anuvrat Patil
     */
    public static void main(String[] args) {
        System.out.print("Enter row count: ");
        int r = sc.nextInt();
        System.out.print("Enter Column Count: ");
        int c = sc.nextInt();

        long startTime = System.nanoTime();

        Maze game = new Maze(r, c, (int) (Math.random() * r), (int) (Math.random() * r));
        Main ob = new Main();
        ob.depthFirstSearch(game, (int) (Math.random() * r), (int) (Math.random() * c));
        ob.setStartAndStop(game);
        ob.printInstructions(game);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("runtime = " + duration / 1000000 + "ms");
        System.out.println("to create the cell grid, generate a perfect maze on it, and print instructions to draw it on k-turtle.");
    }

}
