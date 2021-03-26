package inf112.skeleton.app;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.Grid.Board;
import inf112.RoboRally.app.Utility.GameLogic;
import inf112.RoboRally.app.Utility.PlayerControls;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    private Player player;
    private PlayerControls ctrl;
    private Board board;
    private GameLogic logic;

    @Before
    public void setUp() {
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        board = new Board("Vault2.tmx");
        this.player = new Player();
        this.ctrl = new PlayerControls(player,logic);
        logic = new GameLogic(player,board);

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
/*
   @Test
    public void isOrderOfFlagsCorrectTest(){
       Flag flag = new Flag(1, new Vector2());
       assertTrue(player.visitFlag(flag));
   }
*/
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
        assertEquals(10, player.getHp());
    }

    @Test
    public void canPlayerDieFromDamageTest(){
        if (!(player.getHp() == 10))
        if (player.getHp() != 10)
            player.setHP(10);
        if (player.getLifeTokens() != 3)
            player.setLifeTokens(3);

        player.setDamage(10);
        player.setHP(10);

        player.setDamage(10);
        player.setHP(10);

        player.setDamage(10);
        assertFalse(player.isAlive());
    }

}
