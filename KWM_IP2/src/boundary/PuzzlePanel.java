package boundary;

import entities.Coordinate;
import entities.Model;
import entities.Puzzle;
import entities.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PuzzlePanel extends JPanel {

    Model model;
    //set size of every tile
    public static final int boxSize = 80;
    //set size in between
    public static final int offset = 2;

    /**
     * Constructor for the PuzzlePanel class
     * @param m
     */
    public PuzzlePanel(Model m) {
        this.model = m;
    }

    /**
     * computeRectangle designs the size and placement for each tile
     * @param t: the tile that will have a rectangle drawn for it
     * @return rect: the rectangle that represents a tile on the game
     */
    public Rectangle computeRectangle (Tile t) {
        //get the spot of the tile
        int col = t.getColumn();
        int row = t.getRow();

        //create the tile
        Rectangle rect = new Rectangle(col*boxSize + offset, row*boxSize + offset, boxSize - 2*offset, boxSize - 2*offset);
        return rect;
    }

    /**
     * pointToCoordinate converts points to the coordinate to help figure out which tile will be worked with
     * @param p
     * @return
     */
    public Coordinate pointToCoordinate(Point p) {
        return new Coordinate(p.x/boxSize, p.y/boxSize);
    }

    /**
     * paintComponent paints over the PuzzlePanel to give the look of the 3x3 tile game, with appropriate reactions
     * and celebrations
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (model == null) { return; }

        Tile selectedTile = model.getSelectedTile();
        Puzzle puzzle = model.getPuzzle();
        int tileRow = 0;
        int tileCol = 0;
        Rectangle r;
        Color tileColor;

        //set the color of the center tile based on whether or not there is a current win or loss
        if (puzzle.inWinState()) {
            tileColor = Color.green;
        } else if (puzzle.inLoseState()) {
            tileColor = Color.red;
        } else {
            tileColor = Color.gray;
        }

        //loop through every tile and paint the appropriate color and text over it
        for (Tile t : puzzle.getTiles()) {
            //if it's the center tile, give it the appropriate color as assigned before
            if (tileCol == 1 && tileRow == 1) {
                g.setColor(tileColor);
            } else {
                g.setColor(Color.gray);
            }

            //set to dark gray for the selected tile, and light gray for the empty tiles
            if (t.getTileValue() == -1) {
                g.setColor(Color.lightGray);
            } else if (t.equals(selectedTile)) {
                g.setColor(Color.darkGray);
            }

            //draw the rectangle
            r = computeRectangle(t);
            g.fillRect(r.x, r.y, r.width, r.height);

            //if the tile has a value, write on the tile
            g.setColor(Color.black);
            if (t.getTileValue() != -1) {
                g.drawString(Integer.toString(t.getTileValue()), 36 + (80 * tileCol), 45 + (80 * tileRow));
            }

            tileCol++;
            if (tileCol > 2) {
                tileCol = 0;
                tileRow++;
            }
        }

        //congratulate the user with confettiPuz with a win, console them with a sad face if they lose
        if (puzzle.inWinState()) {
            BufferedImage confetti = null;
            try {
                confetti = ImageIO.read(new File("src/confetti.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(confetti, 0, 0, 240, 240, null);
            g.setColor(Color.black);
            g.drawString("Congratulations! You won!", 36, 255);
        } else if (puzzle.inLoseState()) {
            BufferedImage sadFace = null;
            try {
                sadFace = ImageIO.read(new File("src/sadFace.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(sadFace, 80, 80, 80, 80, null);
            g.setColor(Color.black);
            g.drawString("I'm sorry, you lost. Try again!", 36, 255);
        }
    }
}