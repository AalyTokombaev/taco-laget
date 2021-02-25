package inf112.skeleton.app;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Objects.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        this.player = new Player("testPlayer", new Vector2(), 0);


    }
    @Test
    public void isPlayerHP10AtBeginningTest(){
        assertEquals(10, player.getHp());
    }


}
