package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;

public class HelloWorld extends InputAdapter implements ApplicationListener {
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

    private TiledMapTileLayer yellowConveyorRight;
    private TiledMapTileLayer yellowConveyorLeft;
    private TiledMapTileLayer yellowConveyorUp;
    private TiledMapTileLayer yellowConveyorDown;

    // Clockwise rotating yellow conveyors
    private TiledMapTileLayer yellowConveyorClockWiseRight;
    private TiledMapTileLayer yellowConveyorClockWiseLeft;
    private TiledMapTileLayer yellowConveyorClockWiseUp;
    private TiledMapTileLayer yellowConveyorClockWiseDown;

    // Counter clockwise rotating yellow conveyors
    private TiledMapTileLayer yellowConveyorCClockwiseUpLeft;
    private TiledMapTileLayer yellowConveyorCClockwiseLeftDown;
    private TiledMapTileLayer yellowConveyorCClockwiseDownRight;
    private TiledMapTileLayer yellowConveyorCClockwiseRightUp;

    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private TmxMapLoader loader;

    private Vector2 playerPosition;
    private TiledMapTileLayer.Cell playerCell;
    private TiledMapTileLayer.Cell playerWonCell;
    private TiledMapTileLayer.Cell playerDiedCell;

    private int x,y;

    @Override
    public void create() {
        //Start-pos for player
        x = 0;
        y = 0;

        //Hva gjør disse? trenger vi de?

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        loader = new TmxMapLoader();

        map = loader.load("Vault.tmx");

        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");

        yellowConveyorRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRight");
        yellowConveyorLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorLeft");
        yellowConveyorUp = (TiledMapTileLayer) map.getLayers().get("ConveyorUp");
        yellowConveyorDown = (TiledMapTileLayer) map.getLayers().get("ConveyorDown");

        yellowConveyorClockWiseRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpRight");
        yellowConveyorClockWiseLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownLeft");
        yellowConveyorClockWiseUp = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftUp");
        yellowConveyorClockWiseDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightDown");

        // CClockwise rotations

        yellowConveyorCClockwiseUpLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpLeft");
        yellowConveyorCClockwiseLeftDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftDown");
        yellowConveyorCClockwiseDownRight= (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownRight");
        yellowConveyorCClockwiseRightUp= (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightUp");

        Texture texture = new Texture("player.png");
        TextureRegion[][] portraits = TextureRegion.split(texture, 300, 300);


        playerCell = new TiledMapTileLayer.Cell();
        playerWonCell = new TiledMapTileLayer.Cell();
        playerDiedCell = new TiledMapTileLayer.Cell();

        playerCell.setTile(new StaticTiledMapTile(portraits[0][0]));
        playerDiedCell.setTile(new StaticTiledMapTile(portraits[0][1]));
        playerWonCell.setTile(new StaticTiledMapTile(portraits[0][2]));

        playerLayer.setCell(x,y,playerCell);
        playerPosition = new Vector2(x,y);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.position.x = 6F; // sentrerer camera
        camera.update();

        float size = (float) 1.0/300.0F;
        renderer = new OrthogonalTiledMapRenderer(map, size);
        renderer.setView(camera);
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


        if (holeLayer.getCell(x, y) != null) {
            playerLayer.setCell(x, y, playerDiedCell);
        }
        if (flagLayer.getCell(x, y) != null) {
            playerLayer.setCell(x, y, playerWonCell);

        }
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
        if(i == Input.Keys.LEFT)
            playerPosition = new Vector2(x-1,y);
            playerLayer.setCell(x,y,null);
            playerLayer.setCell((int)playerPosition.x,(int)playerPosition.y,playerCell);
        if(i == Input.Keys.RIGHT)
            playerPosition = new Vector2(x+1,y);
            playerLayer.setCell(x,y,null);
            playerLayer.setCell((int)playerPosition.x,(int)playerPosition.y,playerCell);
        if(i == Input.Keys.UP)
            playerPosition = new Vector2(x,y+1);
            playerLayer.setCell(x,y,null);
            playerLayer.setCell((int)playerPosition.x,(int)playerPosition.y,playerCell);
        if(i == Input.Keys.DOWN)
            playerPosition = new Vector2(x,y-1);
            playerLayer.setCell(x,y,null);
            playerLayer.setCell((int)playerPosition.x,(int)playerPosition.y,playerCell);
        return false;
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
