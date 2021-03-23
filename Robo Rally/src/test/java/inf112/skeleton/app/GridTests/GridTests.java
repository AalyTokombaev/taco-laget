package inf112.skeleton.app.GridTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import inf112.RoboRally.app.Grid.Grid;
import inf112.RoboRally.app.Game.Board;

public class GridTests {
    Grid grid;
    Board board;

    @Before
    public void setUp() throws Exception {
        grid = new Grid();
        board = new Board("Vault.tmx");
    }
}
