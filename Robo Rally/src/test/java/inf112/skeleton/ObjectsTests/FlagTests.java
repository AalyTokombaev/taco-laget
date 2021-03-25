package inf112.skeleton.ObjectsTests;

import inf112.RoboRally.app.Objects.Flag;

import static org.junit.Assert.assertEquals;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
import org.junit.Test;


public class FlagTests {
    Flag flag;
    Vector2 pos;
    
    @Before
    public void setUp() {
        pos = new Vector2();
        flag = new Flag(1, pos);
    }

    @Test 
    public void getPosTest(){
        assertEquals(pos, flag.getPos());
    }

    @Test
    public void getIdTest(){
        assertEquals(1, flag.getId());
    }
}
