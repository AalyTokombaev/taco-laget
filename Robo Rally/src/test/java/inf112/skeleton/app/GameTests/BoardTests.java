package inf112.skeleton.app.GameTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import inf112.RoboRally.app.Game.Board;

public class BoardTests {
    Board board;

    @Before
    public void setUp(){
        board = new Board("Vault.tmx");
    }

    @Test
    public void getNameTest(){
        assertEquals("Vault.tmx", board.getName());
    }
}
