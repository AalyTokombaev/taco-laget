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
import inf112.skeleton.app.Player;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is a tool to create an environment for viewing the cards relevant for the player over the game board
 * This class also acts as a second camera, made visible by utilizing the scalable aspect ratio of the game board,
 * making room for a Heads-Up-Display
 * By specifying positions by units of width and height, tables containing the textures are aligned to provide a
 * clickable graphical user interface. This user interface allows the player to select program cards,
 * further adding them to the PlayerDeck.
 * State based information like player hp, life tokens and power down are also visually represented through this class.
 */
public class CardViewer {

    /**
     * @param stage handles the viewport and distributes InputEvents to Actors (in this case the tables)
     * @param viewport handles aspect ratio and uses worldWidth and worldHeight to direct camera
     * @param cam handles the projection of the textures on screen
     */
    private final Player player;
    private final Stage stage;
    private final Viewport viewport;
    private final OrthographicCamera cam;

    /**
     * Constructs a new object of CardViewer for building a graphical user interface and loading base textures
     * Initializes a list of ProgramCards that holds all the cards in the game
     * Initializes tables and images and sets their positions in range of the camera
     *
     * @param spriteBatch use the predefined existing spriteBatch object to collect the textures and geometry to be drawn&rendered
     * @param player      use the player object to collect information concerning what to be displayed on the HUD,
     *                    also used to add cards to PlayerDeck
     */
    public CardViewer(SpriteBatch spriteBatch, Player player) {
        cam = new OrthographicCamera();
        viewport = new FitViewport(15, 15, cam); // Define aspect ratio window
        stage = new Stage(viewport, spriteBatch); // create stage with the viewport and the batch given in constructor
        this.player = player;
        buildMenu();
    }

    /**
     * Helper method called in the constructor of the CardViewer class:
     * Takes care of initializing the cards, loading textures, creating tables to contain said textures,
     * setting the positions of said tables, further adding them to the stage as Actors,
     * finally adding clickListeners to all tables (Actors) to receive inputEvents
     * <p>
     * Throws an exception if the textures fail to load
     */
    public void buildMenu() {
        ArrayList<Table> tableList = new ArrayList();
        ArrayList<Table> containerList = new ArrayList();
        ArrayList<Image> imageList = new ArrayList();
        ArrayList<ProgramCard> programCards = new ArrayList();
        //TODO look into the iterator-method and look for more optimization, maybe try to reduce the number of lists


        // Try to load textures and parse CardInfo.txt located in assets
        try {
            // Initialize a list of ProgramCards that holds all the cards in the game
            CardInitializer cards = new CardInitializer();
            cards.shuffle();
            // Load base textures for PowerDown, DamageToken & LifeToken
            Texture texture1 = new Texture("DamageToken.jpg");
            Texture texture2 = new Texture("PowerDown.jpg");
            Texture texture3 = new Texture("LifeToken.jpg");
            // Variables to keep track of distance in terms of height and width for positioning of objects
            float w = 0f;
            float h = 13f;
            int bw = 0;
            int bh = 12;
            Texture texture;
            Image image;
            ProgramCard card;

            // Draw cards from the shuffled list of cards
            for (int x = 0; x < 9; x++) {
                programCards.add(cards.deal());
            }
            // Create all tables
            for (int i = 0; i < 24; i++) {
                Table table = new Table();
                Table container = new Table();
                table.left().bottom();
                tableList.add(table);
                containerList.add(container);
            }

            // Card texture loading using ProgramCard information, make cards clickable
            for (int j = 0; j < 9; j++) {
                card = programCards.get(j);
                texture = new Texture(card.getFilename());
                image = new Image(texture);
                image.setSize(1.667f, 2f);
                builder(tableList, containerList, imageList, w, h, image, j);
                int finalJ = j;
                tableList.get(j).addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        player.getDeck().takeCard(programCards.get(finalJ));
                        System.out.println("clicked" + (finalJ + 1) + "!");
                    }
                });
                w = w + 1.66667f;
            }

            // Texture loading (PowerDown, LifeToken, DamageToken)
            for (int j = 9; j < 24; j++) {
                if (j == 9) {
                    image = new Image(texture2);
                    image.setSize(1f, 1f);
                    builder(tableList, containerList, imageList, bw, bh, image, j);
                    bw += 1;
                } else if (j == 10 || j == 14) {
                    image = new Image();
                    image.setSize(1f, 1f);
                    builder(tableList, containerList, imageList, bw, bh, image, j);
                    bw += 1;
                } else if (j < 14) {
                    image = new Image(texture3);
                    image.setSize(1f, 1f);
                    builder(tableList, containerList, imageList, bw, bh, image, j);
                    bw += 1;
                } else {
                    image = new Image(texture1);
                    image.setSize(1f, 1f);
                    builder(tableList, containerList, imageList, bw, bh, image, j);
                    bw += 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes an image, adds said image to a container, adds container to table, sets table position, adds table to stage
     *
     * @param tableList     A list of all tables to be added to stage as Actors
     * @param containerList A list of tables to contain images
     * @param imageList     A list of images containing textures
     * @param w             width in world units
     * @param h             height in world units
     * @param image         The image to be used
     * @param j             index number of object position
     */
    private void builder(ArrayList<Table> tableList, ArrayList<Table> containerList,
                         ArrayList<Image> imageList, float w, float h, Image image, int j) {
        Table table;
        Table container;
        imageList.add(image);
        table = tableList.get(j);
        container = containerList.get(j);
        container.addActor(imageList.get(j));
        table.add(container);
        table.setPosition(w, h);
        stage.addActor(table);
    }

    /**
     * Draws objects for rendering
     */
    public void draw() {
        stage.act();
        stage.draw();
    }

    /**
     * Resizes objects in correlation with window size adjustment
     *
     * @param width  worldWidth
     * @param height worldHeight
     */
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    /**
     * Disposes the loaded texture to free memory
     */
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}


