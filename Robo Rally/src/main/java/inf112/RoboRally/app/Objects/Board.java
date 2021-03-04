package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Board {

    public String name;

    public TiledMapTileLayer boardLayer;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer flagLayer;
    public TiledMapTileLayer holeLayer;
    public TiledMapTileLayer wrenchLayer;

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

    public Board(String name) {

        this.name = name;

    }

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

        return map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public TiledMapTileLayer getHoleLayer() {
        return holeLayer;
    }
}


