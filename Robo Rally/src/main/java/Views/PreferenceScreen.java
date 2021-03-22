package Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.RoboRally.app.RoboRally;
import org.lwjgl.opengl.GL20;

import java.util.prefs.BackingStoreException;

public class PreferenceScreen implements Screen {

    private final RoboRally parent;
    private Stage stage;
    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;

    public PreferenceScreen(RoboRally roboRally){

        parent = roboRally;
        stage = new Stage(new ScreenViewport());

        }

    @Override
    public void show() {

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(table);



        Skin skin = new Skin(Gdx.files.internal("glassy-ui.json"));

        final Slider volumeMusicSlider = new Slider(0f,1f,0.1f,false,skin);
                    volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
                    volumeMusicSlider.addListener(event -> {
                        try {
                            parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
                        } catch (BackingStoreException e) {
                            e.printStackTrace();
                        }
                        return false;
                     });

        final Slider soundMusicSlider = new Slider(0f,1f,0.1f,false,skin);
                    soundMusicSlider.setValue(parent.getPreferences().getSoundVolume());
                    soundMusicSlider.addListener(event -> {
                        try {
                            parent.getPreferences().setSoundVolume(soundMusicSlider.getValue());
                        } catch (BackingStoreException e) {
                            e.printStackTrace();
                        }
                        return false;
                    });

         final CheckBox musicCheckbox = new CheckBox(null, skin);
                    musicCheckbox.setChecked(parent.getPreferences().isMusicEnabled());
                    musicCheckbox.addListener(event -> {
                        boolean enabled = musicCheckbox.isChecked();
                        try {
                            parent.getPreferences().setMusicEnabled(enabled);
                        } catch (BackingStoreException e) {
                            e.printStackTrace();
                        }
                        return false;
                    });
        final CheckBox soundEffectsCheckbox = new CheckBox(null, skin);
                    soundEffectsCheckbox.setChecked(parent.getPreferences().isSoundEffectsEnabled());
                    soundEffectsCheckbox.addListener(event -> {
                        boolean enabled = soundEffectsCheckbox.isChecked();
                        try {
                            parent.getPreferences().setSoundEffectsEnabled(enabled);
                        } catch (BackingStoreException e) {
                            e.printStackTrace();
                        }
                        return false;
                    });





        final TextButton backButton = new TextButton("Back", skin,"small");

        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeScreen(RoboRally.MENU);
            }
        });


        titleLabel = new Label( "Preferences", skin );
        volumeMusicLabel = new Label( "Music Volume", skin );
        volumeSoundLabel = new Label( "Sound Volume", skin );
        musicOnOffLabel = new Label( "Music", skin );
        soundOnOffLabel = new Label( "Sound Effect", skin );

        table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
        table.add(volumeMusicLabel).left();
        table.add(volumeMusicSlider);
        table.row().pad(10,0,0,10);
        table.add(musicOnOffLabel).left();
        table.add(musicCheckbox);
        table.row().pad(10,0,0,10);
        table.add(volumeSoundLabel).left();
        table.add(soundMusicSlider);
        table.row().pad(10,0,0,10);
        table.add(soundOnOffLabel).left();
        table.add(soundEffectsCheckbox);
        table.row().pad(10,0,0,10);
        table.add(backButton).colspan(2);

    }





    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);
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
