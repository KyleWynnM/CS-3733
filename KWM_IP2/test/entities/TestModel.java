package entities;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestModel extends ModelTestCase {

    private Tile[] startingTileArray = new Tile[9];
    private Tile[] normalTileArray = new Tile[9];
    private Tile[] winningTileArray1 = new Tile[9];
    private Tile[] winningTileArray2 = new Tile[9];
    private Tile[] losingTileArray1 = new Tile[9];
    private Tile[] losingTileArray2 = new Tile[9];
    private Tile[] losingTileArray3 = new Tile[9];

    private int[] startingTileValues = {1, 4, 3, 7, 2, 5, 9, 8, 6};
    private int[] normalTileValues = {2, 4, 6, -1, 2, 0, 9, 7, 1};
    private int[] winningTileValues1 = {-1, -1, -1, -1, 11, -1, -1, -1, -1};
    private int[] winningTileValues2 = {-1, -1, -1, -1, 99999, -1, -1, -1, -1};
    private int[] losingTileValues1 = {1, -1, 1, -1, 1, -1, 1, -1, 1};
    private int[] losingTileValues2 = {-1, -1, -1, -1, -1, 5, -1, 4, -1};
    private int[] losingTileValues3 = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    /**
     * check that a model can be properly constructed and that it's intial values are correct
     */
    @Test
    public void testConstructor() {
        Model testModel = new Model();

        assertNull(testModel.puzzle);
        assertFalse(testModel.gameOver);
        assertNull(testModel.selectedTile);
    }

    /**
     * check that a model can properly register when the game is over, that being when the game has been won or lost
     */
    @Test
    public void testGameOver() {
        //set up the puzzles for the models
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                winningTileArray1[index] = new Tile(r, c, winningTileValues1[index]);
                winningTileArray2[index] = new Tile(r, c, winningTileValues2[index]);
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                normalTileArray[index] = new Tile(r, c, normalTileValues[index]);
                losingTileArray1[index] = new Tile(r, c, losingTileValues1[index]);
                losingTileArray2[index] = new Tile(r, c, losingTileValues2[index]);
                losingTileArray3[index] = new Tile(r, c, losingTileValues3[index]);
                index++;
            }
        }
        Puzzle winningPuzzle1 = new Puzzle();
        winningPuzzle1.setTiles(winningTileArray1);

        Puzzle winningPuzzle2 = new Puzzle();
        winningPuzzle2.setTiles(winningTileArray2);

        Puzzle nonGameOverPuzzle1 = new Puzzle();
        nonGameOverPuzzle1.setTiles(startingTileArray);

        Puzzle nonGameOverPuzzle2 = new Puzzle();
        nonGameOverPuzzle2.setTiles(normalTileArray);

        Puzzle losingPuzzle1 = new Puzzle();
        losingPuzzle1.setTiles(losingTileArray1);

        Puzzle losingPuzzle2 = new Puzzle();
        losingPuzzle2.setTiles(losingTileArray2);

        Puzzle losingPuzzle3 = new Puzzle();
        losingPuzzle3.setTiles(losingTileArray3);

        Model gameOverModel1 = new Model();
        gameOverModel1.setPuzzle(winningPuzzle1);

        Model gameOverModel2 = new Model();
        gameOverModel2.setPuzzle(winningPuzzle2);

        Model gameOverModel3 = new Model();
        gameOverModel3.setPuzzle(losingPuzzle1);

        Model gameOverModel4 = new Model();
        gameOverModel4.setPuzzle(losingPuzzle2);

        Model gameOverModel5 = new Model();
        gameOverModel5.setPuzzle(losingPuzzle3);

        Model nonGameOverModel1 = new Model();
        nonGameOverModel1.setPuzzle(nonGameOverPuzzle1);

        Model nonGameOverModel2 = new Model();
        nonGameOverModel2.setPuzzle(nonGameOverPuzzle2);

        assertTrue(gameOverModel1.gameOver());
        assertTrue(gameOverModel2.gameOver());
        assertTrue(gameOverModel3.gameOver());
        assertTrue(gameOverModel4.gameOver());
        assertTrue(gameOverModel5.gameOver());

        assertFalse(nonGameOverModel1.gameOver());
        assertFalse(nonGameOverModel2.gameOver());
    }

    /**
     * check that the puzzle value can be properly set
     */
    @Test
    public void testSetPuzzle() {
        Model testModel = new Model();
        Puzzle testPuzzle = new Puzzle();
        assertNull(testModel.puzzle);
        testModel.setPuzzle(testPuzzle);

        assertEquals(testPuzzle, testModel.puzzle);
        assertFalse(testModel.gameOver);
        assertNull(testModel.selectedTile);

        assertNotEquals(null, testModel.puzzle);
        assertNotEquals(true, testModel.gameOver);
        assertNotEquals("", testModel.selectedTile);
    }

    /**
     * check the getter function for the puzzle of the model
     */
    @Test
    public void testGetPuzzle() {
        Model testModel = new Model();
        Puzzle testPuzzle = new Puzzle();
        assertNull(testModel.getPuzzle());
        testModel.setPuzzle(testPuzzle);

        assertEquals(testPuzzle, testModel.getPuzzle());
        assertNotEquals(null, testModel.getPuzzle());
    }

    /**
     * check that the selected piece can be properly set
     */
    @Test
    public void testSetSelectedPiece() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                normalTileArray[index] = new Tile(r, c, normalTileValues[index]);
                index++;
            }
        }
        Puzzle testPuzzle = new Puzzle();
        testPuzzle.setTiles(normalTileArray);

        Model testModel = new Model();
        testModel.setPuzzle(testPuzzle);

        Tile t1 = normalTileArray[0];
        Tile t2 = normalTileArray[1];
        Tile t3 = normalTileArray[3];

        assertNull(testModel.selectedTile);

        testModel.setSelectedPiece(t1);

        assertEquals(t1, testModel.selectedTile);
        assertNotEquals(null, testModel.selectedTile);

        testModel.setSelectedPiece(t2);

        assertEquals(t2, testModel.selectedTile);
        assertNotEquals(t1, testModel.selectedTile);

        testModel.setSelectedPiece(t3);

        assertEquals(t3, testModel.selectedTile);
        assertNotEquals(t2, testModel.selectedTile);
    }

    /**
     * check that the selected piece can be cleared back to null
     */
    @Test
    public void testClearSelectedPiece() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                normalTileArray[index] = new Tile(r, c, normalTileValues[index]);
                index++;
            }
        }
        Puzzle testPuzzle = new Puzzle();
        testPuzzle.setTiles(normalTileArray);

        Model testModel = new Model();
        testModel.setPuzzle(testPuzzle);

        Tile t1 = normalTileArray[0];
        Tile t2 = normalTileArray[1];
        Tile t3 = normalTileArray[3];

        assertNull(testModel.selectedTile);

        testModel.setSelectedPiece(t1);

        assertEquals(t1, testModel.selectedTile);
        assertNotEquals(null, testModel.selectedTile);
        testModel.clearSelectedTile();

        assertNull(testModel.selectedTile);

        testModel.setSelectedPiece(t2);

        assertEquals(t2, testModel.selectedTile);
        assertNotEquals(null, testModel.selectedTile);
        testModel.clearSelectedTile();

        assertNull(testModel.selectedTile);
        testModel.setSelectedPiece(t3);

        assertNotEquals(null, testModel.selectedTile);
        testModel.clearSelectedTile();

        assertNull(testModel.selectedTile);
    }

    /**
     * check the getter for the selected piece
     */
    @Test
    public void testGetSelectedPiece() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                normalTileArray[index] = new Tile(r, c, normalTileValues[index]);
                index++;
            }
        }
        Puzzle testPuzzle = new Puzzle();
        testPuzzle.setTiles(normalTileArray);

        Model testModel = new Model();
        testModel.setPuzzle(testPuzzle);

        Tile t1 = normalTileArray[0];
        Tile t2 = normalTileArray[1];
        Tile t3 = normalTileArray[3];

        assertNull(testModel.getSelectedTile());

        testModel.setSelectedPiece(t1);

        assertEquals(t1, testModel.getSelectedTile());
        assertNotEquals(null, testModel.getSelectedTile());
        testModel.clearSelectedTile();

        assertNull(testModel.getSelectedTile());

        testModel.setSelectedPiece(t2);

        assertEquals(t2, testModel.getSelectedTile());
        assertNotEquals(null, testModel.getSelectedTile());
        testModel.clearSelectedTile();

        assertNull(testModel.getSelectedTile());
        testModel.setSelectedPiece(t3);

        assertNotEquals(null, testModel.getSelectedTile());
        testModel.clearSelectedTile();

        assertNull(testModel.getSelectedTile());

    }

    /**
     * check that the values of the puzzle in the model will be properly reset
     */
    @Test
    public void testResetPuzzle() {
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                normalTileArray[index] = new Tile(r, c, normalTileValues[index]);
                startingTileArray[index] = new Tile(r, c, startingTileValues[index]);
                index++;
            }
        }
        Puzzle testPuzzle = new Puzzle();
        testPuzzle.setTiles(normalTileArray);

        Puzzle startingPuzzle = new Puzzle();
        startingPuzzle.setTiles(startingTileArray);

        Model testModel = new Model();
        testModel.setPuzzle(testPuzzle);

        Tile t1 = normalTileArray[0];

        testModel.setPuzzle(testPuzzle);
        testModel.setSelectedPiece(t1);
        testModel.gameOver = true;


        assertEquals(t1, testModel.getSelectedTile());
        assertTrue(testModel.gameOver);
        assertEquals(testPuzzle, testModel.getPuzzle());

        assertNotEquals(null, testModel.getSelectedTile());
        assertNotEquals(false, testModel.gameOver);
        assertNotEquals(null, testModel.getPuzzle());

        testModel.resetPuzzle();

        for (int i = 0; i < 9; i++) {
            assertEquals(startingPuzzle.getTiles()[i].getTileValue(), testModel.getPuzzle().getTiles()[i].getTileValue());
            assertEquals(startingPuzzle.getTiles()[i].getRow(), testModel.getPuzzle().getTiles()[i].getRow());
            assertEquals(startingPuzzle.getTiles()[i].getColumn(), testModel.getPuzzle().getTiles()[i].getColumn());
        }
    }
}
