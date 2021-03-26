package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.Utility.PlayerControls;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */


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
