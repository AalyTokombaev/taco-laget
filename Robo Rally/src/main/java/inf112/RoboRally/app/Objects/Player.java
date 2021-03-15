package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Controlls;

/**
 * This class represents a Player in the Robo Rally game
 * This class holds all the information directly related to a Player
 */

public class Player {
    final Vector2 position;
    public TiledMapTileLayer.Cell state;
    private final PlayerDeck deck;
    private int numFlags;
    private int flagsVisited;
    private int healthPoints;
    private int lifeTokens;
    private final String name;
    final States states;
    private Controlls ctrl;

    /**
     * Constructs a new Player to be placed on the Board and play the Robo Rally game
     *
     * @param name     is the name of the Player
     * @param position is the position of where the Player should spawn on the Board
     * @param numFlags is the total number of Flags on the Board
     */
    public Player(String name, Vector2 position, int numFlags, Controlls ctrl) {
        states = new States();
        this.deck = new PlayerDeck();
        this.state = states.alive();
        this.healthPoints = 10;
        this.lifeTokens = 3;
        this.numFlags = numFlags;
        this.position = position;
        this.name = name;
        this.ctrl = ctrl;
        flagsVisited = 0;
    }

    /**
     * Inflicts damage on the Player by decreasing the healthPoints variable by the input amount
     * Removes a LifeToken if the Player dies
     * Sets the alive/dead state of the Player
     *
     * @param x is the input amount of damage
     */
    public void setDamage(int x) {
        healthPoints = healthPoints - x;
        if (healthPoints <= 0) {
            lifeTokens = lifeTokens - 1;
            healthPoints = 10;
            System.out.println("You've lost 10 hp and 1 lifeToken");
            state = states.alive();
        }
        if (lifeTokens <= 0) {
            state = states.dead();
        } else {
            state = states.alive();
        }
    }

    /**
     * Checks if the Player is standing on the next correct Flag according to previous visits,
     * and the chronological order of Flags on the Board
     *
     * @param flag is the flag the Player is standing on
     * @return true if the Player visited the correct Flag, false otherwise
     */
    public boolean visitFlag(Flag flag) {
        int id = flag.getId();
        if (id - flagsVisited == 1) {
            // You visited the correct flag
            flagsVisited = id;
            return true;
        }
        // You have not visited the correct flag
        return false;
    }

    /**
     * Method to add an Integer value x to the number of Flags visited by a Player
     * Sets the Player State to win if numFlags
     *
     * @param x Integer value to be added to numFlags > 5
     */
    public void setScore(int x) {
        numFlags = numFlags + x;
        if (numFlags > 5) {
            state = states.win();
        }
    }


     public void movement(){
        if(ctrl.isKeyPressed(19)){
            System.out.println("Test");
            setPosition(0,1);
        }else if(ctrl.isKeyPressed(20)){
            setPosition(0,-1);
        }else if(ctrl.isKeyPressed(22)){
            setPosition(1,0);
        }else if(ctrl.isKeyPressed(21)){
            setPosition(-1,0);
        }


    }


    // Getters and setters for class field variables

    public TiledMapTileLayer.Cell getState() {
        return state;
    }

    public void setHP(int hp) {
        healthPoints = healthPoints + hp;
    }

    public int getHp() {
        return healthPoints;
    }

    public PlayerDeck getDeck() {
        return deck;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.add(x, y);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return numFlags;
    }

    public int getLifeTokens() {
        return lifeTokens;
    }
}
