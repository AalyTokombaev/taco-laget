package inf112.RoboRally.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import inf112.skeleton.app.Player;

import java.util.HashMap;
import java.util.Map;

public class Controller implements InputProcessor {

    private final static String TAG = Controller.class.getSimpleName();


    enum Keys{
        LEFT, RIGHT, UP, DOWN, QUIT
    }
    enum Mouse{
        SELECT, DOACTION
    }

    private static Map<Keys, Boolean> keys = new HashMap<Controller.Keys, Boolean>();
    private static Map<Mouse, Boolean> mouseButtons = new HashMap<Controller.Mouse, Boolean>();
    private Vector3 lastMouseCoordinates;

    static {
        keys.put(Keys.LEFT,false);
        keys.put(Keys.RIGHT,false);
        keys.put(Keys.UP,false);
        keys.put(Keys.DOWN,false);
        keys.put(Keys.QUIT,false);
    };

    static {
        mouseButtons.put(Mouse.SELECT, false);
        mouseButtons.put(Mouse.DOACTION,false);
    };

    private Player player;

    public Controller(Player player){
        this.lastMouseCoordinates = new Vector3();
        this.player = player;
    }



    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            this.leftPressed();
        }
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            this.rightPressed();
        }if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
            this.upPressed();
        }if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            this.downPressed();
        }if(keycode == Input.Keys.Q){
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

        if(i3 == Input.Buttons.LEFT || i3 == Input.Buttons.RIGHT){
            this.setClickedMouseCoordinates(i,i1);
        }
        if(i3 == Input.Buttons.LEFT){
            this.selectMouseButtonPressed(i,i1);
        }
        if(i3 == Input.Buttons.RIGHT){
            this.doActionMouseButtonPressed(i,i1);
        }

        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {

        if(i3 == Input.Buttons.LEFT){
            this.selectMouseButtonReleased(i,i1);
        }
        if(i3 == Input.Buttons.RIGHT){
            this.doActionMouseButtonPressed(i,i1);
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
    public void dispose(){

    }

    public void leftPressed(){
        keys.put(Keys.LEFT,true);
    }
    public void rightPressed(){
        keys.put(Keys.RIGHT, true);
    }
    public void upPressed(){
        keys.put(Keys.UP,true);
    }
    public void downPressed(){
        keys.put(Keys.DOWN, true);
    }

    public void quitPressed(){
        keys.put(Keys.QUIT,true);
    }

    public void setClickedMouseCoordinates(int x, int y){
        lastMouseCoordinates.set(x,y,0);
    }
    public void selectMouseButtonPressed(int x, int y){
        mouseButtons.put(Mouse.SELECT,true);
    }
    public void doActionMouseButtonPressed(int x, int y){
        mouseButtons.put(Mouse.DOACTION,true);
    }
    public void leftReleased(){
        keys.put(Keys.LEFT, false);
    }
    public void rightReleased(){
        keys.put(Keys.RIGHT,false);
    }
    public void downReleased(){
        keys.put(Keys.DOWN, false);
    }
    public void upReleased(){
        keys.put(Keys.UP, false);
    }
    public void quitReleased(){
        keys.put(Keys.QUIT,false);
    }
    public void selectMouseButtonReleased(int x, int y){
        mouseButtons.put(Mouse.SELECT,false);
    }
    public void doActionMouseButtonsReleased(int x, int y){
        mouseButtons.put(Mouse.DOACTION,false);
    }

    public void update(float delta){
        processInput(delta);
    }

    public static void hide(){
        keys.put(Keys.LEFT,false);
        keys.put(Keys.RIGHT,false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN,false);
        keys.put(Keys.QUIT,false);
    }

    private void processInput(float delta){
        if(keys.get(Keys.LEFT)){
            player.calculateNextPosition(Player.Direction.LEFT, delta);
            player.setState(Player.State.WALKING);
            player.setDirection(Player.Direction.LEFT, delta);

        }else if (keys.get(Keys.RIGHT)) {
            player.calculateNextPosition(Player.Direction.RIGHT,delta);
            player.setState(Player.State.WALKING);
            player.setDirection(Player.Direction.RIGHT, delta);
        }else if (keys.get(Keys.UP)){
            player.calculateNextPosition(Player.Direction.UP, delta);
            player.setState(Player.State.WALKING);
            player.setDirection(Player.Direction.UP,delta);
        }else if (keys.get(Keys.DOWN)){
            player.calculateNextPosition(Player.Direction.DOWN,delta);
            player.setState(Player.State.WALKING);
            player.setDirection(Player.Direction.DOWN,delta);
        }else if(keys.get(Keys.QUIT)){
            Gdx.app.exit();
        }else{
            player.setState(Player.State.IDLE);
        }

        if(mouseButtons.get(Mouse.SELECT)){
            mouseButtons.put(Mouse.SELECT, false);
        }
    }

}
