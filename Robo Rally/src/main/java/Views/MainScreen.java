package Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.RoboRally.app.RoboRally;


public class MainScreen implements Screen {

    private RoboRally parent;
    private OrthographicCamera cam;


    public MainScreen(RoboRally roboRally) {
        parent = roboRally;
        cam = new OrthographicCamera(32,24);

    }

    @Override
    public void show() {


    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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