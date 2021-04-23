package inf112.skeleton.app;

import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Player.Player;
import org.junit.Before;
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
    Player player;

    @Before
    public void setUp(){
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        player = new Player();
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
