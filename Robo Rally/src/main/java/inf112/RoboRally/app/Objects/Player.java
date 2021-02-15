package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player implements IPlayer {
    private final Vector2 position;
    private final int numFlags;
    private TiledMapTileLayer.Cell state;
    private TiledMapTileLayer.Cell alive;
    private TiledMapTileLayer.Cell dead;
    private TiledMapTileLayer.Cell winning;
    private int flagsVisited;
    private int healthPoints;
    private int lifeTokens;

    public Player(Vector2 position, int numFlags, int healthPoints, int lifeTokens) {
        /*

        TextureRegion[][] portraits,
        alive = new TiledMapTileLayer.Cell();
        dead = new TiledMapTileLayer.Cell();
        winning = new TiledMapTileLayer.Cell();

        alive.setTile(new StaticTiledMapTile(portraits[0][0]));
        dead.setTile(new StaticTiledMapTile(portraits[0][1]));
        winning.setTile(new StaticTiledMapTile(portraits[0][2]));

        *
        *
        *
        *
        * */
        this.healthPoints = healthPoints;
        this.lifeTokens = lifeTokens;
        this.state = state;
        this.numFlags = numFlags;
        this.position = position;

        // 0 means that no flags have been visited
        flagsVisited = 0;

        //TODO take a look at how this systems works, do we need to create three cells here?

    }

    /*
    @Override
    public void setDead() {
        state = dead;
    }


    @Override
    public void setAlive() {
        state = alive;
    }


    @Override
    public void setWinning() {
        state =  winning;
    }
*/
    @Override
    public void setDamage(int x){
        healthPoints = healthPoints - x;
    }

    @Override
    public TiledMapTileLayer.Cell getState(){
        if (lifeTokens == 0){
            return dead;
        }else{
            return alive;
        }
    }

    @Override
    public int getHp(){
        return this.healthPoints;
    }

    @Override
    public boolean visitFlag(Flag flag) {
        int id = flag.getId();
        if (id - flagsVisited == 1) {
            // you visited the correct flag
            flagsVisited = id;
            return true;
        }
        // You have not visited the correct flag
        return false;
    }
    @Override
    public Vector2 getPosition(){
        return this.position;
    }
}
