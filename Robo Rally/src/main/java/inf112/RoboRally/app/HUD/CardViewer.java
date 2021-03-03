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

        for (int i = 0; i < 24; i++) {
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
            for (int x = 0; x < 9; x++) {
                programCards.add(cards.deal());
            }

            // Load base textures for PowerDown, DamageToken & LifeToken
            Texture texture1 = new Texture("DamageToken.jpg");
            Texture texture2 = new Texture("PowerDown.jpg");
            Texture texture3 = new Texture("LifeToken.jpg");
            float w = 0f;
            float h = 13f;
            int bw = 0;
            int bh = 12;

            // Card texture loading using ProgramCard information
            for (int j = 0; j < programCards.size(); j++) {
                ProgramCard card = programCards.get(j);
                Texture texture = new Texture(card.getFilename());
                Image image = new Image(texture);
                Table table = new Table();
                Table container = new Table();
                image.setSize(1.667f, 2f);
                imageList.add(image);
                table = tableList.get(j);
                container = containerList.get(j);
                container.addActor(imageList.get(j));
                table.add(container);
                tableContainer.add(table);
                table.setPosition(w, h);
                stage.addActor(table);
                w = w + 1.66667f;
            }

            // PowerDown texture loading
            Image powerDownImage = new Image(texture2);
            Table powerDownTable = new Table();
            Table powerDownContainer = new Table();
            powerDownImage.setSize(1f, 1f);
            imageList.add(powerDownImage);
            powerDownTable = tableList.get(9);
            powerDownContainer = containerList.get(9);
            powerDownContainer.addActor(imageList.get(9));
            powerDownTable.add(powerDownContainer);
            tableContainer.add(powerDownTable);
            powerDownTable.setPosition(bw, bh);
            stage.addActor(powerDownTable);
            bw += 1;

            // Empty texture loading
            Image emptyImage = new Image();
            Table emptyTable = new Table();
            Table emptyContainer = new Table();
            emptyImage.setSize(1f, 1f);
            imageList.add(emptyImage);
            emptyTable = tableList.get(10);
            emptyContainer = containerList.get(10);
            emptyContainer.addActor(imageList.get(10));
            emptyTable.add(emptyContainer);
            tableContainer.add(emptyTable);
            emptyTable.setPosition(bw, bh);
            stage.addActor(emptyTable);
            bw += 1;

            // LifeToken texture loading
            for (int j = 11; j < 14; j++) {
                Image image = new Image(texture3);
                Table table = new Table();
                Table container = new Table();
                image.setSize(1f, 1f);
                imageList.add(image);
                table = tableList.get(j);
                container = containerList.get(j);
                container.addActor(imageList.get(j));
                table.add(container);
                tableContainer.add(table);
                table.setPosition(bw, bh);
                stage.addActor(table);
                bw += 1;
            }

            // Empty texture loading
            Image emptyImage1 = new Image();
            Table emptyTable1 = new Table();
            Table emptyContainer1 = new Table();
            emptyImage1.setSize(1f, 1f);
            imageList.add(emptyImage1);
            emptyTable1 = tableList.get(14);
            emptyContainer1 = containerList.get(14);
            emptyContainer1.addActor(imageList.get(14));
            emptyTable.add(emptyContainer1);
            tableContainer.add(emptyTable1);
            emptyTable1.setPosition(bw, bh);
            stage.addActor(emptyTable1);
            bw += 1;

            // DamageToken texture loading
            for (int j = 15; j < 24; j++) {
                Image image = new Image(texture1);
                Table table = new Table();
                Table container = new Table();
                image.setSize(1f, 1f);
                imageList.add(image);
                table = tableList.get(j);
                container = containerList.get(j);
                container.addActor(imageList.get(j));
                table.add(container);
                tableContainer.add(table);
                table.setPosition(bw, bh);
                stage.addActor(table);
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

