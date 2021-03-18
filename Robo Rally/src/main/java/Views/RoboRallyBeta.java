package Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.RoboRally.app.Controller;
import inf112.RoboRally.app.HUD.CardViewer;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.MapManager;
import inf112.skeleton.app.Player;

/**
 * This class handles the camera and the rendering of objects in the Robo Rally game
 * More specifically, takes care of the initializing, rendering, resizing, disposing and taking inputs for the application
 */

public class RoboRallyBeta implements Screen {

    private Controller ctrl;
    private TextureRegion playerFrame;
    private Sprite playerAvatar;
    private Player player;
    private RoboRally roboRally;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer = null;
    private OrthographicCamera camera = null;
    private static MapManager mapManager;
    private CardViewer cardViewer;

    public RoboRallyBeta(RoboRally roboRally){

        this.roboRally = roboRally;
        roboRally.batch = new SpriteBatch();
        roboRally.font = new BitmapFont();
        mapManager = new MapManager();
    }


    @Override
    public void show() {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12,18.8f);

        cardViewer = new CardViewer(roboRally.batch,player);

        float size = (float) 1.0 / 300.0f;
        renderer = new OrthogonalTiledMapRenderer(mapManager.getCurrentMap(),size);
        renderer.setView(camera);
        player = new Player();
        player.init(mapManager.getPlayerStartUnitScaled().x,mapManager.getPlayerStartUnitScaled().y);
        playerAvatar = player.getFrameSprite();

        ctrl = new Controller(player);
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(cardViewer.getStage());
        inputMultiplexer.addProcessor(ctrl);
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.x = 6F;

        camera.update();

        player.update(v);
        playerFrame = player.getFrame();
        cardViewer.draw();
        player.setNextPositionToCurrent();

        ctrl.update(v);

        renderer.setView(camera);
        renderer.render();
        renderer.getBatch().begin();
        renderer.getBatch().draw(playerFrame,playerAvatar.getX(),playerAvatar.getY(),1,1);
        renderer.getBatch().end();

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
        player.dispose();
        ctrl.dispose();
        Gdx.input.setInputProcessor(null);
        renderer.dispose();
    }
}