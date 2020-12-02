package controller;

import boundary.TileApp;
import entities.Model;

import java.util.Arrays;

public class MoveTileController {
    private Model model;
    private TileApp app;

    /**
     * constructor for MoveTileController
     * @param m
     * @param app
     */
    public MoveTileController(Model m, TileApp app) {
        this.model = m;
        this.app = app;
    }

    /**
     * try to move a tile
     * @param op the direction (operation) that is being attempted
     * @return true if the move was sucessful, false if not
     */
    public boolean move(int op) {
        //if no model is given, move can't be done
        if (model.getSelectedTile() == null) { return false; }

        //if no tile is present, move can't be done
        if (model.getSelectedTile().getTileValue() == -1) { return false; }

        //if the game is over, the move can't be done
        if (model.gameOver()) { return false; }

        //check if it's a valid move and if so, move it
        if (model.getPuzzle().isValidMove(op, Arrays.asList(model.getPuzzle().getTiles()).indexOf(model.getSelectedTile()))) {
            model.getPuzzle().makeMove(op, Arrays.asList(model.getPuzzle().getTiles()).indexOf(model.getSelectedTile()));
        }
        //reset the selected tile
        model.setSelectedPiece(null);
        //refresh display
        app.repaint();
        return true;
    }
}