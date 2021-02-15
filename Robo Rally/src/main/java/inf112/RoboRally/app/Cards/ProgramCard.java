package inf112.RoboRally.app.Cards;

public class ProgramCard {
    private int move;
    private String turn;
    private int priority;
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