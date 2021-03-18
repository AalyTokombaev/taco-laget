package inf112.RoboRally.app;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.HUD.CardViewer;
import inf112.RoboRally.app.Multiplayer.GameClient;
import inf112.RoboRally.app.Multiplayer.GameServer;
import inf112.RoboRally.app.Objects.Board;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.Objects.GameMechanics;

/**
 * This class handles the camera and the rendering of objects in the Robo Rally game
 * More specifically, takes care of the initializing, rendering, resizing, disposing and taking inputs for the application
 */

public class RoboRallyBeta extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    public Board board;
    public GameMechanics game;
    //TODO should player med moved out
    public Player player;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    public Vector2 playerPosition;
    private int x, y;
    private CardViewer cardViewer;

    // multiplayer start
    private GameServer server;
    private GameClient client;
    // multiplayer end

    /**
     * Initializes and creates all needed assets for rendering
     * Sets up camera
     * Creates InputMultiplexer to handle multiple input sources
     */
    @Override
    public void create() {

        // Start-pos for player
        x = 2;
        y = 0;

        //******************
        // Multiplayer stuff start
        server = new GameServer();
        client = new GameClient();

        server.host();
        client.connect("localhost", 1337);
        System.out.println(client.id);
        player = new Player("P1", new Vector2(x + client.id, y), 0);
        // Multiplayer stuff end
        //******************



        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        board = new Board("Vault.tmx");
        TiledMap map = board.makeMap();

        // player = new Player("P1", new Vector2(x, y), 0);
        cardViewer = new CardViewer(batch, player);
        playerPosition = player.getPosition();
        board.playerLayer.setCell(x, y, player.getState());
        game = new GameMechanics();

        // Camera setup
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 18.8f);
        camera.position.x = 6F; // Centers camera
        camera.update();

        // Render setup
        float size = (float) 1.0 / 300.0f;
        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);

        // Take inputs
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(cardViewer.getStage());
        Gdx.input.setInputProcessor(inputMultiplexer);



    }

    /**
     * Gets rid of textures to free up memory space
     */
    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        cardViewer.dispose();
    }

    /**
     * Renders the game and draws the CardViewer
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        cardViewer.draw();
        camera.update();
        renderer.setView(camera);
        renderer.render();
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
    public boolean keyDown(int i) {
        return false;
    }

    /**
     * Enables the arrow keys to move the Player
     *
     * @param i is a numerical value of the key pressed
     * @return true
     */
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
        player = game.Action(board, player);
        x = (int) playerPosition.x;
        y = (int) playerPosition.y;
        // update player position
        board.playerLayer.setCell(x, y, player.getState());
        return true;
    }

}
