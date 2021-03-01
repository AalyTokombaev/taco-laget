package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Objects.Board;
import inf112.RoboRally.app.Objects.Player;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */


    Board board = new Board("Vault.tmx");
    Player player = new Player("P1", new Vector2(0,0), 0);

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
