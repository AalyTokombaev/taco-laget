package inf112.skeleton.ObjectsTests;

import inf112.RoboRally.app.Objects.States;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class StatesTests {
    States states;

    @Before
    public void setUp() throws Exception {
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
