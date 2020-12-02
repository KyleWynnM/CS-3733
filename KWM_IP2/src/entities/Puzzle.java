package entities;

import java.util.Arrays;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile> {
    private final int add = 0;
    private final int subtract = 1;
    private final int multiply = 2;
    private final int divide = 3;

    private Tile[] tiles = new Tile[9];

    /**
     * puzzle class constructor
     */
    public Puzzle() {
    }

    /**
     * getter for the tiles of the puzzle
     * @return the tiles
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * reset the puzzle to the values of the starting tiles
     */
    public void reset() {
        int[] tileValues = new int[]{1, 4, 3, 7, 2, 5, 9, 8, 6};
        Tile[] newTiles = new Tile[9];
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                newTiles[index] = new Tile(r, c, tileValues[index]);
                index++;
            }
        }
        this.setTiles(newTiles);
    }

    /**
     * check if the game has been won by checking if the center tile is full and all other tiles aren't
     * @return whether the game has been won
     */
    public boolean inWinState() {
        boolean eightEmpty, centerFull;
        centerFull = tiles[4].getTileValue() != -1;

        if (!centerFull) {
            return false;
        }

        int numEmpty = 0;
        for (Tile t : tiles) {
            if (t.getTileValue() == -1) {
                numEmpty++;
            }
        }

        eightEmpty = numEmpty == 8;
        return eightEmpty;
    }

    /**
     * check if the game has been lost by iterating through all tiles and checking if any of them have possible moves
     * or if any one tile has become isolated (I bruteforced part of this I've been thinking too much this week I needed
     * a break)
     * @return whether the game has been lost
     */
    public boolean inLoseState() {
        if (this.inWinState()) {
            return false;
        }

        //bruteforce through the nine tiles to see if any are isolated

        boolean isolatedTile = (tiles[0].getTileValue() != -1 && tiles[1].getTileValue() == -1 && tiles[3].getTileValue() == -1)
                || (tiles[1].getTileValue() != -1 && tiles[0].getTileValue() == -1 && tiles[2].getTileValue() == -1 && tiles[4].getTileValue() == -1)
                || (tiles[2].getTileValue() != -1 && tiles[1].getTileValue() == -1 && tiles[5].getTileValue() == -1)
                || (tiles[3].getTileValue() != -1 && tiles[0].getTileValue() == -1 && tiles[4].getTileValue() == -1 && tiles[6].getTileValue() == -1)
                || (tiles[4].getTileValue() != -1 && tiles[1].getTileValue() == -1 && tiles[3].getTileValue() == -1 && tiles[5].getTileValue() == -1 && tiles[7].getTileValue() == -1)
                || (tiles[5].getTileValue() != -1 && tiles[2].getTileValue() == -1 && tiles[4].getTileValue() == -1 && tiles[8].getTileValue() == -1)
                || (tiles[6].getTileValue() != -1 && tiles[3].getTileValue() == -1 && tiles[7].getTileValue() == -1)
                || (tiles[7].getTileValue() != -1 && tiles[6].getTileValue() == -1 && tiles[8].getTileValue() == -1 && tiles[4].getTileValue() == -1)
                || (tiles[8].getTileValue() != -1 && tiles[5].getTileValue() == -1 && tiles[7].getTileValue() == -1);

        if (isolatedTile) {
            return true;
        }

        for (int t = 0; t < tiles.length; t++) {
            for (int op = 0; op < 4; op++) {
                if (isValidMove(op, t)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * check if a given move is possible/allowed
     * @param op the direction (operation) the tile is going
     * @param st the starting tile in the move, this tile goes into the target tile
     * @return whether or not the move is allowed
     */
    public boolean isValidMove(int op, int st) {
        boolean validMove;

        if (tiles[st].getTileValue() == -1) {
            return false;
        }

        switch (op) {
            //check if the tiles involved are present and that the starting tile is not on the right side
            case add:
                validMove = (st + 1) % 3 != 0 && tiles[st + 1].getTileValue() != -1;
                break;
            //check if the tiles involved are present and that the starting tile is not on the left side
            // and that the result won't be negative
            case subtract:
                if (st != 0) {
                    validMove = (st + 3) % 3 != 0 &&
                            tiles[st - 1].getTileValue() >= tiles[st].getTileValue() &&
                            tiles[st - 1].getTileValue() != -1;
                } else {
                    validMove = false;
                }
                break;
            //check if the tiles involved are present and that the starting tile is not on the top row
            case multiply:
                if (st > 2) {
                    validMove = tiles[st - 3].getTileValue() != -1;
                } else {
                    validMove = false;
                }
                break;
            //check if the tiles involved are present, the quotient is an integer, and that the starting tile is not on the bottom row
            case divide:
                if (st < 6 && tiles[st].getTileValue() != 0) {
                    validMove = tiles[st + 3].getTileValue() != -1 &&
                            tiles[st + 3].getTileValue() % tiles[st].getTileValue() == 0;
                } else {
                    validMove = false;
                }
                break;
            default:
                validMove = false;
                break;
        }
        return validMove;
    }

    /**
     * makeMove processes the move and makes the adjustments to the puzzle
     * @param op the direction (operation)
     * @param st the starting tile
     */
    public void makeMove(int op, int st) {
        int newValue;
        //based on the operation, shift the tiles and recompute
        switch (op) {
            case add:
                newValue = tiles[st + 1].getTileValue() + tiles[st].getTileValue();
                tiles[st + 1].setTileValue(newValue);
                tiles[st].setTileValue(-1);
                break;
            case subtract:
                newValue = tiles[st - 1].getTileValue() - tiles[st].getTileValue();
                tiles[st - 1].setTileValue(newValue);
                tiles[st].setTileValue(-1);
                break;
            case multiply:
                newValue = tiles[st - 3].getTileValue() * tiles[st].getTileValue();
                tiles[st - 3].setTileValue(newValue);
                tiles[st].setTileValue(-1);
                break;
            case divide:
                newValue = tiles[st + 3].getTileValue() / tiles[st].getTileValue();
                tiles[st + 3].setTileValue(newValue);
                tiles[st].setTileValue(-1);
                break;
            default:
                break;
        }
    }

    @Override
    public Iterator<Tile> iterator() {
        return Arrays.asList(tiles).iterator();
    }

    /**
     * setter for the tiles of the puzzle
     * @param newTiles
     */
    public void setTiles(Tile[] newTiles) {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                tiles[index] = newTiles[index];
                index++;
            }
        }
    }
}

	