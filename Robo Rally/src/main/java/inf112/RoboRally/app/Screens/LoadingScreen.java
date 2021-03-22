package inf112.RoboRally.app.Screens;

import com.badlogic.gdx.Screen;
import inf112.RoboRally.app.RoboRally;

public class LoadingScreen implements Screen {

    private final RoboRally parent;

    public LoadingScreen(RoboRally roboRally){
        parent = roboRally;
    }

    @Override
    public void show() {
        parent.changeScreen(RoboRally.MENU);
    }

    @Override
    public void render(float v) {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
