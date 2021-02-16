package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public interface IPlayer {
    TiledMapTileLayer.Cell getState();

    int getHp();

    boolean visitFlag(Flag flag);

    Vector2 getPosition();

    void setDamage(int x);

    void setPosition(int x, int y);

    void setAlive();

    void setDead();

    void setWinning();
}
