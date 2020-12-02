package entities;

import org.junit.Before;

import java.util.Optional;

public class ModelTestCase {
    protected Model model;

    protected Optional<Tile> getTile(Coordinate c) {
        for (Tile t : model.getPuzzle()) {
            if (t.contains(c)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    @Before
    public void setUp() {
        model = new Model();
        Puzzle puzzle = new Puzzle();
        Tile[] startingTiles = new Tile[9];
        int[] startingTileValues = {1, 4, 3, 7, 2, 5, 9, 8, 6};
        int index = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                startingTiles[index] = new Tile(r, c, startingTileValues[index]);
                index++;
            }
        }
        puzzle.setTiles(startingTiles);
        model.setPuzzle(puzzle);
    }
}
