package inf112.skeleton.app.CardTests;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.Grid.Board;
import inf112.RoboRally.app.Utility.GameLogic;
import inf112.RoboRally.app.Utility.PlayerControls;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Cards.ProgramCard;

public class PlayerDeckTests {
    PlayerDeck playerDeck;
    ProgramCard card, card2;
    
    @Before
    public void setUp() {
        playerDeck = new PlayerDeck();
        card = new ProgramCard(1, new String(), 650, "Move-1_490.jpg");
        card2 = new ProgramCard(2, new String(), 780, "Move-2_670.jpg");
    }
    
    @Test
    public void takeCardTest(){
        playerDeck.takeCard(card);
        assertEquals(1, playerDeck.cards.size());
    }

    @Test
    public void discardCardTest(){
        playerDeck.takeCard(card);
        playerDeck.discard();
        assertEquals(0, playerDeck.cards.size());
    }

    @Test
    public void discardAllCardsTest(){
        playerDeck.takeCard(card);
        playerDeck.takeCard(card2);
        playerDeck.discardAll();
        assertEquals(0, playerDeck.cards.size());
    }

}
