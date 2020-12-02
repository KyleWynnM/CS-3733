package boundary;

import controller.ExitGameController;
import controller.MoveTileController;
import controller.ResetPuzzleController;
import controller.SelectTileController;
import entities.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class TileApp extends JFrame {
    //pre-assign the operations for readability
    private final int add = 0;
    private final int subtract = 1;
    private final int multiply = 2;
    private final int divide = 3;

    private JPanel gameWindow;

    PuzzlePanel panel;

    Model model;

    private JButton leftButton;
    private JButton rightButton;
    private JButton downButton;
    private JButton upButton;
    private JButton resetButton;
    private JButton quitButton;

    /**
     * make a special case to write over the JPanel with the PuzzlePanel
     */
    private void createUIComponents() {
        panel = new PuzzlePanel(model);
    }

    /**
     * getter for puzzlepanel
     * @return panel
     */
    public PuzzlePanel getPuzzlePanel() {
        return panel;
    }

    /**
     * create all the listeners the extra features left for the game
     * @param m
     */
    public TileApp(Model m) {
        super();
        this.model = m;
        this.model.resetPuzzle();
        setTitle("3x3 Math Tile Game");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 558, 464);

        gameWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(gameWindow);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { new SelectTileController(model, TileApp.this).process(e.getPoint()); }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new ResetPuzzleController(model, TileApp.this).reset(); }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new ExitGameController(TileApp.this).exit(); }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new MoveTileController(model, TileApp.this).move(subtract); }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new MoveTileController(model, TileApp.this).move(add); }
        });

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new MoveTileController(model, TileApp.this).move(multiply); }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new MoveTileController(model, TileApp.this).move(divide); }
        });
    }
}
