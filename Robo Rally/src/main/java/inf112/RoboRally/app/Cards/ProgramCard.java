package inf112.RoboRally.app.Cards;


import com.badlogic.gdx.graphics.Texture;

/**
 * This class represents a Program Card with the same information as the cards from the board game Robo Rally
 */
public class ProgramCard {
    private final int move; // 0 for rotational movement cards, 1-3 for directional movement cards
    private final String turn; // Right, Left, left empty for directional movement cards
    private final int priority; // Priority number on card
    private final String filename; // String with card name + .jpg suffix

    /**
     * Constructs a new ProgramCard
     *
     * @param numberOfMoves is the number of moves in a direction
     * @param turn          is the rotational value
     * @param priority      is the priority value
     * @param filename      is the file name
     */
    public ProgramCard(int numberOfMoves, String turn, int priority, String filename) {
        this.move = numberOfMoves;
        this.turn = turn;
        this.priority = priority;
        this.filename = filename;

    }

    // Getters for class field variables

    public int getNumberOfMoves() {
        return this.move;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTurn() {
        return this.turn;
    }

    public String getFilename() {
        return this.filename;
    }

    //TODO this is new
    public Texture getTex() {
        return new Texture(getFilename());
    }


}