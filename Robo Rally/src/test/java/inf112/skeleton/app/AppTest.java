package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Controlls;
import inf112.RoboRally.app.Objects.Board;
import inf112.RoboRally.app.Objects.Player;
import org.junit.Test;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    Controlls ctrl = new Controlls();
    Player player = new Player("P1", new Vector2(0,0), 0, ctrl);

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void CardInitializerShouldInit(){
        try {
            CardInitializer ci = new CardInitializer();
        } catch (IOException e) {
            System.out.println("uh");
        }
    }
}
