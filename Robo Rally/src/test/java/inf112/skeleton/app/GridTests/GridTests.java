package inf112.skeleton.app.GridTests;

import org.junit.Before;
import inf112.RoboRally.app.Grid.Grid;
import inf112.RoboRally.app.Grid.Board;

public class GridTests {
    Grid grid;
    Board board;

    @Before
    public void setUp() throws Exception {
        grid = new Grid();
        board = new Board("Vault.tmx");

    }
}
