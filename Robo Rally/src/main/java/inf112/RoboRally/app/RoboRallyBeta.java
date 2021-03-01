package inf112.RoboRally.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.HUD.CardViewer;
import inf112.RoboRally.app.Objects.Board;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.Objects.gameMech;


public class RoboRallyBeta extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    public Board board;
    public gameMech game;
    //TODO should player med moved out
    public Player player;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    public Vector2 playerPosition;
    private int x,y;
    private CardViewer cardViewer;

    @Override
    public void create() {
        //Start-pos for player
        x = 0;
        y = 0;
        batch = new SpriteBatch();
        cardViewer = new CardViewer(batch);
        font = new BitmapFont();
        font.setColor(Color.RED);

        board = new Board("Vault.tmx");
        TiledMap map = board.makeMap();

        //TODO
        player = new Player("P1",new Vector2(x,y),0);
        playerPosition = player.getPosition();
        board.playerLayer.setCell(x,y,player.getState());
        game = new gameMech();

        // camera setup
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 15);
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

        cardViewer.draw();

        /*TODO This needs to be done differently
         * Maybe move the check out of render? :s
         *
         * */
        camera.update();
        renderer.setView(camera);
        renderer.render();

    }

    @Override
    public void resize(int width, int height) {
        cardViewer.resize(width,height);

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
        System.out.println(i);
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
        //calls the game-object
        player = game.Action(board,player);
        x = (int) playerPosition.x;
        y = (int) playerPosition.y;
        // update player position
        board.playerLayer.setCell(x, y, player.getState());
        return true;
    }

}
