package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import inf112.RoboRally.app.Player.Player;

import java.util.HashMap;
import java.util.Map;


//Adopted from Mastering libgdx game development by Patrick Hoey

public class Controls2 implements InputProcessor {

    private static final Map<Keys, Boolean> keynum = new HashMap<Keys, Boolean>();
    private static final Map<Mouse, Boolean> mousenum = new HashMap<Mouse, Boolean>();

    static {
        keynum.put(Keys.LEFT, false);
        keynum.put(Keys.RIGHT, false);
        keynum.put(Keys.UP, false);
        keynum.put(Keys.DOWN, false);
        keynum.put(Keys.QUIT, false);

    }

    static {
        mousenum.put(Mouse.SELECT, false);
        mousenum.put(Mouse.DOACTION, false);
    }

    private final Vector3 lastMouseCoord;
    private final Player player;
    private final GameLogic logic;

    public Controls2(Player player, GameLogic logic) {
        this.lastMouseCoord = new Vector3();
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
    public boolean touchDown(int i, int i1, int i2, int i3) {
        if (i3 == Input.Buttons.LEFT || i3 == Input.Buttons.RIGHT) {
            this.setClickedMouseCoordinates(i, i1);
        }
        if (i3 == Input.Buttons.LEFT) {
            this.selectMouseButtonPressed(i, i1);
        }
        if (i3 == Input.Buttons.RIGHT) {
            this.doActionMouseButtonPressed(i, i1);
        }

        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        if (i3 == Input.Buttons.LEFT) {
            this.selectMouseButtonReleased(i, i1);
        }
        if (i3 == Input.Buttons.RIGHT) {
            this.doActionMouseButtonPressed(i, i1);
        }
        return true;
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

    public void setClickedMouseCoordinates(int x, int y) {
        lastMouseCoord.set(x, y, 0);
    }

    public void selectMouseButtonPressed(int x, int y) {
        mousenum.put(Mouse.SELECT, true);
    }

    public void doActionMouseButtonPressed(int x, int y) {
        mousenum.put(Mouse.DOACTION, true);
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

    public void selectMouseButtonReleased(int x, int y) {
        mousenum.put(Mouse.SELECT, false);
    }

    public void doActionMouseButtonsReleased(int x, int y) {
        mousenum.put(Mouse.DOACTION, false);
    }

    public void update(float delta) {
        processInput(delta);
    }

    public void processInput(float delta) {

        //deltatime passed to function for potential future use
        //TODO get quit-function to work...

        Vector2 nextPos = player.getPosition();
        if(logic.outOfBounds(nextPos)){

            System.out.println("out of bounds");
            downReleased();
            upReleased();
            leftReleased();
            rightReleased();
        }

        if (keynum.get(Keys.LEFT)) {
            if (!logic.DirChecker(nextPos.add(-1, 0)).contains("EAST")
                    && !logic.DirChecker(player.getPosition()).contains("WEST")) {
                player.setCurrentPosition(-1, 0);
            }
        }
        if (keynum.get(Keys.RIGHT)) {
            if (!logic.DirChecker(nextPos.add(1, 0)).contains("WEST")
                    && !logic.DirChecker(player.getPosition()).contains("EAST")) {
                player.setCurrentPosition(1, 0);
            }
        }
        if (keynum.get(Keys.UP)) {
            if (!logic.DirChecker(nextPos.add(0, 1)).contains("SOUTH")
                    && !logic.DirChecker(player.getPosition()).contains("NORTH")) {
                player.setCurrentPosition(0, 1);
            }
        }
        if (keynum.get(Keys.DOWN)) {
            if (!logic.DirChecker(nextPos.add(0, -1)).contains("NORTH")
                    && !logic.DirChecker(player.getPosition()).contains("SOUTH")) {
                player.setCurrentPosition(0, -1);
            }
        } else if (keynum.get(Keys.QUIT)) {
            Gdx.app.exit();
        }
        if (mousenum.get(Mouse.SELECT)) {
            mousenum.put(Mouse.SELECT, false);
        }
    }

    enum Keys {
        LEFT, RIGHT, UP, DOWN, QUIT
    }

    enum Mouse {
        SELECT, DOACTION
    }
}
