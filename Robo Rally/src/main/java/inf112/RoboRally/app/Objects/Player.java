package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Utility.Utility;

import java.util.UUID;


public class Player {

    private static final String TAG = Player.class.getSimpleName();
    private static final String _defaultSpritePath = "Engineer.png";

    private Vector2 _velocity;
    private String _entityID;

    private Direction _currentDirection = Direction.LEFT;
    private Direction _previousDirection = Direction.UP;

    private Animation _walkLeftAnimation;
    private Animation _walkRightAnimation;
    private Animation _walkUpAnimation;
    private Animation _walkDownAnimation;

    private Array<TextureRegion> _walkLeftFrames;
    private Array<TextureRegion> _walkRightFrames;
    private Array<TextureRegion> _walkUpFrames;
    private Array<TextureRegion> _walkDownFrames;

    protected Vector2 _nextPlayerPosition;
    protected Vector2 _currentPlayerPosition;
    protected State _state = State.IDLE;
    protected float _frameTime = 0f;
    protected Sprite _frameSprite = null;
    protected TextureRegion _currentFrame = null;

    public final int FRAME_WIDTH = 16;
    public final int FRAME_HEIGHT = 16;
    public static Rectangle boundingBox;

    public PlayerDeck deck;


    public enum State {
        IDLE, WALKING, DEAD, ALIVE;
    }

    public enum Direction {
        UP, RIGHT, DOWN, LEFT;
    }

    public Player() {
        initPlayer();
    }

    public void initPlayer() {

        this._entityID = UUID.randomUUID().toString();
        this._nextPlayerPosition = new Vector2();
        this._currentPlayerPosition = new Vector2();
        this.boundingBox = new Rectangle();
        this._velocity = new Vector2(2f, 2f);

        Utility.loadTextureAsset(_defaultSpritePath);
        loadDefaultSprite();
        loadAllAnimations();
    }

    public void update(float delta) {
        _frameTime = (_frameTime + delta) % 5;

        setBoundingBoxSize(0f, 0.5f);
    }
    public void setBoundingBoxSize(float percentageWidthReduced, float percentageHeightReduced) {
        float width;
        float height;

        float widthReductionAmount = 1.0f - percentageWidthReduced;

        float heightReductionAmount = 1.0f - percentageHeightReduced;

        if (widthReductionAmount > 0 && widthReductionAmount < 1) {
            width = FRAME_WIDTH * widthReductionAmount;
        } else {
            width = FRAME_WIDTH;
        }

        if (heightReductionAmount > 0 && heightReductionAmount < 1) {
            height = FRAME_HEIGHT * heightReductionAmount;
        } else {
            height = FRAME_HEIGHT;
        }
        if (width == 0 || height == 0) {
            Gdx.app.debug(TAG, "Width and Height are 0!! " + width + ":" + height);
        }
    }

    public void init(float startX, float startY) {
        this._currentPlayerPosition.x = startX;
        this._currentPlayerPosition.y = startY;

        this._nextPlayerPosition.x = startX;
        this._nextPlayerPosition.y = startY;
    }



    private void loadDefaultSprite() {
        Texture texture = Utility.getTextureAsset(_defaultSpritePath);
        TextureRegion[][] textureFrames = TextureRegion.split(texture, FRAME_WIDTH, FRAME_HEIGHT);
        _frameSprite = new Sprite(textureFrames[0][0].getTexture(), 0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        _currentFrame = textureFrames[0][0];
    }

    private void loadAllAnimations() {
        Texture texture = Utility.getTextureAsset(_defaultSpritePath);
        TextureRegion[][] textureFrames = TextureRegion.split(texture, FRAME_WIDTH, FRAME_HEIGHT);
        _walkDownFrames = new Array<TextureRegion>(4);
        _walkLeftFrames = new Array<TextureRegion>(4);
        _walkRightFrames = new Array<TextureRegion>(4);
        _walkUpFrames = new Array<TextureRegion>(4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                TextureRegion region = textureFrames[i][j];
                if (region == null) {
                    Gdx.app.debug(TAG, "Got null animation frame " + i + "," + j);
                }
                switch (i)
                {
                    case 0:
                        _walkDownFrames.insert(j, region);
                        break;
                    case 1:
                        _walkLeftFrames.insert(j, region);
                        break;
                    case 2:
                        _walkRightFrames.insert(j, region);
                        break;
                    case 3:
                        _walkUpFrames.insert(j, region);
                        break;
                    default:
                        break;
                }
            }
        }
        _walkDownAnimation = new Animation(0.25f, _walkDownFrames, Animation.PlayMode.LOOP);
        _walkLeftAnimation = new Animation(0.25f, _walkLeftFrames, Animation.PlayMode.LOOP);
        _walkRightAnimation = new Animation(0.25f, _walkRightFrames, Animation.PlayMode.LOOP);
        _walkUpAnimation = new Animation(0.25f, _walkUpFrames, Animation.PlayMode.LOOP);


    }
    public void dispose() {
        Utility.unloadAssets(_defaultSpritePath);
    }
    public void setState(State state){
        this._state = state;
    }
    public Sprite getFrameSprite() {
        return _frameSprite;
    }
    public TextureRegion getFrame() {
        return _currentFrame;
    }
    public Vector2 getCurrentPosition() {
        return _currentPlayerPosition;
    }
    public void setCurrentPosition(float currentPositionX, float currentPositionY){
        _frameSprite.setX(currentPositionX);
        _frameSprite.setY(currentPositionY);
        this._currentPlayerPosition.x = currentPositionX;
        this._currentPlayerPosition.y = currentPositionY;

    }

    public void setDirection(Direction direction, float deltaTime) {
        this._previousDirection = this._currentDirection;
        this._currentDirection = direction;

        switch (_currentDirection) {
            case UP:
                _currentFrame = (TextureRegion) _walkUpAnimation.getKeyFrame(_frameTime);
                break;
            case RIGHT:
                _currentFrame = (TextureRegion) _walkRightAnimation.getKeyFrame(_frameTime);
                break;
            case DOWN:
                _currentFrame = (TextureRegion) _walkDownAnimation.getKeyFrame(_frameTime);
                break;
            case LEFT:
                _currentFrame = (TextureRegion) _walkLeftAnimation.getKeyFrame(_frameTime);
                break;
            default:
                break;
        }
    }
    public void setNextPositionToCurrent() {
        setCurrentPosition(_nextPlayerPosition.x, _nextPlayerPosition.y);
    }

    public void calculateNextPosition(Direction currentDirection, float deltaTime){
        float testX = _currentPlayerPosition.x;
        float testY = _currentPlayerPosition.y;

        _velocity.scl(deltaTime);

        switch(currentDirection){
            case UP:
                testY += _velocity.y;
                break;
            case RIGHT:
                testX += _velocity.x;
                break;
            case DOWN:
                testY -= _velocity.y;
                break;
            case LEFT:
                testX -= _velocity.x;
                break;
            default:
                break;
        }

        _nextPlayerPosition.x = testX;
        _nextPlayerPosition.y = testY;

        _velocity.scl(1/deltaTime);
    }

    public PlayerDeck getDeck() {
        return deck;
    }
    public Vector2 getPosition() {
        return _currentPlayerPosition;
    }

}


