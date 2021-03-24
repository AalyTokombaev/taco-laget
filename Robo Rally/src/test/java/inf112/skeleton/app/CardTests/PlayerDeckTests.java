package inf112.skeleton.app.CardTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Cards.PlayerDeck;

public class PlayerDeckTests {
    PlayerDeck deck;
    ProgramCard moveOneCard;
    ProgramCard moveTwoCard;
    ProgramCard moveThreeCard;

    @Before
    public void setUp(){
        deck = new PlayerDeck();
        moveOneCard = new ProgramCard(1, new String(), 650, "Move-1.jpg");
        moveTwoCard = new ProgramCard(2, new String(), 780, "Move-2.jpg");
        moveThreeCard = new ProgramCard(3, new String(), 840, "Move-3.jpg");
     }

     // Check that card is added to the deck
     public void takeCardTest(){
         deck.takeCard(moveOneCard);
         assertEquals(moveOneCard, deck.showCards().get(0));
     }
}
