package inf112.RoboRally.app;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

import javax.swing.text.Position;

public class Player {
    private TiledMapTileLayer.Cell state;
    private TiledMapTileLayer.Cell alive;
    private TiledMapTileLayer.Cell dead;
    private TiledMapTileLayer.Cell winning;
    private int flagsVisited;
    private int healthPoits;
    private int lifeTokens;

    public Player(Vector2 position, TextureRegion[][] portraits, int numFlags) {
        healthPoits = 10;
        lifeTokens = 3;

        // 0 means that no flags have been visited
        flagsVisited = 0;

        alive = new TiledMapTileLayer.Cell();
        dead = new TiledMapTileLayer.Cell();
        winning = new TiledMapTileLayer.Cell();

        alive.setTile(new StaticTiledMapTile(portraits[0][0]));
        dead.setTile(new StaticTiledMapTile(portraits[0][1]));
        winning.setTile(new StaticTiledMapTile(portraits[0][2]));

        state = alive;

    }

    public void setDead() {
        state = dead;
    }


    public void setAlive() {
        state = alive;
    }


    public void setWinning() {
        state =  winning;
    }

    public boolean vititFlag(Flag flag) {
        int id = flag.getId();
        if (id - flagsVisited == 1) {
            // you visited the correct flag
            flagsVisited = id;
            return true;
        }
        // You have not visited the correct flag
        return false;
    }
}
