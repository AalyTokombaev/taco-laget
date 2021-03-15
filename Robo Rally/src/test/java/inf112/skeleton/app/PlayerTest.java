package inf112.skeleton.app;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Controlls;
import inf112.RoboRally.app.Objects.Flag;
import inf112.RoboRally.app.Objects.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    private Player player;
    private Controlls ctrl;

    @Before
    public void setUp() {
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        this.ctrl = new Controlls();
        this.player = new Player("testPlayer", new Vector2(), 0, ctrl);

    }

    @Test
    public void isPlayerHP10AtBeginningTest(){
        assertEquals(10, player.getHp());
    }


    @Test
    public void isXAmountDamageWithdrawnTest(){
        player.setDamage(5);
        assertEquals(5, player.getHp());

    }

    @Test
    public void isDamageTakenMoreThan10ThenLooseOneLifeTokenTest(){
        player.setDamage(11);
        assertEquals(2, player.getLifeTokens());
    }

    @Test
    public void isHPRenewedTo10When0Test(){
        player.setDamage(10);
        assertEquals(10, player.getHp());

    }

   @Test
    public void isOrderOfFlagsCorrectTest(){
       Flag flag = new Flag(1, new Vector2());
       assertTrue(player.visitFlag(flag));
   }

    @Test
    public void canPlayerTakeDamageTest(){
        assertEquals(10, player.getHp());
        player.setDamage(5);
        assertEquals(5, player.getHp());
    }

    @Test
    public void repairPlayerTest(){
        player.setHP(10);
        player.setDamage(5);
        // player.repair();

        //assertEquals(10, player.getHp());
    }

    @Test
    public void canPlayerDieFromDamageTest(){
        /*
        player.setLifeTokens(3);
        player.repair();

        player.setDamage(10);
        player.repair()

        player.setDamage(10);
        player.repair()

        player.setDamage(10);
        player.repair()

        assertFalse(player.isAlive());

         */
    }

}
