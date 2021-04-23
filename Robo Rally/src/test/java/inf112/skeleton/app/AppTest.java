package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.CardInitializer;
<<<<<<< HEAD
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.Utility.PlayerControls;
=======
import inf112.RoboRally.app.Controls;
import inf112.RoboRally.app.Objects.Player;

import org.junit.Before;
>>>>>>> origin/tests
import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    Controls ctrl = new Controls();
    Player player;

    @Before
    public void setUp(){
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        player = new Player("P1", new Vector2(0,0), 0, ctrl);
    }
    
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
