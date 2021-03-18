package inf112.skeleton.app;

import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Controller;
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
    Player player = new Player();
    Controller ctrl = new Controller(player);


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
