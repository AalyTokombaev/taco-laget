package inf112.RoboRally.app.Cards;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CardInitializer {
    ArrayList<String> cardsStrings;
    ArrayList<ProgramCard> cards;
    BufferedReader reader;
;
    public CardInitializer() throws IOException {
        reader = new BufferedReader(new FileReader("/Users/alexanderiversen/git_projects/Prosjekt/Robo Rally/src/main/java/inf112/RoboRally/app/Cards/CardInfo.txt"));
        cardsStrings = new ArrayList<>();
        cards = new ArrayList<>();
        initialize();

    }

    public ArrayList<ProgramCard> getCards() {
        return cards;
    }


    private void initialize() throws IOException {
        System.out.println("Initializing card");
        String line = reader.readLine();
        while (line != null) {
            cardsStrings.add(line);
            line = reader.readLine();
        }

        for (String s: cardsStrings) {
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

            String filename = name + ".jpg";
            cards.add(new ProgramCard(moves, turn, priority, filename));

        }

    }

    public void shufle() {
        Collections.shuffle(cards);
    }

    public ProgramCard deal() {
        return cards.remove(0);
    }
}
