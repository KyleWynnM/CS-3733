package controller;

import boundary.TileApp;

public class ExitGameController {
    private TileApp app;

    /**
     * constructor for ExitGameController
     * @param app
     */
    public ExitGameController(TileApp app) {
        this.app = app;
    }

    /**
     * get rid of the app
     */
    public void exit() {
        app.setVisible(false);
        app.dispose();
    }
}