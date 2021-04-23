package inf112.skeleton.app.GridTests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import inf112.skeleton.app.EmptyApplication;
import org.junit.Before;
import inf112.RoboRally.app.Grid.Grid;
import inf112.RoboRally.app.Grid.Board;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class GridTests {
    Grid grid;
    Board board;

    @Before
    public void setUp() throws Exception {
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        grid = new Grid();
        board = new Board("Vault.tmx");
    }

    @Test
    public void fillGridTest(){
        assertNotNull(grid.grid[2][8]);
        assertNotNull(grid.grid[9][11]);
        assertEquals(0, grid.grid[8][10].size());
    }
}
