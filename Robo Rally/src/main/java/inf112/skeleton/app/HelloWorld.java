package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class HelloWorld implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer playerLayer;
    private TiledMapTileLayer flagLayer;
    private TiledMapTileLayer holeLayer;

    private TiledMapTileLayer wrenchLayer;

    private TiledMapTileLayer upperWallLayer;
    private TiledMapTileLayer lowerWallLayer;
    private TiledMapTileLayer rightWallLayer;
    private TiledMapTileLayer leftWallLayer;

    private TiledMapTileLayer yellowConveyerRight;
    private TiledMapTileLayer yellowConveyerLeft;
    private TiledMapTileLayer yellowConveyerUp;
    private TiledMapTileLayer yellowConveyerDown;

    // Clockwise rotating yellow conveyors
    private TiledMapTileLayer yellowConveyerClockWiseRight;
    private TiledMapTileLayer yellowConveyerClockWiseLeft;
    private TiledMapTileLayer yellowConveyerClockWiseUp;
    private TiledMapTileLayer yellowConveyerClockWiseDown;

    // Counte clockwise rotating yellow convyors
    private TiledMapTileLayer yellowConveyorCClockwiseUpLeft;
    private TiledMapTileLayer yellowConveyorCClockwiseLeftDown;
    private TiledMapTileLayer yellowConveyorCClockwiseDownRight;
    private TiledMapTileLayer yellowConveyorCClockwiseRightUp;

    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private TmxMapLoader loader;
    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        loader = new TmxMapLoader();

        // yymap = loader.load("/Users/alexanderiversen/Documents/inf122/tutorial/Tutorial/src/main/java/inf112/skeleton/assets/example.tmx");
        map = loader.load("Vault.tmx");



        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");

        yellowConveyerRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRight");
        yellowConveyerLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorLeft");
        yellowConveyerUp = (TiledMapTileLayer) map.getLayers().get("ConveyorUp");
        yellowConveyerDown = (TiledMapTileLayer) map.getLayers().get("ConveyorDown");

        yellowConveyerClockWiseRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpRight");
        yellowConveyerClockWiseLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownLeft");
        yellowConveyerClockWiseUp = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftUp");
        yellowConveyerClockWiseDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightDown");

        // CClockwise rotations

        yellowConveyorCClockwiseUpLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpLeft");
        yellowConveyorCClockwiseLeftDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftDown");
        yellowConveyorCClockwiseDownRight= (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownRight");
        yellowConveyorCClockwiseRightUp= (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightUp");


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        float size = (float) 1.0/300.0f;
        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);


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
        renderer.render();


        // batch.begin();
        //font.draw(batch, "Hello World", 200, 200);
        // batch.end();
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
}
