package inf112.skeleton.app.GameTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import inf112.skeleton.app.EmptyApplication;
import org.junit.Before;
import org.junit.Test;
import inf112.RoboRally.app.Grid.Board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import inf112.skeleton.app.EmptyApplication;
import static org.mockito.Mockito.mock;


public class BoardTests {
    Board board;

    @Before
    public void setUp(){
        Gdx.gl = mock(GL20.class);
        new HeadlessApplication(new EmptyApplication());
        board = new Board("Vault.tmx");

    }

    @Test
    public void getNameTest(){
        assertEquals("Vault.tmx", board.getName());
    }
}
