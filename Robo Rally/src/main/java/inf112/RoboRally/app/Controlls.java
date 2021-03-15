package inf112.RoboRally.app;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

//https://www.sitepoint.com/handling-player-input-in-cross-platform-games-with-libgdx/


public class Controlls implements InputProcessor {
    public Array<keyState> keyStates = new Array<keyState>();


    public Controlls() {
        for (int i = 0; i < 256; i++) {
            keyStates.add(new keyState(i));
        }
    }

    public static class InputState{

        public boolean pressed = false;
        public boolean down = false;
        public boolean released = false;


    }
    public class keyState extends InputState{
        public int key;

        public keyState(int key){
            this.key = key;
        }
    }

    @Override
    public boolean keyDown(int i) {

        keyStates.get(i).pressed = true;
        keyStates.get(i).down = true;
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        keyStates.get(i).down = false;
        keyStates.get(i).released = true;
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
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

    public boolean isKeyPressed(int i){
        return keyStates.get(i).pressed;
    }

    public boolean isKeyDown(int i){
        return keyStates.get(i).down;
    }

    public boolean isKeyReleased(int i){
        return keyStates.get(i).released;
    }
    public void update(){
        //for every keystate, set pressed and released to false.
        for (int i = 0; i < 256; i++) {
            keyState k = keyStates.get(i);
            k.pressed = false;
            k.released = false;
        }
    }

}
