package inf112.RoboRally.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.RoboRally.app.HUD.TestUI;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.Controls2;
import inf112.RoboRally.app.Utility.GameLogic;
import inf112.RoboRally.app.Utility.MapManager;


public class LiveScreen implements Screen {

    private final RoboRally parent;
    private final Stage stage;
    private OrthographicCamera camera = null;
    private OrthogonalTiledMapRenderer renderer = null;
    private final TiledMap map;
    private final MapManager mapManager;
    private final Player player;
    private final Sprite avatar;
    //private Controlls ctrl;
    private final Controls2 ctrl;
    //private final CardViewer cardViewer;
    //private TiledMapTileLayer holeLayer;
    private final GameLogic logic;
    //private final CardViewer cardViewer;
    private final TestUI cardViewer;
    private TextureRegion avatar1;
    private InputMultiplexer inputMultiplexer;


    //TODO FFS hvordan skru av render@ mousemovment -_-

    public LiveScreen(RoboRally roboRally) {

        parent = roboRally;

        stage = new Stage(new ScreenViewport());

        parent.batch = new SpriteBatch();
        parent.font = new BitmapFont();
        parent.font.setColor(Color.RED);

        mapManager = new MapManager();
        mapManager.loadMap("VAULT2");

        map = mapManager.getCurrentMap();

        //ctrl = new Controlls();

        player = new Player();
        logic = new GameLogic(player, mapManager);
        //cardViewer = new CardViewer(parent.batch, player);
        ctrl = new Controls2(player, logic);

        cardViewer = new TestUI(parent.batch, player);
        cardViewer.initDeck();
        //Vector2 test = new Vector2();
        //test.lerp(nextPlayerPos,0.5);

        //holeLayer = (TiledMapTileLayer) mapManager.getHoleLayer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 18.8F);
        camera.position.x = 6F;
        camera.update();

        float size = (float) 1.0 / 300.0f;

        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);

        avatar = player.getFrameSprite();

    }

    @Override
    public void show() {
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(cardViewer.getStage());
        inputMultiplexer.addProcessor(ctrl);
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void render(float v) {
        System.out.println(Gdx.graphics.isContinuousRendering());
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ctrl.update(v);
        if (v > 0.2) {
            logic.update();
            System.out.println("render tick");
        }
        avatar1 = player.getFrame();
        stage.draw();
        cardViewer.draw();

        renderer.setView(camera);
        renderer.render();

        renderer.getBatch().begin();
        renderer.getBatch().draw(avatar1, avatar.getX(), avatar.getY(), 1, 1);
        renderer.getBatch().end();

        System.out.println(player.gethp());


    }


    @Override
    public void resize(int i, int i1) {

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

    @Override
    public void dispose() {
        renderer.dispose();
        stage.dispose();
        parent.font.dispose();
        parent.batch.dispose();
        cardViewer.dispose();
    }
}
