package inf112.RoboRally.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.CardViewer;
import inf112.RoboRally.app.Grid.Board;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.GameLogic;
import inf112.RoboRally.app.Utility.ControlInterp;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * This class handles the camera and the rendering of objects in the Robo Rally game
 * More specifically, takes care of the initializing, rendering, resizing, disposing and taking inputs for the application
 */

public class RoboRallyBeta implements Screen {

    private RoboRally game;
    public Board board;

    public Player player;
    private final OrthogonalTiledMapRenderer renderer;
    private final OrthographicCamera camera;
    public Vector2 playerPosition;
    private CardViewer cardViewer;
    private InputMultiplexer inputMultiplexer;

    private TiledMap map;

    private final GameLogic logic;



    ControlInterp test;
    Boolean go = false;


    public RoboRallyBeta(RoboRally game) {
        this.game = game;
        board = new Board("Vault2.tmx");
        map = board.makeMap();

        game.batch = new SpriteBatch();
        game.font = new BitmapFont();
        game.font.setColor(Color.RED);

        player = new Player();

        logic = new GameLogic(player,board);
        cardViewer = new CardViewer(game.batch, player);

        test = new ControlInterp(player,logic);

        playerPosition = player.getPosition();


        // Camera setup
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 18.8f);
        camera.position.x = 6F; // Centers camera
        camera.update();

        // Render setup
        float size = (float) 1.0 / 300.0f;
        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);
    }

    /**
     * Gets rid of textures to free up memory space
     */
    @Override
    public void dispose() {
        game.batch.dispose();
        game.font.dispose();
        cardViewer.dispose();
        renderer.dispose();
    }

    @Override
    public void show() {
        // Take inputs from multiple sources
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(cardViewer.getStage());
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        System.out.println("render tick");
        updater(v);
        camera.update();
        cardViewer.draw();
        renderer.setView(camera);
        renderer.render();

    }

    public void updater(float v){

        logic.clearPlayer();
        if(player.getDeck().getCards().size() >= 5){
            go = true;
        }

        //System.out.println(player.getDeck().getCards().size());
        if (v > 0.3) {
            try {
                sleep(1000);
                test.translateMovement(go);
                logic.update();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cardViewer.updateLifeTokens();
        cardViewer.updateDamageTokens();

        if(player.getDeck().getCards().empty()){
            go = false;

        }
        logic.setPlayer();
    }


    /**
     * Resizes the game contents in correlation to resizing of application window
     *
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        cardViewer.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

}