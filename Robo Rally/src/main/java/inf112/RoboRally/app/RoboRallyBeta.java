package inf112.RoboRally.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Objects.Board;
import inf112.RoboRally.app.Objects.Player;


public class RoboRallyBeta extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    public Board board;
    private TiledMap map;

    private Player player;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private Vector2 playerPosition;
    private int x,y;

    @Override
    public void create() {
        //Start-pos for player
        x = 0;
        y = 0;

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        board = new Board("Vault.tmx");
        map = board.makeMap();

        player = new Player("P1",new Vector2 (x,y), 0,10,3) ;
        playerPosition = player.getPosition();
        player.setAlive();
        board.playerLayer.setCell(x,y,player.getState());


        // camera setup
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.position.x = 6F; // sentrerer camera
        camera.update();


        // render setup
        float size = (float) 1.0 / 300.0f;
        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);

        // take inputs
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        //flytter disse ut for mer oversikt?

        x = (int) playerPosition.x;
        y = (int) playerPosition.y;

        if (board.holeLayer.getCell(x, y) != null) {
            player.setDamage(10);
            //player.setDead();
            //board.playerLayer.setCell(x, y, player.getState());
        }
        if (board.flagLayer.getCell(x, y) != null) {
            player.setScore(1);
            //player.setWinning();
            //board.playerLayer.setCell(x, y, player.getState());
        }

        board.playerLayer.setCell(x, y, player.getState());


        camera.update();
        renderer.setView(camera);
        renderer.render();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        // get the last player position
        playerPosition = player.getPosition();

        // update player position accordingly
        if (i == Input.Keys.UP) {
            player.setPosition(0, 1);
        }
        if (i == Input.Keys.DOWN) {
            player.setPosition(0, -1);
        }
        if (i == Input.Keys.RIGHT) {
            player.setPosition(1, 0);
        }
        if (i == Input.Keys.LEFT) {
            player.setPosition(-1, 0);
        }
        // set the last player position to null
        board.playerLayer.setCell(x, y, null);
        x = (int) playerPosition.x;
        y = (int) playerPosition.y;
        // update player position
        board.playerLayer.setCell(x, y, player.getState());
        return true;
    }


    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

}
