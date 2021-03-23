package inf112.RoboRally.app.Cards;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is a tool for initializing ProgramCard objects by parsing information contained in CardInfo.txt
 * This class practically creates a full deck of Program Cards, with the same contents as a full deck from the physical board game,
 * represented by a sorted list of ProgramCards
 */
public class CardInitializer {
    ArrayList<String> cardsStrings;
    ArrayList<ProgramCard> cards;
    BufferedReader reader;
    ;

    /**
     * Creates a FileReader
     * Creates an empty list of Strings to be filled with each line from the read file
     * Creates an empty list of ProgramCards
     * Initializes cards by calling the initialize() method
     *
     * @throws IOException if the file can not be read by the FileReader
     */
    public CardInitializer() throws IOException {
        reader = new BufferedReader(new FileReader("Robo Rally/src/assets/CardInfo.txt"));
        cardsStrings = new ArrayList<>();
        cards = new ArrayList<>();
        initialize();
    }

    /**
     * Initializes all the ProgramCards in the game and adds them to a list by parsing the contents of CardInfo.txt
     *
     * @throws IOException if the file can not be read by the FileReader
     */
    private void initialize() throws IOException {
        System.out.println("Initializing cards");
        String line = reader.readLine();
        while (line != null) {
            cardsStrings.add(line);
            line = reader.readLine();
        }

        for (String s : cardsStrings) {
            String[] split = s.split(" ");
            int priority = Integer.parseInt(split[0]);
            String name = split[1];
            int moves = Integer.parseInt(split[2]);
            String turn = new String();

            // non move cards
            if (name.contains("Rotate")) {
                // if card name contains "Rotate" then the rotation part
                // should be in the slice [6:]
                turn = name.substring(6);
            }
            if (name.equals("U-Turn")) {
                turn = "U-Turn";
            }
            String filename = name + "-" + priority + ".jpg";
            cards.add(new ProgramCard(moves, turn, priority, filename));

        }

    }

    /**
     * Shuffles the list of cards
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Removes the card at the first index position in the cards list
     *
     * @return a ProgramCard
     */
    public ProgramCard deal() {
        return cards.remove(0);
    }
}
