package inf112.skeleton.ObjectsTests;

import inf112.RoboRally.app.Objects.States;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertNotNull;
import inf112.skeleton.app.EmptyApplication;

import org.junit.Before;
import org.junit.Test;

public class StatesTests {
    States states;

    @Before
    public void setUp() throws Exception {
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        this.states = new States();
    }

    @Test
    public void aliveTest(){
        assertNotNull(states.alive());
    }

    @Test
    public void deadTest(){
        assertNotNull(states.dead());
    }

    @Test
    public void winTest(){
        assertNotNull(states.win());
    }
}
