package inf112.RoboRally.app.Cards;

import java.util.Objects;

public class ProgramCard {
    private int move; // 0 hvis snukort, 1-3 ellers
    private String turn; // høyre, venstre, opp, ned, nei for move kort feks?
    private int priority; // prioriteten på hvilke kort som skal brukes først
    private String filename;


    public ProgramCard(int numberOfMoves, String turn, int priority, String filename) {
        this.move = numberOfMoves;
        this.turn = turn;
        this.priority = priority;
        this.filename = filename;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgramCard)) return false;
        ProgramCard that = (ProgramCard) o;
        return move == that.move && Objects.equals(getTurn(), that.getTurn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(move, getTurn());
    }
}