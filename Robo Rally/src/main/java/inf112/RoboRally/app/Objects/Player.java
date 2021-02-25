package inf112.RoboRally.app.Objects;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player  {
    final Vector2 position;
    public TiledMapTileLayer.Cell state;
    private int numFlags;
    private int flagsVisited;
    private int healthPoints;
    private int lifeTokens;
    private final String name;
    final States states;

    public Player(String name, Vector2 position, int numFlags) {

        states = new States();

        //is this proper?
        this.state = states.alive();
        this.healthPoints = 10;
        this.lifeTokens = 3;
        this.numFlags = numFlags;
        this.position = position;
        this.name = name;
        // 0 means that no flags have been visited
        flagsVisited = 0;
    }

    public int getLifeTokens() {
        return lifeTokens;
    }

    public void setDamage(int x){
        healthPoints = healthPoints - x;
        //System.out.println(healthPoints);
        if(healthPoints <= 0){
            lifeTokens = lifeTokens - 1;
            healthPoints = 10;
            System.out.println("you've lost 10 hp");
            state = states.alive();
        }
        if(lifeTokens == 0){
            //TODO Add remove player/end player interaction, maybe its own class?
            state = states.dead();
        }else{
            state = states.alive();
        }
    }

    public TiledMapTileLayer.Cell getState(){
        return state;
    }

    public void setHP(int hp){
        healthPoints = healthPoints + hp;
    }

    public int getHp(){
        return healthPoints;
    }

    public boolean visitFlag(Flag flag) {
        //TODO Can this be its own object?
        int id = flag.getId();
        if (id - flagsVisited == 1) {
            // you visited the correct flag
            flagsVisited = id;
            return true;
        }
        // You have not visited the correct flag
        return false;
    }
    public Vector2 getPosition(){
        return position;
    }


    public void setPosition(int x, int y){
        position.add(x,y);
    }

    public String getName(){
        return name;
    }

    public void setScore(int x){
        numFlags = numFlags + x;
        if (numFlags > 5){
            //TODO add something that registers the win
            state = states.win();

        }

    }
    public int getScore(){
        return numFlags;
    }


}
