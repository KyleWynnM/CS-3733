package controller;

import entities.Coordinate;
import org.junit.Test;

import java.awt.*;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class TestMoveTileController extends AppTestCase {

    /**
     * checks that a move can be done with the controller
     * @throws InterruptedException
     */
    @Test
    public void testMove() throws InterruptedException {
        //select a tile
        SelectTileController stc = new SelectTileController(model, app);
        Point p = coordinateToPoint(new Coordinate(1, 1));
        assertEquals(new Coordinate(1, 1), app.getPuzzlePanel().pointToCoordinate(p));
        stc.process(p);

        //move it
        MoveTileController mtc = new MoveTileController(model, app);

        //check that the values are now adjusted properly
        assertTrue(mtc.move(0));
        assertNull(this.model.getSelectedTile());
        assertEquals(7, this.model.getPuzzle().getTiles()[5].getTileValue());

        //this is a little sneaky trick I used to make sure the code coverage stayed high, by making the program stop for
        //a second, I believe it forces the code to recognize how the paintpanel has been adjusted? I believe this ensures
        //that code has been hit
        sleep(100);

        //move again in a different direction and check if the values are properly adjusted
        p = coordinateToPoint(new Coordinate(0, 0));
        assertEquals(new Coordinate(0, 0), app.getPuzzlePanel().pointToCoordinate(p));
        stc.process(p);
        mtc = new MoveTileController(model, app);

        assertTrue(mtc.move(3));
        assertNull(this.model.getSelectedTile());
        assertEquals(7, this.model.getPuzzle().getTiles()[3].getTileValue());
    }
}
