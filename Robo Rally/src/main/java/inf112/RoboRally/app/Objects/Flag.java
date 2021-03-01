package inf112.RoboRally.app.Objects;
import com.badlogic.gdx.math.Vector2;

public class Flag implements Objects {
    final int id;
    final Vector2 pos;

    public Flag(int id, Vector2 pos ){
        this.id = id;
        this.pos = pos;
    }

    @Override
    public Vector2 getPos(){
        return this.pos;
    }

    @Override
    public int getId(){
        return this.id;
    }

}