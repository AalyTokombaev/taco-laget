package inf112.RoboRally.app.HUD;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.Cards.CardInitializer;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Objects.Player;

import java.io.IOException;
import java.util.ArrayList;

public class CardViewer {

    private final Player player;
    private final Stage stage;
    private final Viewport viewport;
    private final OrthographicCamera cam;

    public CardViewer(SpriteBatch spriteBatch, Player player) {
        cam = new OrthographicCamera();
        viewport = new FitViewport(15, 15, cam); // Define aspect ratio window
        stage = new Stage(viewport, spriteBatch); // create stage with the viewport and the batch given in constructor
        this.player = player;
        buildMenu();
    }

    public void buildMenu() {
        // Create tables to set their positions (x,y)
        ArrayList<Table> tableList = new ArrayList<Table>();
        ArrayList<Table> containerList = new ArrayList<Table>();
        ArrayList<Table> tableContainer = new ArrayList<Table>();
        ArrayList<Image> imageList = new ArrayList<Image>();
        ArrayList<ProgramCard> stack = new ArrayList();
        //Stack stack = new Stack();

        for(int i=0;i<9;i++){
            Table table = new Table();
            Table container = new Table();
            table.left().bottom();
            tableList.add(table);
            containerList.add(container);

        }

        // Try to load textures of the move cards in the game (Visual player deck)
        try {
            // Initialize a list of ProgramCards that holds all the cards in the game
            CardInitializer cards = new CardInitializer();
            cards.shuffle();

            // Draw cards from the shuffled list of cards

            for(int x = 0;x<9;x++){
                stack.add(cards.deal());

            }

            // Use the card information to load textures

            for(int j=0;j<stack.size();j++){
                ProgramCard card = stack.get(j);
                Texture texture = new Texture(card.getFilename());
                Image image = new Image(texture);
                Table table = new Table();
                Table container = new Table();
                image.setSize(1.667f,3f);
                imageList.add(image);
                table = tableList.get(j);
                container = containerList.get(j);
                container.addActor(imageList.get(j));
                table.add(container);
                tableContainer.add(table);

                //stack.push(card);

            }

            // Set table positions to correctly align encapsulated images
            float w = 0f;
            float h = 12f;
            for (Table table : tableList) {
                table.setPosition(w, h);
                stage.addActor(table);
                w = w + 1.66667f;
            }

             /*
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
            });*/
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

