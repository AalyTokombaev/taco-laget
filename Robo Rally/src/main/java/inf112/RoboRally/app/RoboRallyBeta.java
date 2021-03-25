package inf112.RoboRally.app;

import com.badlogic.gdx.*;
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
import inf112.RoboRally.app.Game.Board;
import inf112.RoboRally.app.Game.GameMechanics;
import inf112.RoboRally.app.Multiplayer.GameClient;
import inf112.RoboRally.app.Multiplayer.GameServer;
import inf112.RoboRally.app.Objects.Player;

import java.util.ArrayList;

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

    ArrayList<Player> players;
    Player player2;

    boolean isHost;
    boolean isClient;

    GameServer server;
    GameClient client;

    private int id;

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


        players = new ArrayList<>();
        players.add(player);

        isClient = false;
        isHost = false;


        server = new GameServer(game, ctrl);
        client = new GameClient(game, ctrl);

        cardViewer = new CardViewer(game.batch, player);

        playerPosition = player.getPosition();
        board.playerLayer.setCell(x, y, player.getState());
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
        if (ctrl.isKeyPressed(Input.Keys.T) && !isHost){
            System.out.println("t pressed");
            System.out.println("hosting");
            isHost = true;
            server.host();
            server.askForData();
            players.remove(0);
            players.add(new Player("Host", new Vector2(5, 1), 0, ctrl));
            players.add(new Player("Client", new Vector2(server.clientX, server.clientY), 0, new Controls()));
            player.put(5, 1);
            // server.setPlayer(players.get(server.id));
            // board.playerLayer.setCell(server.player.getx(), server.player.gety(), server.player.getState());
        }
        if (ctrl.isKeyDown(Input.Keys.J) && !isClient && !isHost) {
            System.out.println("j pressed");
            System.out.println("connecting");
            isClient = true;
            players.remove(0);
            players.add(new Player("Client", new Vector2(6, 1),0, ctrl));
            client.connect("localhost", 1337);
            client.askForData();
            players.add(new Player("Host", new Vector2(client.hostX, client.hostY), 0, new Controls()));
            // player.put(6, 1);
            // client.setPlayer(players.get(1));
            // board.playerLayer.setCell(client.player.getx(), client.player.gety(), client.player.getState());

        }
        if (isClient) {
            client.askForData();
            int hostX = client.hostX;
            int hostY = client.hostY;
            TiledMapTileLayer.Cell hostState = client.hostState;
            board.playerLayer.setCell(hostY, hostX, hostState);


        }

        if (isHost) {
            server.askForData();
            int clientX = server.clientX;
            int clientY = server.clientY;
            TiledMapTileLayer.Cell clientState = server.clientState;
            board.playerLayer.setCell(clientX, clientY, clientState);

        }

        // player.movement();
            for (Player p : players) {
                p.movement();
            }
        camera.update();
        //player.movement();


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