package inf112.RoboRally.app;

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
import inf112.RoboRally.app.Game.Board;
import inf112.RoboRally.app.Game.GameMechanics;
import inf112.RoboRally.app.Objects.Player;

/**
 * This class handles the camera and the rendering of objects in the Robo Rally game
 * More specifically, takes care of the initializing, rendering, resizing, disposing and taking inputs for the application
 */

public class RoboRallyBeta implements Screen {
    public boolean isGameRunning = true;

    private RoboRally game;
    public Board board;
    public GameMechanics gamez;
    public Player player;
    private final OrthogonalTiledMapRenderer renderer;
    private final OrthographicCamera camera;
    public Vector2 playerPosition;
    private int x, y;
    private final CardViewer cardViewer;
    private Controls ctrl;
    private InputMultiplexer inputMultiplexer;

    public RoboRallyBeta(RoboRally game) {
        this.game = game;

        // Start-pos for player
        x = 5;
        y = 1;
        game.batch = new SpriteBatch();
        game.font = new BitmapFont();
        game.font.setColor(Color.RED);

        gamez = new GameMechanics();
        board = new Board("Vault.tmx");
        TiledMap map = board.makeMap();

        ctrl = new Controls();
        player = new Player("P1", new Vector2(x, y), 0, ctrl);

        cardViewer = new CardViewer(game.batch, player);

        playerPosition = player.getPosition();
        board.playerLayer.setCell(x, y, player.getState());


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
    }



    @Override
    public void show() {
        // Take inputs from multiple sources
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(cardViewer.getStage());
        inputMultiplexer.addProcessor(ctrl);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }


    @Override
    public void render(float v) {
        camera.update();
        player.movement();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        cardViewer.draw();
        renderer.setView(camera);
        renderer.render();
        ctrl.update();
        updateBoard();

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
    public void updateBoard(){
        playerPosition = player.getPosition();
        board.playerLayer.setCell(x,y,null);
        player = gamez.Action(board,player);
        x = (int) playerPosition.x;
        y = (int) playerPosition.y;
        board.playerLayer.setCell(x,y, player.getState());
    }

}