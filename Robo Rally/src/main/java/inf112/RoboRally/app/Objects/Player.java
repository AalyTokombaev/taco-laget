package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

public class Player extends TiledMapTileLayer.Cell implements IPlayer {
    private final Vector2 position;
    private int numFlags;
    public TiledMapTileLayer.Cell state, alive, dead, winning;
    private int flagsVisited;
    private int healthPoints;
    private int lifeTokens;
    private final String name;

    public Player(String name, Vector2 position, int numFlags, int healthPoints, int lifeTokens) {

        this.healthPoints = healthPoints;
        this.lifeTokens = lifeTokens;
        this.numFlags = numFlags;
        this.position = position;
        this.name = name;


        //TODO take a look at how this systems works, do we need to create three cells here?

        Texture texture = new Texture("player.png");
        TextureRegion[][] portraits = TextureRegion.split(texture, 300, 300);
        alive = new TiledMapTileLayer.Cell();
        dead = new TiledMapTileLayer.Cell();
        winning = new TiledMapTileLayer.Cell();

        alive.setTile(new StaticTiledMapTile(portraits[0][0]));
        dead.setTile(new StaticTiledMapTile(portraits[0][1]));
        winning.setTile(new StaticTiledMapTile(portraits[0][2]));

        // 0 means that no flags have been visited
        flagsVisited = 0;


    }


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

    @Override
    public void setDamage(int x){
        healthPoints = healthPoints - x;
        System.out.println(healthPoints);
        if(healthPoints <= 0){
            lifeTokens = lifeTokens - 1;
            healthPoints = 10;
            state = alive;
        }
        if(lifeTokens <= 0){
            state = dead;
        }else{
            state = alive;
        }

    }

    @Override
    public TiledMapTileLayer.Cell getState(){
        return state;
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

    @Override
    public void setPosition(int x, int y){
        position.add(x,y);
    }

    public String getName(){
        return this.name;
    }

    public void setScore(int x){
        numFlags = numFlags + x;

    }
    public int getScore(){
        return numFlags;
            }


}
