package inf112.RoboRally.app;

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
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;


public class RoboRallyBeta extends InputAdapter implements ApplicationListener {
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


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        loader = new TmxMapLoader();

        // load vault map
        map = loader.load("Vault.tmx");

        // get the lower layers of the map
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");


        // there are tons of conveyors, load the u/d/l/r conveyors
        yellowConveyorRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRight");
        yellowConveyorLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorLeft");
        yellowConveyorUp = (TiledMapTileLayer) map.getLayers().get("ConveyorUp");
        yellowConveyorDown = (TiledMapTileLayer) map.getLayers().get("ConveyorDown");


        // load the clockwise conveyor
        yellowConveyorClockWiseRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpRight");
        yellowConveyorClockWiseLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownLeft");
        yellowConveyorClockWiseUp = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftUp");
        yellowConveyorClockWiseDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightDown");


        // load the counter clockwise rotations
        yellowConveyorCClockwiseUpLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpLeft");
        yellowConveyorCClockwiseLeftDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftDown");
        yellowConveyorCClockwiseDownRight= (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownRight");
        yellowConveyorCClockwiseRightUp= (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightUp");

        // load player textures and split them
        Texture texture = new Texture("player.png");
        TextureRegion[][] portraits = TextureRegion.split(texture, 300, 300);

        // initialize player cells
        playerPosition = new Vector2(1, 1);
        playerCell = new TiledMapTileLayer.Cell();
        playerWonCell = new TiledMapTileLayer.Cell();
        playerDiedCell = new TiledMapTileLayer.Cell();

        // set the appropriate textures for player state
        playerCell.setTile(new StaticTiledMapTile(portraits[0][0]));
        playerDiedCell.setTile(new StaticTiledMapTile(portraits[0][1]));
        playerWonCell.setTile(new StaticTiledMapTile(portraits[0][2]));

        // camera setup
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        playerLayer.setCell(1, 1, playerCell);
        camera.update();

        // render setup
        float size = (float) 1.0/300.0f;
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

        // make the player display ad dead
        if (holeLayer.getCell((int)playerPosition.x,(int)playerPosition.y) != null) {
            playerLayer.setCell((int) playerPosition.x, (int) playerPosition.y, playerDiedCell);
        }
        // make the player display as a winner 8)
        if(flagLayer.getCell((int)playerPosition.x, (int)playerPosition.y) != null){
            playerLayer.setCell((int) playerPosition.x, (int) playerPosition.y, playerWonCell);

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
        // get the last player position
        int x, y;
        x = (int) playerPosition.x;
        y = (int) playerPosition.y;

        // update player position accordingly
        if(i == Input.Keys.UP){
            playerPosition.add(0, 1);
        }
        if(i == Input.Keys.DOWN){
            playerPosition.add(0, -1);
        }
        if(i == Input.Keys.RIGHT) {
            playerPosition.add(1, 0);
        }
        if(i == Input.Keys.LEFT) {
            playerPosition.add(-1, 0);
        }
        // set the last player position to null
        playerLayer.setCell(x, y, null);
        // update player position
        playerLayer.setCell((int)playerPosition.x , (int)playerPosition.y, playerCell);
        return true;
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
