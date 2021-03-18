package inf112.RoboRally.app;

import Views.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//https://www.gamedevelopment.blog/full-libgdx-game-tutorial-menu-control/

public class RoboRally extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    private LoadingScreen loadingScreen;
    private PreferenceScreen preferencesScreen;
    private MenuScreen menuScreen;
    private RoboRallyBeta mainScreen;
    private EndScreen endScreen;
    private AppPreferences preferences;

    public final static int MENU =0;
    public final static int PREFERENCES=1;
    public final static int APPLICATION=2;
    public final static int ENDGAME =3;


    public void changeScreen(int screen) {
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferenceScreen(this);
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if(mainScreen == null) mainScreen = new RoboRallyBeta(this);
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen(this);
                this.setScreen(endScreen);
                break;
        }
    }

    @Override
    public void create() {
            preferences = new AppPreferences();
            loadingScreen = new LoadingScreen(this);
            setScreen(loadingScreen);
        }

    public AppPreferences getPreferences(){
        return this.preferences;
    }

    @Override
    public void render(){
        super.render();
    }

    public void dispose(){
        mainScreen.dispose();

    }
}
