package inf112.RoboRally.app.Cards;

import java.util.ArrayList;

/**
 * This class represents a programmable deck of ProgramCards to be used as a program by a Player in a round of Robo Rally
 * ProgramCards can be added to PlayerDecks by clicking on the ProgramCards
 * PlayerDecks are unique to Players, and should be different for every round of Robo Rally
 */
public class PlayerDeck {

    /**
     * @param cards is a list of ProgramCards which should not hold more than 5 ProgramCards at the same time
     */
    private ArrayList<ProgramCard> cards;

    public PlayerDeck() {
        cards = new ArrayList<>();
    }

    /**
     * Method for adding a card to the PlayerDeck
     *
     * @param card is the card to be added to the list
     */
    public void takeCard(ProgramCard card) {
        if (cards.contains(card)) {
            cards.remove(card);
            String string = card.getFilename();
            string = string.substring(0, string.length() - 4);
            System.out.println("You have removed " + string + " from the card deck");
        } else {
            cards.add(card);
            String string = card.getFilename();
            string = string.substring(0, string.length() - 4);
            System.out.println("You have added " + string + " to the card deck");
        }
    }

    public void discard(){
        cards.remove(0);
    }

    public ArrayList<ProgramCard> getCards() {
        return cards;
    }
}