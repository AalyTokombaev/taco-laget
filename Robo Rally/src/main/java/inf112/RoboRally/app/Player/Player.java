package inf112.RoboRally.app.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.PlayerDeck;

import inf112.RoboRally.app.Utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {

    protected int MAX_HP = 10;
    protected int MAX_TOKEN = 3;

    private static final String _defaultSpritePath = "player.png";

    private int hp = MAX_HP;
    private int token = MAX_TOKEN;

    private final String id;
    private final PlayerDeck deck;
    //private States status;
    private final Vector2 position;
    protected Sprite frameSprite = null;
    //protected TextureRegion currentFrame = null;
    public final int FRAME_WIDTH = 300;
    public final int FRAME_HEIGHT = 300;
    public int score = 0;
    public List<Integer> flagsVisited;


    public Player() {

        //TODO change id to int
        this.id = UUID.randomUUID().toString();
        this.position = new Vector2(0, 0);
        this.deck = new PlayerDeck();
        flagsVisited = new ArrayList<>();

        Utility.loadTextureAsset(_defaultSpritePath);
        loadDefaultSprite();

    }


    private void loadDefaultSprite() {

        //TODO simplify, trengs sikkert ikke siden vi ikke animerer
        Texture texture = Utility.getTextureAsset(_defaultSpritePath);
        TextureRegion[][] textureFrames = TextureRegion.split(texture, FRAME_WIDTH, FRAME_HEIGHT);

        frameSprite = new Sprite(textureFrames[0][0].getTexture(), 0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        //currentFrame = textureFrames[0][0];
    }

    public void setCurrentPosition(float x, float y) {
        position.add(x, y);
        frameSprite.setX(position.x);
        frameSprite.setY(position.y);
        System.out.println(position);

    }

    public void setDamage(int x) {
        hp = hp - x;
        System.out.println(hp);
        if (hp <= 0) {
            token = token - 1;
            hp = MAX_HP;
            System.out.println(token);
        }
        if (token <= 0) {
            System.out.println("Player is dead");
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Sprite getFrameSprite() {
        return frameSprite;
    }

    public PlayerDeck getDeck() {
        return deck;
    }

    //public TextureRegion getFrame() {
    //    return currentFrame;
    //}

    public void dispose() {
        Utility.unloadAssets(_defaultSpritePath);
    }

    public void setDirection(String direction) {
        //TODO rotate avatar with the help of direction enum
        System.out.println(direction);
        if(direction.equals("EAST")){
            frameSprite.rotate(90);
        }if(direction.equals("WEST")){
            frameSprite.rotate(270);
        }if(direction.equals("NORTH")){
            frameSprite.rotate(0);
        }if(direction.equals("SOUTH")){
            frameSprite.rotate(180);
        }
    }

    public int getHp() {
        return hp;
    }

    public void getScore() {
        score = flagsVisited.size();
        if(score==3){
            System.out.println("win");
        }
        System.out.println(score);
    }
    public int getLifeTokens() {
        return token;
    }

    public void setLifeTokens(int lives){
        this.token = lives;
    }

    public String getId() {
        return this.id;
    }
}

