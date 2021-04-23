package inf112.RoboRally.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.RoboRally.app.RoboRally;
import org.lwjgl.opengl.GL20;

public class MultiPlayerMenu implements Screen {

    private RoboRally parent;
    private Stage stage;

    public MultiPlayerMenu(RoboRally roboRally){
        parent = roboRally;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("Robo Rally/src/assets/skin/tracer-ui.json"));

        TextButton host = new TextButton("Host",skin);
        TextButton client = new TextButton("Client", skin);
        TextButton back = new TextButton("Back", skin);

        table.add(host).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(client).fillX().uniformX();
        table.row();
        table.add(back).fillX().uniformX();

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(RoboRally.MENU);
            }
        });

        host.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(RoboRally.HOST);
            }
        });

        client.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(RoboRally.CLIENT);
            }
        });
        }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f,0f,0f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(),1/30f));
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

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
