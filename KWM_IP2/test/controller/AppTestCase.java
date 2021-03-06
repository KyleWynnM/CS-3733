package controller;

import boundary.PuzzlePanel;
import boundary.TileApp;
import entities.Coordinate;
import entities.ModelTestCase;
import org.junit.After;
import org.junit.Before;

import java.awt.*;

public class AppTestCase extends ModelTestCase {

    protected TileApp app;

    @Before
    public void createApp() {
        app = new TileApp(model);
        app.setVisible(true);
    }

    @After
    public void tearDown() throws Exception {
        app.setVisible(false);
    }

    /**
     * Map a Coordinate in puzzle to mouse point at center of square.
     *
     * @param  c       Desired Coordinate.
     * @return Point   Associated with the center of a square with given coordinate.
     */
    public static Point coordinateToPoint(Coordinate c) {
        return new Point(c.col * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2, c.row * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2);
    }
}
