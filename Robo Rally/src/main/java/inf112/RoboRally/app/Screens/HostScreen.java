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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.CardViewer;
import inf112.RoboRally.app.Grid.Board;
import inf112.RoboRally.app.Multiplayer.GameServer;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.GameLogic;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.util.ArrayList;

/**
 * This class handles the camera and the rendering of objects in the Robo Rally game
 * More specifically, takes care of the initializing, rendering, resizing, disposing and taking inputs for the application
 */

public class HostScreen implements Screen {


    private RoboRally game;
    public Board board;
    public Player player;
    private final OrthogonalTiledMapRenderer renderer;
    private final OrthographicCamera camera;
    public Vector2 playerPosition;
    private CardViewer cardViewer;
    private InputMultiplexer inputMultiplexer;

    private TiledMap map;

    private final PlayerControls ctrl;
    private final GameLogic logic;

    ArrayList<Player> players;
    Player player2;

    boolean isHost;
    boolean isClient;
    GameServer server;
    int clientX, clientY;
    TiledMapTileLayer.Cell clientState;


    public HostScreen(RoboRally game) {
        this.game = game;
        board = new Board("Vault2.tmx");
        map = board.makeMap();

        game.batch = new SpriteBatch();
        game.font = new BitmapFont();
        game.font.setColor(Color.RED);

        player = new Player();

        logic = new GameLogic(player,board);
        ctrl = new PlayerControls(player,logic);
        cardViewer = new CardViewer(game.batch, player);
        //if(cardViewer.player.getHp() != player.getHp())

        players = new ArrayList<>();
        players.add(player);

        isClient = false;
        isHost = false;

        server = new GameServer(game, player);


        playerPosition = player.getPosition();

        //board.playerLayer.setCell(x, y, player.getState());
        // for (Player p: players){board.playerLayer.setCell(p.);}


        // Camera setup
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 18.8f);
        camera.position.x = 6F; // Centers camera
        camera.update();

        // Render setup
        float size = (float) 1.0 / 300.0f;
        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);
        multiPlayer();

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
        inputMultiplexer.addProcessor(ctrl);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void multiPlayer() {

        System.out.println("t pressed");
        System.out.println("hosting");
        isHost = true;
        server.host();
        board.playerLayer.setCell(0, 0, null);
        clientX = clientY = 0;

    }
    public void call(){
        board.playerLayer.setCell(clientX, clientY, null);
        server.askForData();
        clientX = server.clientX;
        clientY = server.clientY;
        clientState = server.clientState;
        //board.playerLayer.setCell(clientX, clientY, player.getState());
        board.playerLayer.setCell(clientX, clientY, clientState);
        }



    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        logic.clearPlayer();

        ctrl.update();

        if(v > 0.2){
            logic.update();
            call();
            cardViewer.updateLifeTokens();
            cardViewer.updateDamageTokens();
            // System.out.println("render tick");
        }

        logic.setPlayer();

        camera.update();
        cardViewer.draw();
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
    public void hide() {

    }

}