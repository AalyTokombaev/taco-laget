package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Grid.GridDirection;

public class Wall implements Object {

    /**
     * @param id is an identity variable to separate Wall objects from one another
     * @param pos is the vector position of the Wall object
     */
    public final int id;
    public final Vector2 pos;
    public final GridDirection dir;

    /**
     * Constructs a Wall with given identity and position
     *
     * @param id  int
     * @param pos Vector2
     */
    public Wall(int id, Vector2 pos, GridDirection dir) {
        this.id = id;
        this.pos = pos;
        this.dir = dir;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }
}
