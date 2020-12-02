import boundary.TileApp;
import controller.ExitGameController;
import entities.Model;
import entities.Puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        //set up the game before it starts
        Model m = new Model();

        Puzzle puzzle = new Puzzle();

        m.setPuzzle(puzzle);

        TileApp app = new TileApp(m);

        //quit the game if the window is closed
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                new ExitGameController(app).exit();
            }
        });

        app.setVisible(true);
    }
}