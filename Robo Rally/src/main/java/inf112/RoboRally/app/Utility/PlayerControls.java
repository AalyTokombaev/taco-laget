package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Player.Player;

import java.util.HashMap;
import java.util.Map;


//Adopted from Mastering libgdx game development by Patrick Hoey

public class PlayerControls implements InputProcessor {

    private static final Map<Keys, Boolean> keynum = new HashMap<Keys, Boolean>();

    enum Keys {
        LEFT, RIGHT, UP, DOWN, QUIT
    }

    static {
        keynum.put(Keys.LEFT, false);
        keynum.put(Keys.RIGHT, false);
        keynum.put(Keys.UP, false);
        keynum.put(Keys.DOWN, false);
        keynum.put(Keys.QUIT, false);

    }


    private final Player player;
    private final GameLogic logic;


    public PlayerControls(Player player, GameLogic logic) {

        this.player = player;
        this.logic = logic;

    }

    public static void hide() {
        keynum.put(Keys.LEFT, false);
        keynum.put(Keys.RIGHT, false);
        keynum.put(Keys.UP, false);
        keynum.put(Keys.DOWN, false);
        keynum.put(Keys.QUIT, false);
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.A) {
            this.leftPressed();
        }
        if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.D) {
            this.rightPressed();
        }
        if (keycode == Input.Keys.UP || keycode == Input.Keys.W) {
            this.upPressed();
        }
        if (keycode == Input.Keys.DOWN || keycode == Input.Keys.S) {
            this.downPressed();
        }
        if (keycode == Input.Keys.Q) {
            this.quitPressed();
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.A) {
            this.leftReleased();
        }
        if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.D) {
            this.rightReleased();
        }
        if (keycode == Input.Keys.UP || keycode == Input.Keys.W) {
            this.upReleased();
        }
        if (keycode == Input.Keys.DOWN || keycode == Input.Keys.S) {
            this.downReleased();
        }
        if (keycode == Input.Keys.Q) {
            this.quitReleased();
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }


    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    public void leftPressed() {
        keynum.put(Keys.LEFT, true);
    }

    public void rightPressed() {
        keynum.put(Keys.RIGHT, true);
    }

    public void upPressed() {
        keynum.put(Keys.UP, true);
    }

    public void downPressed() {
        keynum.put(Keys.DOWN, true);
    }

    public void quitPressed() {
        keynum.put(Keys.QUIT, true);
    }

    public void leftReleased() {
        keynum.put(Keys.LEFT, false);
    }

    public void rightReleased() {
        keynum.put(Keys.RIGHT, false);
    }

    public void downReleased() {
        keynum.put(Keys.DOWN, false);
    }

    public void upReleased() {
        keynum.put(Keys.UP, false);
    }

    public void quitReleased() {
        keynum.put(Keys.QUIT, false);
    }


    public void update() {
        processInput();
    }

    public void processInput() {

        Vector2 nextPos = player.getPosition().cpy();

        // Checks if the cell the player is moving to is blocked by walls, either by a wall
        // on the "future" cell or the current cell

        if (keynum.get(Keys.LEFT)) {
            if (!logic.dirChecker(nextPos.add(-1, 0)).contains("EAST")
                    && !logic.dirChecker(player.getPosition()).contains("WEST")) {
                player.setPosition(-1, 0);
            }
        }
        if (keynum.get(Keys.RIGHT)) {
            if (!logic.dirChecker(nextPos.add(1, 0)).contains("WEST")
                    && !logic.dirChecker(player.getPosition()).contains("EAST")) {
                player.setPosition(1, 0);
            }
        }
        if (keynum.get(Keys.UP)) {
            if (!logic.dirChecker(nextPos.add(0, 1)).contains("SOUTH")
                    && !logic.dirChecker(player.getPosition()).contains("NORTH")) {
                player.setPosition(0, 1);
            }
        }
        if (keynum.get(Keys.DOWN)) {
            if (!logic.dirChecker(nextPos.add(0, -1)).contains("NORTH")
                    && !logic.dirChecker(player.getPosition()).contains("SOUTH")) {
                player.setPosition(0, -1);
            }
        } else if (keynum.get(Keys.QUIT)) {
            Gdx.app.exit();
        }

    }
}
