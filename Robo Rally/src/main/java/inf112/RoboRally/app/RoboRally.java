package inf112.RoboRally.app;

import com.badlogic.gdx.Gdx;
import inf112.RoboRally.app.Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RoboRally extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private RoboRallyBeta mainScreen;
    public MultiPlayerMenu multiplayer;
    public HostScreen hostScreen;
    public ClientScreen clientScreen;


    public final static int MENU =0;
    public final static int MULTIPLAYER=1;
    public final static int APPLICATION=2;
    public final static int HOST =3;
    public final static  int CLIENT=4;


    public void changeScreen(int screen) {
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case APPLICATION:
                if(mainScreen == null) mainScreen = new RoboRallyBeta(this);
                this.setScreen(mainScreen);
                break;
            case MULTIPLAYER:
                if(multiplayer==null) multiplayer = new MultiPlayerMenu(this);
                this.setScreen(multiplayer);
                break;
            case HOST:
                if(hostScreen==null) hostScreen = new HostScreen(this);
                this.setScreen(hostScreen);
                break;
            case CLIENT:
                if(clientScreen==null) clientScreen = new ClientScreen(this);
                this.setScreen(clientScreen);
                break;
        }
    }

    @Override
    public void create() {
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
        getScreen().render(Gdx.graphics.getDeltaTime());
        //Gdx.graphics.setContinuousRendering(true);
        //Gdx.graphics.requestRendering();
        }

    @Override
    public void render(){
        super.render();
    }

    public void dispose(){

    }
}
