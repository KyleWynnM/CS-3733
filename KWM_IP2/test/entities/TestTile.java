package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTile {

    /**
     * check that a tile can be properly constructed and that the assigned values return as expected
     */
    @Test
    public void testConstructor() {
        Tile testTile = new Tile(1,2, 3);

        assertEquals(testTile.getRow(), 1);
        assertEquals(testTile.getColumn(), 2);
        assertEquals(testTile.getTileValue(), 3);

        assertNotEquals(testTile.getRow(), 0);
        assertNotEquals(testTile.getColumn(), -1);
        assertNotEquals(testTile.getTileValue(), 1);
    }

    /**
     * check the getter for the column field
     */
    @Test
    public void testGetColumn() {
        Tile testTile1 = new Tile(0,0, 0);
        Tile testTile2 = new Tile(1,0, 1);
        Tile testTile3 = new Tile(0,1, 0);
        Tile testTile4 = new Tile(0,-1, 0);
        Tile testTile5 = new Tile(0,100, 0);
        Tile testTile6 = new Tile(0,1000, 0);
        Tile testTile7 = new Tile(-1,-1, -1);

        assertEquals(testTile1.getColumn(), 0);
        assertEquals(testTile2.getColumn(), 0);
        assertEquals(testTile3.getColumn(), 1);
        assertEquals(testTile4.getColumn(), -1);
        assertEquals(testTile5.getColumn(), 100);
        assertEquals(testTile6.getColumn(), 1000);
        assertEquals(testTile7.getColumn(), -1);

        assertNotEquals(testTile1.getColumn(), 1);
        assertNotEquals(testTile2.getColumn(), 100);
        assertNotEquals(testTile3.getColumn(), -100);
        assertNotEquals(testTile4.getColumn(), 500);
        assertNotEquals(testTile5.getColumn(), .5);
        assertNotEquals(testTile6.getColumn(), 'a');
        assertNotEquals(testTile7.getColumn(), "");
    }

    /**
     * check the getter for the row field
     */
    @Test
    public void testGetRow() {
        Tile testTile1 = new Tile(0,0, 0);
        Tile testTile2 = new Tile(0,1, 1);
        Tile testTile3 = new Tile(1,0, 0);
        Tile testTile4 = new Tile(-1,0, 0);
        Tile testTile5 = new Tile(100,0, 0);
        Tile testTile6 = new Tile(1000,0, 0);
        Tile testTile7 = new Tile(-1,-1, -1);

        assertEquals(testTile1.getRow(), 0);
        assertEquals(testTile2.getRow(), 0);
        assertEquals(testTile3.getRow(), 1);
        assertEquals(testTile4.getRow(), -1);
        assertEquals(testTile5.getRow(), 100);
        assertEquals(testTile6.getRow(), 1000);
        assertEquals(testTile7.getRow(), -1);

        assertNotEquals(testTile1.getRow(), 1);
        assertNotEquals(testTile2.getRow(), 100);
        assertNotEquals(testTile3.getRow(), -100);
        assertNotEquals(testTile4.getRow(), 500);
        assertNotEquals(testTile5.getRow(), .5);
        assertNotEquals(testTile6.getRow(), 'a');
        assertNotEquals(testTile7.getRow(), "");
    }

    /**
     * check the getter for the tile value
     */
    @Test
    public void testGetTileValue() {
        Tile testTile1 = new Tile(0,0, 0);
        Tile testTile2 = new Tile(0,1, 5);
        Tile testTile3 = new Tile(1,0, 10);
        Tile testTile4 = new Tile(-1,0, -10);
        Tile testTile5 = new Tile(100,0, -100);
        Tile testTile6 = new Tile(-1,-1, 0);
        Tile testTile7 = new Tile(5000,5000, -1);

        assertEquals(testTile1.getTileValue(), 0);
        assertEquals(testTile2.getTileValue(), 5);
        assertEquals(testTile3.getTileValue(), 10);
        assertEquals(testTile4.getTileValue(), -10);
        assertEquals(testTile5.getTileValue(), -100);
        assertEquals(testTile6.getTileValue(), 0);
        assertEquals(testTile7.getTileValue(), -1);

        assertNotEquals(testTile1.getTileValue(), 1);
        assertNotEquals(testTile2.getTileValue(), 100);
        assertNotEquals(testTile3.getTileValue(), -100);
        assertNotEquals(testTile4.getTileValue(), 500);
        assertNotEquals(testTile5.getTileValue(), .5);
        assertNotEquals(testTile6.getTileValue(), 'a');
        assertNotEquals(testTile7.getTileValue(), "");
    }

    /**
     * check the setter for the tile value
     */
    @Test
    public void testSetTileValue() {
        Tile testTile1 = new Tile(0,0, 0);
        Tile testTile2 = new Tile(0,1, 5);
        Tile testTile3 = new Tile(1,0, 10);
        Tile testTile4 = new Tile(-1,0, -10);
        Tile testTile5 = new Tile(100,0, -100);
        Tile testTile6 = new Tile(-1,-1, 0);
        Tile testTile7 = new Tile(5000,5000, -1);

        testTile1.setTileValue(1);
        testTile2.setTileValue(0);
        testTile3.setTileValue(10);
        testTile4.setTileValue(10);
        testTile5.setTileValue(100);
        testTile6.setTileValue(-100);
        testTile7.setTileValue(0);

        assertEquals(testTile1.getTileValue(), 1);
        assertEquals(testTile2.getTileValue(), 0);
        assertEquals(testTile3.getTileValue(), 10);
        assertEquals(testTile4.getTileValue(), 10);
        assertEquals(testTile5.getTileValue(), 100);
        assertEquals(testTile6.getTileValue(), -100);
        assertEquals(testTile7.getTileValue(), 0);

        assertNotEquals(testTile1.getTileValue(), 0);
        assertNotEquals(testTile2.getTileValue(), 5);
        assertNotEquals(testTile3.getTileValue(), "");
        assertNotEquals(testTile4.getTileValue(), -10);
        assertNotEquals(testTile5.getTileValue(), -100);
        assertNotEquals(testTile6.getTileValue(), 0);
        assertNotEquals(testTile7.getTileValue(), -1);
    }

    /**
     * check that the tile can register when a coordinate lines up with the tile
     */
    @Test
    public void testContains() {
        Tile testTile1 = new Tile(0,0, 0);
        Tile testTile2 = new Tile(0,1, 5);
        Tile testTile3 = new Tile(1,0, 10);
        Tile testTile4 = new Tile(-1,0, -10);
        Tile testTile5 = new Tile(100,0, -100);
        Tile testTile6 = new Tile(-1,-1, 0);
        Tile testTile7 = new Tile(5000,5000, -1);

        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(1, 0);
        Coordinate c3 = new Coordinate(0, 1);
        Coordinate c4 = new Coordinate(0, -1);
        Coordinate c5 = new Coordinate(0, 100);
        Coordinate c6 = new Coordinate(-1, -1);
        Coordinate c7 = new Coordinate(5000, 5000);

        assertTrue(testTile1.contains(c1));
        assertTrue(testTile2.contains(c2));
        assertTrue(testTile3.contains(c3));
        assertTrue(testTile4.contains(c4));
        assertTrue(testTile5.contains(c5));
        assertTrue(testTile6.contains(c6));
        assertTrue(testTile7.contains(c7));

        assertFalse(testTile1.contains(c7));
        assertFalse(testTile2.contains(c6));
        assertFalse(testTile3.contains(c4));
        assertFalse(testTile4.contains(c5));
        assertFalse(testTile5.contains(c3));
        assertFalse(testTile6.contains(c2));
        assertFalse(testTile7.contains(c1));
    }
}
