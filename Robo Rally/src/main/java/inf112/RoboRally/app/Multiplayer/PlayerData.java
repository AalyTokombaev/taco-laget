package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class PlayerData {
    public int x;
    public int y;
    public int id;
    public TiledMapTileLayer.Cell state;

    public PlayerData(int x, int y, int id, TiledMapTileLayer.Cell state){
        this.x = x;
        this.y = y;
        this.state = state;
    }

}
