package inf112.RoboRally.app.Cards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDeck {

    private List<ProgramCard> Cards;
    CardInitializer cardInitializer;

    public PlayerDeck() {
        // This really shouldn't be here, I'm just testing the waters.
        Cards = new ArrayList<>();
    }

    public void takeCard(ProgramCard card) {
        Cards.add(card);
    }

    public List<ProgramCard> showCards(){
        return Cards;
    }



}
