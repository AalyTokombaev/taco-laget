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
        ArrayList<Table> tableList = new ArrayList();
        ArrayList<Table> containerList = new ArrayList();
        ArrayList<Table> tableContainer = new ArrayList();
        ArrayList<Image> imageList = new ArrayList();
        ArrayList<ProgramCard> programCards = new ArrayList();
        //TODO look into the iterator-method and look for more optimalization, maybe try to reduce the number of lists


        // Try to load textures of the move cards in the game (Visual player deck)
        try {
            // Initialize a list of ProgramCards that holds all the cards in the game
            CardInitializer cards = new CardInitializer();
            cards.shuffle();

            // Draw cards from the shuffled list of cards
            for (int x = 0; x < 9; x++) {
                programCards.add(cards.deal());
            }
            for (int i = 0; i < 24; i++) {
                Table table = new Table();
                Table container = new Table();
                table.left().bottom();
                tableList.add(table);
                containerList.add(container);
            }

            // Load base textures for PowerDown, DamageToken & LifeToken
            Texture texture1 = new Texture("DamageToken.jpg");
            Texture texture2 = new Texture("PowerDown.jpg");
            Texture texture3 = new Texture("LifeToken.jpg");
            float w = 0f;
            float h = 13f;
            int bw = 0;
            int bh = 12;
            Texture texture;
            Image image;
            ProgramCard card;

            // Card texture loading using ProgramCard information
            for (int j = 0; j < 9; j++) {
                card = programCards.get(j);
                texture = new Texture(card.getFilename());
                image = new Image(texture);
                image.setSize(1.667f, 2f);
                toBigMethod(tableList, containerList, tableContainer, imageList, w, h, image, j);
                w = w + 1.66667f;
            }

            // PowerDown texture loading
            image = new Image(texture2);
            image.setSize(1f, 1f);
            toBigMethod(tableList,containerList,tableContainer,imageList,bw,bh,image,9);
            bw += 1;
            // Empty texture loading
            //TODO see if this can be done with table.row()
            image = new Image();
            image.setSize(1f, 1f);
            toBigMethod(tableList,containerList,tableContainer,imageList,bw,bh,image,10);
            bw += 1;
            // LifeToken texture loading
            for (int j = 11; j < 14; j++) {
                image = new Image(texture3);
                image.setSize(1f, 1f);
                toBigMethod(tableList, containerList, tableContainer, imageList, bw, bh, image, j);
                bw += 1;
            }

            // Empty texture loading
            //TODO see if this can be done with table.row()
            image = new Image();
            image.setSize(1f, 1f);
            imageList.add(image);
            toBigMethod(tableList, containerList, tableContainer, imageList, bw, bh, image, 14);
            bw += 1;

            // DamageToken texture loading
            for (int j = 15; j < 24; j++) {
                image = new Image(texture1);
                image.setSize(1f, 1f);
                toBigMethod(tableList, containerList, tableContainer, imageList, bw, bh, image, j);
                bw += 1;
            }

            // Add ClickListeners to tables containing cards (making cards clickable and addable to playerDeck)
            for (int j = 0; j < programCards.size(); j++) {
                int finalJ = j;
                tableList.get(j).addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        player.getDeck().takeCard(programCards.get(finalJ));
                        System.out.println("clicked" + (finalJ + 1) + "!");
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void toBigMethod(ArrayList<Table> tableList, ArrayList<Table> containerList, ArrayList<Table> tableContainer, ArrayList<Image> imageList, float w, float h, Image image, int j) {
        Table table;
        Table container;
        imageList.add(image);
        table = tableList.get(j);
        container = containerList.get(j);
        container.addActor(imageList.get(j));
        table.add(container);
        tableContainer.add(table);
        table.setPosition(w, h);
        stage.addActor(table);
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


