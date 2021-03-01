package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class States {

    final TiledMapTileLayer.Cell alive, dead, winning;

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

    public TiledMapTileLayer.Cell alive(){
        return alive;
    }

    public TiledMapTileLayer.Cell dead(){
        return dead;
    }

    public TiledMapTileLayer.Cell win(){
        return winning;
    }


}
