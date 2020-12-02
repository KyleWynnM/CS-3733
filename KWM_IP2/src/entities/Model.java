package entities;

public class Model {
    Puzzle puzzle;
    boolean gameOver;
    Tile selectedTile;

    /**
     * constructor for model class
     */
    public Model() {

    }

    /**
     * check if the game is over by checking if the puzzle has been won or lost
     * @return
     */
    public boolean gameOver() {
        return puzzle.inLoseState() || puzzle.inWinState();
    }

    /**
     * setter for the puzzle field of the model
     * @param p
     */
    public void setPuzzle(Puzzle p) {
        puzzle = p;
        gameOver = false;
        selectedTile = null;
    }

    /**
     * getter for the puzzle field
     * @return
     */
    public Puzzle getPuzzle() { return puzzle; }

    /**
     * set the selected tile
     * @param t
     */
    public void setSelectedPiece(Tile t) { selectedTile = t; }

    /**
     * clear what the selected tile is
     */
    public void clearSelectedTile() { selectedTile = null; }

    /**
     * getter for the selected tile
     * @return the selected tile
     */
    public Tile getSelectedTile() { return selectedTile; }


    /**
     * bring the puzzle back to starting conditions
     */
    public void resetPuzzle() {
        puzzle.reset();
        selectedTile = null;
        gameOver = false;
    }
}