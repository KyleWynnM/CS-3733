package entities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestCoordinate {
    Coordinate topLeft = new Coordinate(0, 0);
    Coordinate topLeftButWithADifferentName = new Coordinate(0, 0);
    Coordinate center = new Coordinate(1, 1);
    Coordinate bottomLeft = new Coordinate(0, 2);
    Coordinate topRight = new Coordinate(2, 0);

    /**
     * check that the coordinates can be properly made, and that their values return as expected
     */
    @Test
    public void testConstructor() {
        Coordinate testCoordinate = new Coordinate(1, 2);

        assertEquals(testCoordinate.col, 1);
        assertEquals(testCoordinate.row, 2);

        assertNotEquals(testCoordinate.col, 2);
        assertNotEquals(testCoordinate.row, 1);

        assertNotEquals(testCoordinate.col, 0);
        assertNotEquals(testCoordinate.row, 0);

        assertNotEquals(testCoordinate.col, "");
        assertNotEquals(testCoordinate.row, "");
    }

    /**
     * check that the proper override has been done, and that it can be properly determined when two coordinates are equal
     */
    @Test
    public void testEquals() {
        assertTrue(topLeft.equals(topLeftButWithADifferentName));
        assertTrue(topLeft.equals(topLeft));

        assertFalse(topLeft.equals(topRight));
        assertFalse(topLeft.equals(bottomLeft));
        assertFalse(topLeft.equals(center));
        assertFalse(topLeft.equals(null));
        assertFalse(topLeft.equals("This should not equal the coordinate"));
    }

    /**
     * check that the proper conversion to string can be made as expected
     */
    @Test
    public void testToString() {
        assertEquals("(0,0)", topLeft.toString());
        assertNotEquals("(0,1)", topLeft.toString());
        assertNotEquals("(0, 1)", topLeft.toString());
        assertNotEquals("", center.toString());
    }
}
