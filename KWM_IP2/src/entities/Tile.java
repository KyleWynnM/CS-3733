package entities;

public class Tile {
    int row;
    int col;
    int tileValue;

    /**
     * constructor for the tile class
     * @param row the row of the tile
     * @param col the column of the tile
     * @param tileValue the value of the tile
     */
    public Tile(int row, int col, int tileValue) {
        this.row = row;
        this.col = col;
        this.tileValue = tileValue;
    }

    /**
     * set the value of a tile
     * @param v
     */
    public void setTileValue(int v) { this.tileValue = v;}

    /**
     * get the column of a tile
     * @return col
     */
    public int getColumn() { return col; }

    /**
     * get the row of a tile
     * @return row
     */
    public int getRow() { return row; }

    /**
     * get the value of a tile
     * @return tileValue
     */
    public int getTileValue() {return tileValue;}

    /**
     * check if a coordinate is at a tile
     * @param c
     * @return whether the coordinate is at the tile
     */
    public boolean contains(Coordinate c) {
        if (c.col >= col && c.col < col + 1 && c.row >= row && c.row < row + 1) { return true; }
        return false;
    }
}