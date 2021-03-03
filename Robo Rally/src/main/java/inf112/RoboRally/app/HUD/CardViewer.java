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
import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Objects.Player;

import java.io.IOException;

public class CardViewer {

    private Player player;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera cam;

    public CardViewer(SpriteBatch spriteBatch, Player player) {
        cam = new OrthographicCamera();
        viewport = new FitViewport(15, 15, cam); // Define aspect ratio window
        stage = new Stage(viewport, spriteBatch); // create stage with the viewport and the batch given in constructor
        this.player = player;
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

        Table table10 = new Table();
        table10.left().bottom();
        Table table11 = new Table();
        table11.left().bottom();
        Table table12 = new Table();
        table12.left().bottom();
        Table table13 = new Table();
        table13.left().bottom();
        Table table14 = new Table();
        table14.left().bottom();
        Table table15 = new Table();
        table15.left().bottom();
        Table table16 = new Table();
        table16.left().bottom();
        Table table17 = new Table();
        table17.left().bottom();
        Table table18 = new Table();
        table18.left().bottom();
        Table table19 = new Table();
        table19.left().bottom();
        Table table20 = new Table();
        table20.left().bottom();
        Table table21 = new Table();
        table21.left().bottom();
        Table table22 = new Table();
        table22.left().bottom();
        Table table23 = new Table();
        table23.left().bottom();
        Table table24 = new Table();
        table24.left().bottom();


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

        Table container10 = new Table();
        Table container11 = new Table();
        Table container12 = new Table();
        Table container13 = new Table();
        Table container14 = new Table();
        Table container15 = new Table();
        Table container16 = new Table();
        Table container17 = new Table();
        Table container18 = new Table();
        Table container19 = new Table();
        Table container20 = new Table();
        Table container21 = new Table();
        Table container22 = new Table();
        Table container23 = new Table();
        Table container24 = new Table();


        // Try to load textures of the move cards in the game (Visual player deck)
        try {
            // Initialize a list of ProgramCards that holds all the cards in the game
            CardInitializer cards = new CardInitializer();
            cards.shuffle();

            // Draw cards from the shuffled list of cards
            ProgramCard card1 = cards.deal();
            ProgramCard card2 = cards.deal();
            ProgramCard card3 = cards.deal();
            ProgramCard card4 = cards.deal();
            ProgramCard card5 = cards.deal();
            ProgramCard card6 = cards.deal();
            ProgramCard card7 = cards.deal();
            ProgramCard card8 = cards.deal();
            ProgramCard card9 = cards.deal();

            // Use the card information to load textures
            Texture texture1 = new Texture(card1.getFilename());
            Texture texture2 = new Texture(card2.getFilename());
            Texture texture3 = new Texture(card3.getFilename());
            Texture texture4 = new Texture(card4.getFilename());
            Texture texture5 = new Texture(card5.getFilename());
            Texture texture6 = new Texture(card6.getFilename());
            Texture texture7 = new Texture(card7.getFilename());
            Texture texture8 = new Texture(card8.getFilename());
            Texture texture9 = new Texture(card9.getFilename());

            Texture texture10 = new Texture("DamageToken.jpg");
            Texture texture11 = new Texture("PowerDown.jpg");
            Texture texture12 = new Texture("lifeToken.jpg");

            // Create images to hold textures
            Image image1 = new Image(texture1);
            Image image2 = new Image(texture2);
            Image image3 = new Image(texture3);
            Image image4 = new Image(texture4);
            Image image5 = new Image(texture5);
            Image image6 = new Image(texture6);
            Image image7 = new Image(texture7);
            Image image8 = new Image(texture8);
            Image image9 = new Image(texture9);

            Image image10 = new Image(texture11);
            Image image11 = new Image();
            Image image12 = new Image(texture12);
            Image image13 = new Image(texture12);
            Image image14 = new Image(texture12);
            Image image15 = new Image();
            Image image16 = new Image(texture10);
            Image image17 = new Image(texture10);
            Image image18 = new Image(texture10);
            Image image19 = new Image(texture10);
            Image image20 = new Image(texture10);
            Image image21 = new Image(texture10);
            Image image22 = new Image(texture10);
            Image image23 = new Image(texture10);
            Image image24 = new Image(texture10);


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

            container10.addActor(image10);
            container11.addActor(image11);
            container12.addActor(image12);
            container13.addActor(image13);
            container14.addActor(image14);
            container15.addActor(image15);
            container16.addActor(image16);
            container17.addActor(image17);
            container18.addActor(image18);
            container19.addActor(image19);
            container20.addActor(image20);
            container21.addActor(image21);
            container22.addActor(image22);
            container23.addActor(image23);
            container24.addActor(image24);


            // Downscale massive images (resizing to fit)
            image1.setSize(1.667f, 2f);
            image2.setSize(1.667f, 2f);
            image3.setSize(1.667f, 2f);
            image4.setSize(1.667f, 2f);
            image5.setSize(1.667f, 2f);
            image6.setSize(1.667f, 2f);
            image7.setSize(1.667f, 2f);
            image8.setSize(1.667f, 2f);
            image9.setSize(1.667f, 2f);

            image10.setSize(1f, 1f);
            image11.setSize(1f, 1f);
            image12.setSize(1f, 1f);
            image13.setSize(1f, 1f);
            image14.setSize(1f, 1f);
            image15.setSize(1f, 1f);
            image16.setSize(1f, 1f);
            image17.setSize(1f, 1f);
            image18.setSize(1f, 1f);
            image19.setSize(1f, 1f);
            image20.setSize(1f, 1f);
            image21.setSize(1f, 1f);
            image22.setSize(1f, 1f);
            image21.setSize(1f, 1f);
            image22.setSize(1f, 1f);
            image23.setSize(1f, 1f);
            image24.setSize(1f, 1f);

            // Add containers to table
            table1.add(container1).width(1.667f).height(2f);
            table2.add(container2).width(1.667f).height(2f);
            table3.add(container3).width(1.667f).height(2f);
            table4.add(container4).width(1.667f).height(2f);
            table5.add(container5).width(1.667f).height(2f);
            table6.add(container6).width(1.667f).height(2f);
            table7.add(container7).width(1.667f).height(2f);
            table8.add(container8).width(1.667f).height(2f);
            table9.add(container9).width(1.667f).height(2f);

            table10.add(container10).width(1f).height(1f);
            table11.add(container11).width(1f).height(1f);
            table12.add(container12).width(1f).height(1f);
            table13.add(container13).width(1f).height(1f);
            table14.add(container14).width(1f).height(1f);
            table15.add(container15).width(1f).height(1f);
            table16.add(container16).width(1f).height(1f);
            table17.add(container17).width(1f).height(1f);
            table18.add(container18).width(1f).height(1f);
            table19.add(container19).width(1f).height(1f);
            table20.add(container20).width(1f).height(1f);
            table21.add(container21).width(1f).height(1f);
            table22.add(container22).width(1f).height(1f);
            table23.add(container23).width(1f).height(1f);
            table24.add(container24).width(1f).height(1f);

            // Set table positions to correctly align encapsulated images
            table1.setPosition(0f, 13f);
            table2.setPosition(1.66667f, 13f);
            table3.setPosition(3.33333f, 13f);
            table4.setPosition(5f, 13f);
            table5.setPosition(6.66667f, 13f);
            table6.setPosition(8.33333f, 13f);
            table7.setPosition(10f, 13f);
            table8.setPosition(11.66667f, 13f);
            table9.setPosition(13.33333f, 13f);

            table10.setPosition(0f, 12f);
            table11.setPosition(1f, 12f);
            table12.setPosition(2f, 12f);
            table13.setPosition(3f, 12f);
            table14.setPosition(4f, 12f);
            table15.setPosition(5f, 12f);
            table16.setPosition(6f, 12f);
            table17.setPosition(7f, 12f);
            table18.setPosition(8f, 12f);
            table19.setPosition(9f, 12f);
            table20.setPosition(10f, 12f);
            table21.setPosition(11f, 12f);
            table22.setPosition(12f, 12f);
            table23.setPosition(13f, 12f);
            table24.setPosition(14f, 12f);

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

            stage.addActor(table10);
            stage.addActor(table11);
            stage.addActor(table12);
            stage.addActor(table13);
            stage.addActor(table14);
            stage.addActor(table15);
            stage.addActor(table16);
            stage.addActor(table17);
            stage.addActor(table18);
            stage.addActor(table19);
            stage.addActor(table20);
            stage.addActor(table21);
            stage.addActor(table22);
            stage.addActor(table23);
            stage.addActor(table24);

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
            table10.setDebug(true);
            table11.setDebug(true);
            table12.setDebug(true);
            table13.setDebug(true);
            table14.setDebug(true);
            table15.setDebug(true);
            table16.setDebug(true);
            table17.setDebug(true);
            table18.setDebug(true);
            table19.setDebug(true);
            table20.setDebug(true);
            table21.setDebug(true);
            table22.setDebug(true);
            table23.setDebug(true);
            table24.setDebug(true);
             */


            // Add ClickListeners to register clicks inside tables
            table1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card1);
                    System.out.println("clicked1!");
                }
            });
            image2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card2);
                    System.out.println("clicked2!");
                }
            });
            image3.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card3);
                    System.out.println("clicked3!");
                }
            });
            image4.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card4);
                    System.out.println("clicked4!");
                }
            });
            image5.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card5);
                    System.out.println("clicked5!");
                }
            });
            image6.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card6);
                    System.out.println("clicked6!");
                }
            });
            image7.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card7);
                    System.out.println("clicked7!");
                }
            });
            image8.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card8);
                    System.out.println("clicked8!");
                }
            });
            image9.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    player.getDeck().takeCard(card9);
                    System.out.println("clicked9!");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
