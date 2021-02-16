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

    public TiledMapTileLayer upperWallLayer;
    private TiledMapTileLayer lowerWallLayer;
    private TiledMapTileLayer rightWallLayer;
    private TiledMapTileLayer leftWallLayer;

    public TiledMapTileLayer yellowConveyorRight;
    private TiledMapTileLayer yellowConveyorLeft;
    private TiledMapTileLayer yellowConveyorUp;
    private TiledMapTileLayer yellowConveyorDown;

    // Clockwise rotating yellow conveyors
    public TiledMapTileLayer yellowConveyorClockWiseRight;
    private TiledMapTileLayer yellowConveyorClockWiseLeft;
    private TiledMapTileLayer yellowConveyorClockWiseUp;
    private TiledMapTileLayer yellowConveyorClockWiseDown;

    // Counter clockwise rotating yellow conveyors
    public TiledMapTileLayer yellowConveyorCClockwiseUpLeft;
    private TiledMapTileLayer yellowConveyorCClockwiseLeftDown;
    private TiledMapTileLayer yellowConveyorCClockwiseDownRight;
    private TiledMapTileLayer yellowConveyorCClockwiseRightUp;

    public Board(String name){

      this.name = name;

    }

    public TiledMap makeMap(){
        TiledMap map = new TmxMapLoader().load(name);

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
        yellowConveyorCClockwiseDownRight = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateDownRight");
        yellowConveyorCClockwiseRightUp = (TiledMapTileLayer) map.getLayers().get("ConveyorRotateRightUp");

        return map;
    }

    public String getName(){
        return this.name;
    }


}
