package inf112.RoboRally.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.RoboRally.app.Screens.LiveScreen;
import inf112.RoboRally.app.Screens.LoadingScreen;
import inf112.RoboRally.app.Screens.MainMenu;


public class RoboRally extends Game {

    private MainMenu mainMenu;
    private LiveScreen roboRallyGame;
    private LoadingScreen loadingScreen;
    public SpriteBatch batch;
    public BitmapFont font;

    public final static int MENU = 0;
    public final static int GAME = 1;

    //This class is the main game and controlls the screens
    public RoboRally() {

    }

    public void changeScreen(int screen) {
        switch(screen){

            case MENU:
                if(mainMenu==null) mainMenu = new MainMenu(this);
                this.setScreen(mainMenu);
                break;
            case GAME:
                if(roboRallyGame==null) roboRallyGame = new LiveScreen(this);
                this.setScreen(roboRallyGame);
                break;
        }
    }

    @Override
    public void create() {
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
        getScreen().render(Gdx.graphics.getDeltaTime());
        Gdx.graphics.setContinuousRendering(false);
        Gdx.graphics.requestRendering();


    }
    @Override
    public void render(){
        super.render();
    }
    public void dispose(){
        roboRallyGame.dispose();
    }

}

