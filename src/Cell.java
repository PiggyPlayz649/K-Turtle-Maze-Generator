/**
 * <h1>Cells of the Maze!</h1>
 * Each cell has 4 borders, can be set open or closed, and has a neighbour count
 *
 * @author Anuvrat Patil
 */
public class Cell {


    private boolean open;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int neighboursOpened;


    /**
     *<h2>Constructor!</h2>
     * Initializes a completely closed cell with 0 neighbours
     *
     * @author Anuvrat Patil
     */
    public Cell() {
        this.open = false;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.neighboursOpened = 0;
    }


    /**
     * Getter for cell open status
     * @return cell open status
     * @author Anuvrat Patil
     */
    public boolean getOpen() {
        return this.open;
    }

    /**
     * Getter for top border open status
     * @return top border open status
     * @author Anuvrat Patil
     */
    public boolean getUp() {
        return this.up;
    }

    /**
     * Getter for bottom border open status
     * @return bottom border open status
     * @author Anuvrat Patil
     */
    public boolean getDown() {
        return this.down;
    }

    /**
     * Getter for left border open status
     * @return left border open status
     * @author Anuvrat Patil
     */
    public boolean getLeft() {
        return this.left;
    }

    /**
     * Getter for right border open status
     * @return right border open status
     * @author Anuvrat Patil
     */
    public boolean getRight() {
        return this.right;
    }

    /**
     * Getter for neighbour count of cell
     * @return neighbour count of cell
     * @author Anuvrat Patil
     */
    public int getNeighboursOpened() {
        return this.neighboursOpened;
    }

    /**
     * Sets cell to open (true) or closed (false)
     * @param status cell status
     * @author Anuvrat Patil
     */
    public void setOpen(boolean status) {
        this.open = status;
    }

    /**
     * Set cell's top border to open (true) or closed (false)
     * @param status top border status
     * @author Anuvrat Patil
     */
    public void setUp(boolean status) {
        this.up = status;
    }

    /**
     * Set cell's bottom border to open (true) or closed (false)
     * @param status bottom border status
     * @author Anuvrat Patil
     */
    public void setDown(boolean status) {
        this.down = status;
    }

    /**
     * Set cell's left border to open (true) or closed (false)
     * @param status left border status
     * @author Anuvrat Patil
     */
    public void setLeft(boolean status) {
        this.left = status;
    }

    /**
     * Set cell's right border to open (true) or closed (false)
     * @param status right border status
     * @author Anuvrat Patil
     */
    public void setRight(boolean status) {
        this.right = status;
    }

    /**
     * Add (true) or subtract (false) 1 from cell's neighbour count
     * @param toAdd to add (true) or subtract (false)
     * @author Anuvrat Patil
     */
    public void addNeighboursOpened(boolean toAdd) {
        this.neighboursOpened += toAdd ? 1 : -1;
    }
}
