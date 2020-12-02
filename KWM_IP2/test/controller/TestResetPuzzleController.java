package controller;

import entities.Coordinate;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestResetPuzzleController extends AppTestCase {
    /**
     * testReset ensures that the reset can be performed with the reset controller
     */
    @Test
    public void testReset() {
        //move a tile
        SelectTileController stc = new SelectTileController(model, app);
        Point p = coordinateToPoint(new Coordinate(1, 1));
        assertEquals(new Coordinate(1, 1), app.getPuzzlePanel().pointToCoordinate(p));
        stc.process(p);
        MoveTileController mtc = new MoveTileController(model, app);
        //check that it has been moved
        assertTrue(mtc.move(0));
        assertNull(this.model.getSelectedTile());
        assertEquals(7, this.model.getPuzzle().getTiles()[5].getTileValue());

        //reset the puzzle and check that it's back to the original configuration
        ResetPuzzleController rpc = new ResetPuzzleController(model, app);
        rpc.reset();
        assertEquals(2, this.model.getPuzzle().getTiles()[4].getTileValue());
        assertEquals(5, this.model.getPuzzle().getTiles()[5].getTileValue());
    }
}
