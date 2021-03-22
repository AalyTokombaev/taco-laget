package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import java.util.Hashtable;

public class MapManager {

    private static final String TAG = MapManager.class.getSimpleName();

    private final static String TEST_MAP = "TEST_MAP";
    private final static String VAULT2 = "VAULT2";

    //maps
    private final static String VAULT = "VAULT";
    private final static String WALL_LAYER = "Walls";
    //All maps for the game
    private final Hashtable<String, String> _mapTable;

    //Map layers

    private final static String BOARD_LAYER = "Board";
    private final static String FLAG_LAYER = "Flag";
    private final static String HOLE_LAYER = "Hole";
    private final static String PLAYER_LAYER = "Player";
    private final Hashtable<String, Vector2> _playerStartLocationTable;

    private final static String PLAYER_START = "PLAYER_START";
    private final Vector2 _playerStartPositionRect;
    private final Vector2 _closestPlayerStartPostion;
    private Vector2 _convertedUnits;

    private final Vector2 _playerStart;
    private TiledMap _currentMap = null;
    private String _currentMapName;


    private MapLayer boardLayer;
    private MapLayer playerLayer;
    private MapLayer flagLayer;
    private MapLayer holeLayer;
    private MapLayer wallLayer;

    public final static float UNIT_SCALE = 1/16f;

    public MapManager() {
        _playerStart = new Vector2(0, 0);
        _mapTable = new Hashtable<>();

        _mapTable.put(VAULT, "Vault.tmx");
        _mapTable.put(TEST_MAP, "testMap.tmx");
        _mapTable.put(VAULT2, "Vault2.tmx");


        _playerStartLocationTable = new Hashtable<>();
        _playerStartLocationTable.put(VAULT, _playerStart.cpy());
        _playerStartLocationTable.put(TEST_MAP, _playerStart.cpy());
        _playerStartLocationTable.put(VAULT2, _playerStart.cpy());

        _playerStartPositionRect = new Vector2(0, 0);
        _closestPlayerStartPostion = new Vector2(0, 0);

    }

    public void loadMap(String mapName){
        _playerStart.set(0,0);

        String mapFullPath = _mapTable.get(mapName);

        if(mapFullPath == null || mapFullPath.isEmpty()){
            Gdx.app.debug(TAG, "Map is invalid");
            return;
        }
        if (_currentMap != null){
            _currentMap.dispose();
        }

        Utility.loadMapAsset(mapFullPath);
        if(Utility.isAssetLoaded(mapFullPath)){
            _currentMap = Utility.getMapAsset(mapFullPath);
            _currentMapName = mapName;
        }else{
            Gdx.app.debug(TAG, "Map not loaded");
            return;
        }

        flagLayer = _currentMap.getLayers().get(FLAG_LAYER);
        if(flagLayer == null){
            System.out.println("No flaglayer");
        }
        holeLayer = _currentMap.getLayers().get(HOLE_LAYER);
        if(holeLayer == null){
            System.out.println("No holeLayer");
        }
        playerLayer = _currentMap.getLayers().get(PLAYER_LAYER);
        if (playerLayer == null) {
            System.out.println("No playerLayer");
        }
        boardLayer = _currentMap.getLayers().get(BOARD_LAYER);
        if (boardLayer == null) {
            System.out.println("No boardLayer");
        }
        wallLayer = _currentMap.getLayers().get(WALL_LAYER);
        if (wallLayer == null) {
            System.out.println("No wallLayer");
        }
    }

    public TiledMap getCurrentMap(){
        if (_currentMap == null){
            _currentMapName = VAULT;
            loadMap(_currentMapName);
        }
        return _currentMap;
    }

    public Vector2 getPlayerStartUnitScaled(){
        Vector2 playerStart = _playerStart.cpy();
        playerStart.set(_playerStart.x * UNIT_SCALE, _playerStart.y * UNIT_SCALE);
        return playerStart;
    }

    public MapLayer getPlayerLayer(){ return playerLayer;}
    public MapLayer getBoardLayer(){return boardLayer;}
    public MapLayer getFlagLayer(){return flagLayer;}

    public MapLayer getHoleLayer() {
        return holeLayer;
    }

    public MapLayer getWallLayer() {
        return wallLayer;
    }
}
