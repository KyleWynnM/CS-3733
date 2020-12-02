package controller;

import boundary.TileApp;
import entities.Model;

public class ResetPuzzleController {
    private Model model;
    private TileApp app;

    /**
     * constructor for ResetPuzzleController
     * @param m
     * @param app
     */
    public ResetPuzzleController(Model m, TileApp app) {
        this.model = m;
        this.app = app;
    }

    /**
     * reset the puzzle and refresh the display
     */
    public void reset() {
        model.resetPuzzle();
        app.repaint();
    }
}
