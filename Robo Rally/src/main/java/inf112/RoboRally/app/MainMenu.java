package inf112.RoboRally.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenu implements Screen {

    final RoboRally game;
    OrthographicCamera camera;

    public MainMenu(final RoboRally game){

        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800,800);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0,0,0.2f,0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.draw(game.batch, "MOST IMPORTANT SCREEN IN THE GAME!!!1", 100,150);
        game.font.draw(game.batch, "Click anywhere to begin ", 100,100 );
        game.batch.end();

        if(Gdx.input.isTouched()){
            game.setScreen(new RoboRallyBeta(game));
            dispose();
        }

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
