package inf112.RoboRally.app.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Cards.TestCardActor;
import inf112.RoboRally.app.Player.Player;

import java.io.IOException;

public class TestUI {

    private final Stage stage;
    private final Player player;
    private final OrthographicCamera cam;
    private final Viewport viewport;
    private Table table;
    private HorizontalGroup cardContainer, otherContainer;
    //private Dealer dealer;
    private TestCardActor[] deck;
    private CardInitializer cards;

    public TestUI(SpriteBatch sb, Player player) {
        cam = new OrthographicCamera();
        viewport = new FitViewport(15, 15, cam); // Define aspect ratio window
        stage = new Stage(viewport, sb); // create stage with the viewport and the batch given in constructor
        this.player = player;
        try {
            cards = new CardInitializer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gdx.input.setInputProcessor(stage);
        initDeck();


    }

    public void initDeck() {
        cards.shuffle();
        deck = new TestCardActor[9];
        cardContainer = new HorizontalGroup();
        cardContainer.center();
        for (int x = 0; x < 9; x++) {
            deck[x] = new TestCardActor(cards.deal());
            cardContainer.addActor(deck[x]);
            cardContainer.setPosition(8f,13f);
            cardContainer.space(0);

        }
        stage.addActor(cardContainer);
        otherContainer = new HorizontalGroup();


    }


    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }


    public void draw() {
        stage.act();
        stage.draw();

    }

    public Stage getStage() {
        return stage;
    }

}
