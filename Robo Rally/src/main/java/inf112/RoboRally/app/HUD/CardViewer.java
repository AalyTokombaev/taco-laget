package inf112.RoboRally.app.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.Objects.Player;

public class CardViewer {

    private Player player;
    private Stage stage;
    private Viewport viewport;
    private boolean first, second, third, fourth, fifth, sixth, seventh, eighth, ninth;
    private OrthographicCamera cam;

    public CardViewer(SpriteBatch spriteBatch) {
        cam = new OrthographicCamera();
        viewport = new FitViewport(15, 15, cam);
        stage = new Stage(viewport, spriteBatch); // create stage with the viewport and the batch given in constructor
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.left().bottom();
        Texture texture = new Texture("button.png");
        Image buttonImage = new Image(texture);

        buttonImage.addListener(new ClickListener());

        table.add(buttonImage).size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);
        table.add().size(1.66666666667f, 3f);

        table.setPosition(0f, 12f);
        table.setDebug(true);
        stage.addActor(table);


        /**
         @Override public void clicked(InputEvent inputEvent, float x, float y) {
         System.out.println("clicked");
         }
         });
         */
    }

    public void draw() {
        stage.draw();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public Stage getStage() {
        return stage;
    }

    public void dispose() {
        stage.dispose();

    }

    public boolean isFirst() {
        return first;
    }

    public boolean isSecond() {
        return second;
    }

    public boolean isThird() {
        return third;
    }

    public boolean isFourth() {
        return fourth;
    }

    public boolean isFifth() {
        return fifth;
    }

    public boolean isSixth() {
        return sixth;
    }

    public boolean isSeventh() {
        return seventh;
    }

    public boolean isEighth() {
        return eighth;
    }

    public boolean isNinth() {
        return ninth;
    }
}
