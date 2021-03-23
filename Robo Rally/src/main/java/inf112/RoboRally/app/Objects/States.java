package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

/**
 * This class represents the possible states the Player object can have in the Robo Rally game
 * The states are represented by different textures resembling the nature of the state
 */
public class States {

    final TiledMapTileLayer.Cell alive, dead, winning;

    /**
     * Constructs a States object which loads the texture containing the 3 states the Player can have in the Robo Rally game
     * Further splits the texture into 3, creates a cell for each texture and sets the state tile
     */
    public States() {
        Texture texture = new Texture("player.png");
        TextureRegion[][] portraits = TextureRegion.split(texture, 300, 300);
        alive = new TiledMapTileLayer.Cell();
        dead = new TiledMapTileLayer.Cell();
        winning = new TiledMapTileLayer.Cell();
        alive.setTile(new StaticTiledMapTile(portraits[0][0]));
        dead.setTile(new StaticTiledMapTile(portraits[0][1]));
        winning.setTile(new StaticTiledMapTile(portraits[0][2]));
    }

    /**
     * @return the Cell with the alive texture and tile
     */
    public TiledMapTileLayer.Cell alive() {
        return alive;
    }

    /**
     * @return the Cell with the dead texture and tile
     */
    public TiledMapTileLayer.Cell dead() {
        return dead;
    }

    /**
     * @return the Cell with the dead texture and tile
     */
    public TiledMapTileLayer.Cell win() {
        return winning;
    }

    public TiledMapTileLayer.Cell getState(String state) {
        switch (state){
            case "dead":
                return dead;
            case "winning":
                return winning;
            default:
                return alive;
        }

    }


}
