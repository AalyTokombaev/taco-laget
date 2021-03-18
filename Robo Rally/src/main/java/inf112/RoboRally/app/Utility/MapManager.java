package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import java.util.Hashtable;

public class MapManager {

    private Hashtable<String,String> mapTable;
    private Hashtable<String, Vector2> playerStartLocations;

    private final static String VAULT = "VAULT";

    private final static String FLAG_LAYER = "Flag";
    private final static String HOLE_LAYER = "Hole";
    private final static String PLAYER_LAYER = "Player";
    private final static String COLLISION_LAYER = "COLLISION_LAYER";
    private final static String OBJECT_LAYER = "OBJECT_LAYER";

    private final static String PLAYER_START = "PLAYER_START";

    private Vector2 playerStartPosRect;

    private Vector2 _playerStart;
    private TiledMap currentMap = null;
    private String currentMapName;
    private MapLayer flagLayer = null;
    private MapLayer holeLayer = null;
    private MapLayer playerLayer = null;

    private MapLayer collisionLayer = null;
    private MapLayer objectLayer = null;

    public final static float UNIT_SCALE = 1/16f;

    public MapManager(){
        _playerStart = new Vector2(0,0);
        mapTable = new Hashtable<>();

        mapTable.put(VAULT,"Vault.tmx");
        playerStartLocations = new Hashtable<>();
        playerStartLocations.put(VAULT,_playerStart.cpy());

        playerStartPosRect = new Vector2(0,0);
    }

    public void loadMap(String mapName){
        _playerStart.set(0,0);

        String mapPath = mapTable.get(mapName);

        if(mapPath == null || mapPath.isEmpty()){
            return;
        }
        if(currentMap != null){
            currentMap.dispose();
        }

        Utility.loadMap(mapPath);

        if(Utility.isAssetLoaded(mapPath)){
            currentMap = Utility.getMapAsset(mapPath);
            currentMapName = mapName;
        }else{
            System.out.println("Error5");
            return;
        }
        flagLayer = currentMap.getLayers().get(FLAG_LAYER);
        if(flagLayer == null){
            System.out.println("No flaglayer");
        }
        holeLayer = currentMap.getLayers().get(HOLE_LAYER);
        if(holeLayer == null){
            System.out.println("No holeLayer");
        }
        playerLayer = currentMap.getLayers().get(PLAYER_LAYER);
        if(playerLayer == null){
            System.out.println("No playerLayer");
        }
        collisionLayer = currentMap.getLayers().get(COLLISION_LAYER);
        if(collisionLayer == null){
            System.out.println("No collision layer");
        }
        objectLayer = currentMap.getLayers().get(OBJECT_LAYER);
        if(objectLayer == null){
            System.out.println("No object layer");
        }else{
            Vector2 start = playerStartLocations.get(currentMapName);
            if(start.isZero()){
                //setClosestStartPos(playerStart);
                //start = playerStartLocations.get(currentMapName);
            }
            _playerStart.set(start.x,start.y);
        }
    }
    public TiledMap getCurrentMap(){
        if(currentMap == null){
            currentMapName = VAULT;
            loadMap(currentMapName);
        }
        return currentMap;
    }
    public Vector2 getPlayerStartUnitScaled(){
        Vector2 playerStart = _playerStart.cpy();
        playerStart.set(playerStart.x * UNIT_SCALE, playerStart.y * UNIT_SCALE);
        return playerStart;
    }



    public MapLayer getCollisonLayer(){
        return collisionLayer;
    }
    public  MapLayer getPlayerLayer(){
        return playerLayer;
    }

    public Vector2 getPlayerStartPosRect() {
        return playerStartPosRect;
    }
}
