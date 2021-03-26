package inf112.RoboRally.app.Player;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Objects.States;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Player in the Robo Rally game
 * This class holds all the information directly related to a Player
 */

public class Player {

    protected int MAX_HP = 10;
    protected int MAX_TOKEN = 3;

    private int healthPoints = MAX_HP;
    private int lifeTokens = MAX_TOKEN;

    final Vector2 position;

    public TiledMapTileLayer.Cell state;
    private final PlayerDeck deck;

    public List<Integer> flagsVisited;
    public int score = 0;

    private String id;

    public States states;

    private PlayerControls ctrl;

    //public Grid grid;

    //public int id;

    /**
     * Constructs a new Player to be placed on the Board and play the Robo Rally game
     *
     */
    public Player() {

        this.states = new States();

        this.deck = new PlayerDeck();

        this.state = states.alive();

        this.position = new Vector2();

        this.id = id;

        flagsVisited = new ArrayList<>();

        //this.grid = new Grid();

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
        System.out.println(getHp());
        if (healthPoints <= 0) {
            lifeTokens = lifeTokens - 1;
            healthPoints = MAX_HP;
            System.out.println("You've lost 10 hp and thus lose 1 lifeToken");
            state = states.alive();
        }
        if (lifeTokens <= 0) {
            state = states.dead();
        }
    }

    /**
     * Checks if the Player is standing on the next correct Flag according to previous visits,
     * and the chronological order of Flags on the Board
     *
     * @return true if the Player visited the correct Flag, false otherwise
     */
    public void getScore() {
        score = flagsVisited.size();
        if(score==3){
            state = states.win();
            System.out.println("win");
        }
        System.out.println(score);
    }
    public void setName(String name){
        this.id = name;
    }

    /**
     * Method to add an Integer value x to the number of Flags visited by a Player
     * Sets the Player State to win if numFlags
     *
     * @param x Integer value to be added to numFlags > 5
     */

    /**
     * Method that checks if a player is still alive.
     *
     * @return true if player has more than 0 lifeTokens, false otherwise.
     */
    public boolean isAlive(){
        return (this.lifeTokens > 0);
    }


    // puts the player on x,y
    public void put(int x, int y){
        this.position.x = x;
        this.position.y = y;
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

    public int getLifeTokens() {
        return lifeTokens;
    }

    public void setLifeTokens(int lives){
        this.lifeTokens = lives;
    }

    public int getx() {return (int) position.x; }

    public int gety() {return (int) position.y; }



}
