package entities;

public class Coordinate {
    public final int col;
    public final int row;

    /**
     * Constructor for coordinate
     * @param col the column of the tile
     * @param row the row of the tile
     */
    public Coordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     * turn the coordinate of the tile into a string
     * @return the string value of the coordinate
     */
    public String toString () {
        return "(" + col + "," + row + ")";
    }

    /**
     * polymorph the equals function to check if two coordinate values are the same
     * @param o
     * @return whether or not the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        //if the other object is null, they're not equal
        if (o == null) { return false; }

        //check if it's a coordinate and if so, if it's a matching coordinate
        if (o instanceof Coordinate) {
            Coordinate other = (Coordinate) o;
            return col == other.col && row == other.row;
        }

        return false;
    }
}
