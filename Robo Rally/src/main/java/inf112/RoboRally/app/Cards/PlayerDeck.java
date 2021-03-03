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
    }

    public List<ProgramCard> showCards() {
        return cards;
    }
}
