package inf112.skeleton.app;

import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.Utility.Controls2;
import inf112.RoboRally.app.Utility.GameLogic;
import inf112.RoboRally.app.Utility.MapManager;
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
    MapManager mapster = new MapManager();
    GameLogic logic = new GameLogic(player,mapster);
    Controls2 ctrl = new Controls2(player,logic);


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
