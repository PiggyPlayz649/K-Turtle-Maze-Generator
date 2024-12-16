/**
 * <h1>Maze Class</h1>
 * Contains cells and a start stop positions
 *
 * @author Anuvrat Patil
 */
public class Maze {


    final private Cell[][] grid;
    final private int rows;
    final private int cols;
    final private int start;
    final private int stop;


    /**
     * <h2>Constructor!</h2>
     * sets base values and generates empty cells
     *
     * @param rows # of rows in the maze
     * @param cols # of columns in the maze
     * @param start row # of start cell (leftmost column)
     * @param stop row # of stop cell (rightmost column)
     * @author Anuvrat Patil
     */
    public Maze(int rows, int cols, int start, int stop) {
        this.rows = rows;
        this.cols = cols;
        this.start = start;
        this.stop = stop;
        this.grid = new Cell[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }


    /**
     * Getter for cells within the maze
     * @param row row # of cell to get
     * @param col column # of cell to get
     * @return cell
     * @author Anuvrat Patil
     */
    public Cell getCell(int row, int col) {
        return this.grid[row][col];
    }

    /**
     * Getter for row size of maze
     * @return row size of maze
     * @author Anuvrat Patil
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Getter for column size of maze
     * @return column size of maze
     * @author Anuvrat Patil
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Getter for row # of start cell
     * @return row # of start cell
     * @author Anuvrat Patil
     */
    public int getStart() {
        return this.start;
    }

    /**
     * Getter for row # of stop cell
     * @return row # of stop cell
     * @author Anuvrat Patil
     */
    public int getStop() {
        return this.stop;
    }
}
