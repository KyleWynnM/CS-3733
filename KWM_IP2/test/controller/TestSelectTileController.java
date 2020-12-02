package controller;

import entities.Coordinate;
import org.junit.Test;

import java.awt.*;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class TestSelectTileController extends AppTestCase {
    /**
     * testProcess ensures that tiles can be selected with the selectTileController
     * @throws InterruptedException
     */
    @Test
    public void testProcess() throws InterruptedException {
        //
        SelectTileController stc = new SelectTileController(model, app);
        Point p = coordinateToPoint(new Coordinate(1, 1));
        stc.process(p);
        sleep(100);
        assertEquals(new Coordinate(1, 1), app.getPuzzlePanel().pointToCoordinate(p));
        assertEquals(2, this.model.getPuzzle().getTiles()[4].getTileValue());
    }
}