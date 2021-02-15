package inf112.RoboRally.app.Cards;

public class ProgramCard {
    private int move; // 0 hvis snukort, 1-3 ellers
    private String turn; // høyre, venstre, opp, ned, nei for move kort feks?
    private int priority; // prioriteten på hvilke kort som skal brukes først
    private String filename;

}

public ProgramCard(int numberOfMoves, String turn, int priority, String filename){
    this.move = numberOfMoves;
    this.turn = turn;
    this.priority = priority;
    this.filename = filename;
}


public int getNumberOfMoves() { return this.move;}

public int getPriority() { return this.priority;}

public String getTurn() { return this.turn; }

public String getFilename() {return this.filename; }