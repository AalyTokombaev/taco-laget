package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.math.Vector2;

/**
 * This class represents a Flag in the Robo Rally game
 * Flags can be touched by moving to the same position as a Flag tile
 * Flags work as win conditions in the Robo Rally game, as you win when you have touched the number of flags in a chronological sequence
 */
public class Flag implements Objects {
    /**
     * @param id is an identity variable to separate Flag objects from one another
     * @param pos is the vector position of the Flag object
     */
    final int id;
    final Vector2 pos;

    /**
     * Constructs a Flag with given identity and position
     *
     * @param id  int
     * @param pos Vector2
     */
    public Flag(int id, Vector2 pos) {
        this.id = id;
        this.pos = pos;
    }

    // Getters for class field variables

    @Override
    public Vector2 getPos() {
        return this.pos;
    }

    @Override
    public int getId() {
        return this.id;
    }

}