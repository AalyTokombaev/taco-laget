package inf112.RoboRally.app.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
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
        Table table1 = new Table();
        table1.left().bottom();
        Table container = new Table();
        Table container1 = new Table();
        Texture move1 = new Texture("Move 1.jpg");
        Texture move2 = new Texture("Move 2.jpg");
        Texture move3 = new Texture("Move 3.jpg");
        Texture backUp = new Texture("Back-Up.jpg");
        Texture uTurn = new Texture("U-Turn.jpg");
        Texture rotateRight = new Texture("RotateRight.jpg");
        Texture rotateLeft = new Texture("RotateLeft.jpg");
        Image move1Image = new Image(move1);
        Image move2Image = new Image(move2);
        Image move3Image = new Image(move3);
        Image backUpImage = new Image(backUp);
        Image uTurnImage = new Image(uTurn);
        Image rotateRightImage = new Image(rotateRight);
        Image rotateLeftImage = new Image(rotateLeft);
        container.addActor(move2Image);
        container1.addActor(move1Image);
        move2Image.setSize(1.5f,3f);
        move1Image.setSize(1.5f,3f);
        move2Image.addListener(new ClickListener());


        table.add(container).width(1.5f).height(3f);

        table1.add(container1).width(1.5f).height(3f);

        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);
        table.add().size(1.5f, 3f);

        table1.setPosition(1.5f, 12f);
        table.setPosition(0f, 12f);
        table1.setDebug(true);
        table.setDebug(true);
        stage.addActor(table);
        stage.addActor(table1);


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
