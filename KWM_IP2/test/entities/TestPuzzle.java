package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPuzzle {

    private Tile[] startingTileArray = new Tile[9];
    private Tile[] normalTileArray = new Tile[9];
    private Tile[] incorrectTileArray1 = new Tile[9];
    private Tile[] incorrectTileArray2 = new Tile[9];
    private Tile[] winningTileArray1 = new Tile[9];
    private Tile[] winningTileArray2 = new Tile[9];
    private Tile[] losingTileArray1 = new Tile[9];
    private Tile[] losingTileArray2 = new Tile[9];
    private Tile[] losingTileArray3 = new Tile[9];

    private int[] startingTileValues = {1, 4, 3, 7, 2, 5, 9, 8, 6};
    private int[] normalTileValues = {2, 4, 6, -1, 2, 0, 9, 7, 1};
    private int[] incorrectTileValues = {-1, -2, 0, 1, 4, 8, 32, 1000, -9999};
    private int[] winningTileValues1 = {-1, -1, -1, -1, 11, -1, -1, -1, -1};
    private int[] winningTileValues2 = {-1, -1, -1, -1, 99999, -1, -1, -1, -1};
    private int[] losingTileValues1 = {1, -1, 1, -1, 1, -1, 1, -1, 1};
    private int[] losingTileValues2 = {-1, -1, -1, -1, -1, 5, -1, 4, -1};
    private int[] losingTileValues3 = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    /**
     * check that a puzzle can be properly constructed and that its initial values are correct
     */
    @Test
    public void testConstructor() {
        Puzzle newTestPuzzle = new Puzzle();

        assertEquals(newTestPuzzle, newTestPuzzle);
    }

    /**
     * check the getter for the tiles of the puzzle
     */
    @Test
    public void testGetTiles() {
        Puzzle testPuzzle = new Puzzle();
        testPuzzle.reset();
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                incorrectTileArray1[index] = new Tile(r, c, incorrectTileValues[index]);
                incorrectTileArray2[index] = new Tile(c, r, 0);
                index++;
            }
        }

        Tile[] tileArray = testPuzzle.getTiles();
        assertEquals(tileArray[0].getRow(), startingTileArray[0].getRow());
        assertEquals(tileArray[0].getColumn(), startingTileArray[0].getColumn());
        assertEquals(tileArray[0].getTileValue(), startingTileArray[0].getTileValue());
        assertEquals(tileArray[1].getRow(), startingTileArray[1].getRow());
        assertEquals(tileArray[1].getColumn(), startingTileArray[1].getColumn());
        assertEquals(tileArray[1].getTileValue(), startingTileArray[1].getTileValue());
        assertEquals(tileArray[2].getRow(), startingTileArray[2].getRow());
        assertEquals(tileArray[2].getColumn(), startingTileArray[2].getColumn());
        assertEquals(tileArray[2].getTileValue(), startingTileArray[2].getTileValue());
        assertEquals(tileArray[3].getRow(), startingTileArray[3].getRow());
        assertEquals(tileArray[3].getColumn(), startingTileArray[3].getColumn());
        assertEquals(tileArray[3].getTileValue(), startingTileArray[3].getTileValue());
        assertEquals(tileArray[4].getRow(), startingTileArray[4].getRow());
        assertEquals(tileArray[4].getColumn(), startingTileArray[4].getColumn());
        assertEquals(tileArray[4].getTileValue(), startingTileArray[4].getTileValue());
        assertEquals(tileArray[5].getRow(), startingTileArray[5].getRow());
        assertEquals(tileArray[5].getColumn(), startingTileArray[5].getColumn());
        assertEquals(tileArray[5].getTileValue(), startingTileArray[5].getTileValue());
        assertEquals(tileArray[6].getRow(), startingTileArray[6].getRow());
        assertEquals(tileArray[6].getColumn(), startingTileArray[6].getColumn());
        assertEquals(tileArray[6].getTileValue(), startingTileArray[6].getTileValue());
        assertEquals(tileArray[7].getRow(), startingTileArray[7].getRow());
        assertEquals(tileArray[7].getColumn(), startingTileArray[7].getColumn());
        assertEquals(tileArray[7].getTileValue(), startingTileArray[7].getTileValue());
        assertEquals(tileArray[8].getRow(), startingTileArray[8].getRow());
        assertEquals(tileArray[8].getColumn(), startingTileArray[8].getColumn());
        assertEquals(tileArray[8].getTileValue(), startingTileArray[8].getTileValue());


        assertNotEquals(tileArray[0].getTileValue(), startingTileArray[8].getTileValue());
        assertNotEquals(tileArray[1].getTileValue(), startingTileArray[7].getTileValue());
        assertNotEquals(tileArray[2].getTileValue(), startingTileArray[6].getTileValue());
        assertNotEquals(tileArray[3].getTileValue(), startingTileArray[5].getTileValue());
        assertNotEquals(tileArray[4].getTileValue(), startingTileArray[3].getTileValue());
        assertNotEquals(tileArray[5].getTileValue(), startingTileArray[4].getTileValue());
        assertNotEquals(tileArray[6].getTileValue(), startingTileArray[2].getTileValue());
        assertNotEquals(tileArray[7].getTileValue(), startingTileArray[1].getTileValue());
        assertNotEquals(tileArray[8].getTileValue(), startingTileArray[0].getTileValue());

        assertNotEquals(tileArray[0].getTileValue(), incorrectTileArray1[0].getTileValue());
        assertNotEquals(tileArray[1].getTileValue(), incorrectTileArray1[1].getTileValue());
        assertNotEquals(tileArray[2].getTileValue(), incorrectTileArray1[2].getTileValue());
        assertNotEquals(tileArray[3].getTileValue(), incorrectTileArray1[3].getTileValue());
        assertNotEquals(tileArray[4].getTileValue(), incorrectTileArray1[4].getTileValue());
        assertNotEquals(tileArray[5].getTileValue(), incorrectTileArray1[5].getTileValue());
        assertNotEquals(tileArray[6].getTileValue(), incorrectTileArray1[6].getTileValue());
        assertNotEquals(tileArray[7].getTileValue(), incorrectTileArray1[7].getTileValue());
        assertNotEquals(tileArray[8].getTileValue(), incorrectTileArray1[8].getTileValue());

        assertNotEquals(tileArray[0].getTileValue(), incorrectTileArray2[0].getTileValue());
        assertNotEquals(tileArray[1].getTileValue(), incorrectTileArray2[1].getTileValue());
        assertNotEquals(tileArray[2].getTileValue(), incorrectTileArray2[2].getTileValue());
        assertNotEquals(tileArray[3].getTileValue(), incorrectTileArray2[3].getTileValue());
        assertNotEquals(tileArray[4].getTileValue(), incorrectTileArray2[4].getTileValue());
        assertNotEquals(tileArray[5].getTileValue(), incorrectTileArray2[5].getTileValue());
        assertNotEquals(tileArray[6].getTileValue(), incorrectTileArray2[6].getTileValue());
        assertNotEquals(tileArray[7].getTileValue(), incorrectTileArray2[7].getTileValue());
        assertNotEquals(tileArray[8].getTileValue(), incorrectTileArray2[8].getTileValue());
    }

    /**
     * check that the values of the puzzle can be properly reset
     */
    @Test
    public void testReset() {
        Tile[] testTileArray = new Tile[9];
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                winningTileArray1[index] = new Tile(r, c, winningTileValues1[index]);
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                testTileArray[index] = new Tile(r, c, losingTileValues3[index]);
                index++;
            }
        }
        Puzzle winningPuzzle1 = new Puzzle();
        winningPuzzle1.setTiles(winningTileArray1);

        winningPuzzle1.reset();

        for (int i = 0; i < 9; i++) {
            assertEquals(startingTileArray[i].getTileValue(), winningPuzzle1.getTiles()[i].getTileValue());
            assertEquals(startingTileArray[i].getRow(), winningPuzzle1.getTiles()[i].getRow());
            assertEquals(startingTileArray[i].getColumn(), winningPuzzle1.getTiles()[i].getColumn());
        }
    }

    /**
     * check that the puzzle can recognize a winning condition
     */
    @Test
    public void testInWinState() {
        Tile[] testTileArray = new Tile[9];
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                winningTileArray1[index] = new Tile(r, c, winningTileValues1[index]);
                winningTileArray2[index] = new Tile(r, c, winningTileValues2[index]);
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                testTileArray[index] = new Tile(r, c, losingTileValues3[index]);
                index++;
            }
        }
        Puzzle winningPuzzle1 = new Puzzle();
        winningPuzzle1.setTiles(winningTileArray1);

        Puzzle winningPuzzle2 = new Puzzle();
        winningPuzzle2.setTiles(winningTileArray2);

        Puzzle nonWinningPuzzle = new Puzzle();
        nonWinningPuzzle.setTiles(startingTileArray);

        Puzzle losingPuzzle = new Puzzle();
        losingPuzzle.setTiles(testTileArray);

        assertTrue(winningPuzzle1.inWinState());
        assertTrue(winningPuzzle2.inWinState());
        assertFalse(nonWinningPuzzle.inWinState());
        assertFalse(losingPuzzle.inWinState());
    }

    /**
     * check that the puzzle can recognize a losing state
     */
    @Test
    public void testInLoseState() {

        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                losingTileArray1[index] = new Tile(r, c, losingTileValues1[index]);
                losingTileArray2[index] = new Tile(r, c, losingTileValues2[index]);
                losingTileArray3[index] = new Tile(r, c, losingTileValues3[index]);
                winningTileArray1[index] = new Tile(r, c, winningTileValues1[index]);
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                index++;
            }
        }
        Puzzle losingPuzzle1 = new Puzzle();
        losingPuzzle1.setTiles(losingTileArray1);

        Puzzle losingPuzzle2 = new Puzzle();
        losingPuzzle2.setTiles(losingTileArray2);

        Puzzle losingPuzzle3 = new Puzzle();
        losingPuzzle3.setTiles(losingTileArray3);

        Puzzle nonLosingPuzzle1 = new Puzzle();
        nonLosingPuzzle1.setTiles(winningTileArray1);

        Puzzle nonLosingPuzzle2 = new Puzzle();
        nonLosingPuzzle2.setTiles(startingTileArray);

        assertTrue(losingPuzzle1.inLoseState());
        assertTrue(losingPuzzle2.inLoseState());
        assertTrue(losingPuzzle3.inLoseState());
        assertFalse(nonLosingPuzzle1.inLoseState());
        assertFalse(nonLosingPuzzle2.inLoseState());
    }

    /**
     * check that valid moves can be properly recognized and invalid moves are filtered out
     */
    @Test
    public void testIsValidMove() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                normalTileArray[index] = new Tile(r, c, normalTileValues[index]);
                index++;
            }
        }

        Puzzle testPuzzle1 = new Puzzle();
        Puzzle testPuzzle2 = new Puzzle();

        testPuzzle1.setTiles(startingTileArray);
        testPuzzle2.setTiles(normalTileArray);

        assertTrue(testPuzzle1.isValidMove(0, 0));
        assertTrue(testPuzzle1.isValidMove(0, 3));
        assertTrue(testPuzzle2.isValidMove(1, 5));
        assertTrue(testPuzzle2.isValidMove(2, 4));

        assertFalse(testPuzzle1.isValidMove(1, 0));
        assertFalse(testPuzzle1.isValidMove(0, 2));
        assertFalse(testPuzzle2.isValidMove(1, 4));
        assertFalse(testPuzzle2.isValidMove(3, 8));
        assertFalse(testPuzzle2.isValidMove(2, 2));

        assertFalse(testPuzzle1.isValidMove(1, 1));
        assertFalse(testPuzzle2.isValidMove(3, 5));
        assertFalse(testPuzzle2.isValidMove(3, 4));
    }

    /**
     * check that moves are properly processed
     */
    @Test
    public void testMakeMove() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                index++;
            }
        }

        Puzzle testPuzzle1 = new Puzzle();

        testPuzzle1.setTiles(startingTileArray);

        assertEquals(1, testPuzzle1.getTiles()[0].getTileValue());
        testPuzzle1.makeMove(0, 0);
        assertEquals(-1, testPuzzle1.getTiles()[0].getTileValue());
        assertEquals(5, testPuzzle1.getTiles()[1].getTileValue());
        testPuzzle1.makeMove(3, 4);
        assertEquals(-1, testPuzzle1.getTiles()[4].getTileValue());
        assertEquals(4, testPuzzle1.getTiles()[7].getTileValue());
        testPuzzle1.makeMove(1, 2);
        assertEquals(-1, testPuzzle1.getTiles()[2].getTileValue());
        assertEquals(2, testPuzzle1.getTiles()[1].getTileValue());
        testPuzzle1.makeMove(2, 8);
        assertEquals(-1, testPuzzle1.getTiles()[8].getTileValue());
        assertEquals(30, testPuzzle1.getTiles()[5].getTileValue());
    }

    /**
     * check the setter for the tiles of the puzzle
     */
    @Test
    public void testSetTiles() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                index++;
            }
        }

        Puzzle testPuzzle1 = new Puzzle();

        testPuzzle1.setTiles(startingTileArray);

        for (int i = 0; i < 9; i++) {
            assertEquals(testPuzzle1.getTiles()[i].getTileValue(), startingTileValues[i]);
        }
    }
}