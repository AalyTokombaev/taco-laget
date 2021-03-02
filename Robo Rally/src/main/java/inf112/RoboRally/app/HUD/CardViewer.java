package inf112.RoboRally.app.HUD;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
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
    // Potential boolean variables in order for a player to pick 5/x cards to playerDeck
    private boolean first, second, third, fourth, fifth, sixth, seventh, eighth, ninth;
    private OrthographicCamera cam;

    public CardViewer(SpriteBatch spriteBatch) {
        cam = new OrthographicCamera();
        viewport = new FitViewport(15, 15, cam);
        stage = new Stage(viewport, spriteBatch); // create stage with the viewport and the batch given in constructor
        buildMenu();

    }

    public void buildMenu() {
        // Create tables to set their positions (x,y)
        Table table1 = new Table();
        table1.left().bottom();
        Table table2 = new Table();
        table2.left().bottom();
        Table table3 = new Table();
        table3.left().bottom();
        Table table4 = new Table();
        table4.left().bottom();
        Table table5 = new Table();
        table5.left().bottom();
        Table table6 = new Table();
        table6.left().bottom();
        Table table7 = new Table();
        table7.left().bottom();
        Table table8 = new Table();
        table8.left().bottom();
        Table table9 = new Table();
        table9.left().bottom();

        // Create containers (tables) to make the contents FIT the other tables
        Table container1 = new Table();
        Table container2 = new Table();
        Table container3 = new Table();
        Table container4 = new Table();
        Table container5 = new Table();
        Table container6 = new Table();
        Table container7 = new Table();
        Table container8 = new Table();
        Table container9 = new Table();

        // Load the textures of the move cards in the game (with fixed priority number :s)
        Texture move1 = new Texture("Move 1.jpg");
        Texture move2 = new Texture("Move 2.jpg");
        Texture move3 = new Texture("Move 3.jpg");
        Texture backUp = new Texture("Back-Up.jpg");
        Texture uTurn = new Texture("U-Turn.jpg");
        Texture rotateRight = new Texture("RotateRight.jpg");
        Texture rotateLeft = new Texture("RotateLeft.jpg");

        // Create images
        Image image1 = new Image(move1);
        Image image2 = new Image(move2);
        Image image3 = new Image(move3);
        Image image4 = new Image(backUp);
        Image image5 = new Image(uTurn);
        Image image6 = new Image(rotateRight);
        Image image7 = new Image(rotateLeft);
        Image image8 = new Image(move1);
        Image image9 = new Image(move2);

        // Encapsulate images in containers
        container1.addActor(image1);
        container2.addActor(image2);
        container3.addActor(image3);
        container4.addActor(image4);
        container5.addActor(image5);
        container6.addActor(image6);
        container7.addActor(image7);
        container8.addActor(image8);
        container9.addActor(image9);

        // Downscale massive images (resizing to fit)
        image1.setSize(1.5f, 3f);
        image2.setSize(1.5f, 3f);
        image3.setSize(1.5f, 3f);
        image4.setSize(1.5f, 3f);
        image5.setSize(1.5f, 3f);
        image6.setSize(1.5f, 3f);
        image7.setSize(1.5f, 3f);
        image8.setSize(1.5f, 3f);
        image9.setSize(1.5f, 3f);

        // Add containers to table
        table1.add(container1).width(1.5f).height(3f);
        table2.add(container2).width(1.5f).height(3f);
        table3.add(container3).width(1.5f).height(3f);
        table4.add(container4).width(1.5f).height(3f);
        table5.add(container5).width(1.5f).height(3f);
        table6.add(container6).width(1.5f).height(3f);
        table7.add(container7).width(1.5f).height(3f);
        table8.add(container8).width(1.5f).height(3f);
        table9.add(container9).width(1.5f).height(3f);

        // Set table positions to correctly align encapsulated images
        table1.setPosition(0f, 12f);
        table2.setPosition(1.5f, 12f);
        table3.setPosition(3f, 12f);
        table4.setPosition(4.5f, 12f);
        table5.setPosition(6f, 12f);
        table6.setPosition(7.5f, 12f);
        table7.setPosition(9f, 12f);
        table8.setPosition(10.5f, 12f);
        table9.setPosition(12f, 12f);

        // Add actors to stage to enable inputProcessor to register clicks
        stage.addActor(table1);
        stage.addActor(table2);
        stage.addActor(table3);
        stage.addActor(table4);
        stage.addActor(table5);
        stage.addActor(table6);
        stage.addActor(table7);
        stage.addActor(table8);
        stage.addActor(table9);

        /**
        table1.setDebug(true);
        table2.setDebug(true);
        table3.setDebug(true);
        table4.setDebug(true);
        table5.setDebug(true);
        table6.setDebug(true);
        table7.setDebug(true);
        table8.setDebug(true);
        table9.setDebug(true);
         */

        // Add ClickListeners to register clicks inside tables
        table1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                first = true;
                System.out.println("clicked1!");
            }
        });
        image2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                second = true;
                System.out.println("clicked2!");
            }
        });
        image3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                third = true;
                System.out.println("clicked3!");
            }
        });
        image4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fourth = true;
                System.out.println("clicked4!");
            }
        });
        image5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fifth = true;
                System.out.println("clicked5!");
            }
        });
        image6.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sixth = true;
                System.out.println("clicked6!");
            }
        });
        image7.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                seventh = true;
                System.out.println("clicked7!");
            }
        });
        image8.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                eighth = true;
                System.out.println("clicked8!");
            }
        });
        image9.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ninth = true;
                System.out.println("clicked9!");
            }
        });
    }

    public void draw() {
        stage.act();
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
