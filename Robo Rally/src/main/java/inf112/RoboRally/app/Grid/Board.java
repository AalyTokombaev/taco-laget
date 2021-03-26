package inf112.RoboRally.app.Grid;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Player.Player;

/**
 * This class represents a Board or a Map in the Robo Rally game
 * This class takes care of loading the map file, and the map layers created in Tiled
 */
public class Board {


    // Map name
    public String name;

    // TiledMap
    private TiledMap map;
    private Vector2 defaultStart;

    // Floor tiles, playerLayer, Flag tiles, Hole tiles, Wrench tiles
    public TiledMapTileLayer boardLayer;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer flagLayer;
    public TiledMapTileLayer holeLayer;
    public TiledMapTileLayer wrenchLayer;
    public TiledMapTileLayer walls;
/*
    // Walls
    public TiledMapTileLayer upperWallLayer;
    public TiledMapTileLayer lowerWallLayer;
    public TiledMapTileLayer rightWallLayer;
    public TiledMapTileLayer leftWallLayer;

    // Regular u/d/l/r conveyors
    public TiledMapTileLayer yellowConveyorRight;
    public TiledMapTileLayer yellowConveyorLeft;
    public TiledMapTileLayer yellowConveyorUp;
    public TiledMapTileLayer yellowConveyorDown;

    // Clockwise rotating yellow conveyors
    public TiledMapTileLayer yellowConveyorClockWiseRight;
    public TiledMapTileLayer yellowConveyorClockWiseLeft;
    public TiledMapTileLayer yellowConveyorClockWiseUp;
    public TiledMapTileLayer yellowConveyorClockWiseDown;

    // Counter clockwise rotating yellow conveyors
    public TiledMapTileLayer yellowConveyorCClockwiseUpLeft;
    public TiledMapTileLayer yellowConveyorCClockwiseLeftDown;
    public TiledMapTileLayer yellowConveyorCClockwiseDownRight;
    public TiledMapTileLayer yellowConveyorCClockwiseRightUp;
*/

    /**
     * Constructs a board with a given name
     *
     * @param name
     */
    public Board(String name) {
        this.name = name;
        this.map = makeMap();
        this.defaultStart = new Vector2(0,0);

    }

    /**
     * Loads the map file and passes the layer information to the Board object (field variables)
     *
     * @return the map with pre-constructed name
     */



    public TiledMap makeMap() {

        TiledMap map = new TmxMapLoader().load(name);

        // load the board
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        // load the player
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        // load the flags
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        // load the holes
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        // load the wrenches
        wrenchLayer = (TiledMapTileLayer) map.getLayers().get("Wrench");

        walls = (TiledMapTileLayer) map.getLayers().get("Walls");
/*
        // load the walls
        upperWallLayer = (TiledMapTileLayer) map.getLayers().get("UpperWall");
        lowerWallLayer = (TiledMapTileLayer) map.getLayers().get("LowerWall");
        rightWallLayer = (TiledMapTileLayer) map.getLayers().get("RightWall");
        leftWallLayer = (TiledMapTileLayer) map.getLayers().get("LeftWall");

        // load the u/d/l/r conveyors
        yellowConveyorRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRight");
        yellowConveyorLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorLeft");
        yellowConveyorUp = (TiledMapTileLayer) map.getLayers().get("ConveyorUp");
        yellowConveyorDown = (TiledMapTileLayer) map.getLayers().get("ConveyorDown");

        // load the clockwise rotation conveyors
        yellowConveyorClockWiseRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpRight");
        yellowConveyorClockWiseLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownLeft");
        yellowConveyorClockWiseUp = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftUp");
        yellowConveyorClockWiseDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightDown");

        // load the counter clockwise rotation conveyors
        yellowConveyorCClockwiseUpLeft = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateUpLeft");
        yellowConveyorCClockwiseLeftDown = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateLeftDown");
        yellowConveyorCClockwiseDownRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownRight");
        yellowConveyorCClockwiseRightUp = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightUp");
*/
        return map;
    }

    // Getters and setters for class field variables

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public TiledMap getMap() {
        if (name.isEmpty()) {
            name = "testMap";
            makeMap();
        }
        return map;
    }

    public void setPlayer(Player player) {
        playerLayer.setCell((int) defaultStart.x, (int) defaultStart.y, player.getState());
    }
}


