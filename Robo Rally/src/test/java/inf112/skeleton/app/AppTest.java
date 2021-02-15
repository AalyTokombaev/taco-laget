package inf112.skeleton.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.RoboRallyBeta;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    Player player = new Player(new Vector2(1,1), 0,10,3);

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void isThereAPlayer(){

        assertEquals(10, player.getHp());
    }

    @Test
    public void isThereAFlag(){}

    @Test
    public void isThereAGame(){

    }
    @Test
    public void doYouLoseHP(){
        player.setDamage(5);
        assertEquals(5, player.getHp());
    }

    @Test
    public void canYouWin(){
    }

    @Test
    public void canYouMove(){

    }
    @Test
    public void canYouLose(){

    }

}
