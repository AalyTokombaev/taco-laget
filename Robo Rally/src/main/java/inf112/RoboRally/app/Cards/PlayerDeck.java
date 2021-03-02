package inf112.RoboRally.app.Cards;

import java.util.ArrayList;
import java.util.List;

public class PlayerDeck {

    private ArrayList<ProgramCard> cards;

    public PlayerDeck(){
        cards = new ArrayList();
    }

    public ArrayList<ProgramCard> add(ProgramCard ele){
        cards.add(ele);
        return cards;
    }

}
