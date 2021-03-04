package inf112.RoboRally.app.Cards;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class PlayerDeck {


    private ArrayList<ProgramCard> cards;
    CardInitializer cardInitializer;

    public PlayerDeck() {
        cards = new ArrayList<>();
    }

    public void takeCard(ProgramCard card) {
        cards.add(card);
        String string = card.getFilename();
        string = string.substring(0, string.length() - 4);
        System.out.println("You have added " + string + " to the card deck");
    }

    public List<ProgramCard> showCards() {
        return cards;
    }
}
