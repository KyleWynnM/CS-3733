package controller;

import boundary.TileApp;
import entities.Coordinate;
import entities.Model;
import entities.Puzzle;
import entities.Tile;

import java.awt.*;

public class SelectTileController {
    private Model model;
    private TileApp app;

    /**
     * constructor for selectTileController
     * @param m
     * @param app
     */
    public SelectTileController(Model m, TileApp app) {
        this.model = m;
        this.app = app;
    }

    /**
     * take the point and select a tile based off where the point was, then refresh display
     * @param point
     */
    public void process(Point point) {
        Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
        Puzzle puzzle = model.getPuzzle();
        for (Tile t: puzzle) {
            if (t.contains(c)) {
                model.clearSelectedTile();
                model.setSelectedPiece(t);
                app.repaint();
            }
        }
    }
}