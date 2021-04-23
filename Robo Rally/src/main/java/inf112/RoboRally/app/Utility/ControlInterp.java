package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Player.Player;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;


public class ControlInterp {

    private Player player;
    private GameLogic logic;
    private PlayerDeck deck;

    public ControlInterp(Player player, GameLogic logic) {
        this.player = player;
        this.logic = logic;
        this.deck = player.getDeck();
    }


    public void translateMovement(Boolean go){

        List<ProgramCard> cardz = player.getDeck().getCards();

        try {
            if (go && (!cardz.isEmpty())) {

                Iterator<ProgramCard> nextCard = cardz.iterator();

                ProgramCard card = nextCard.next();
                player.getDeck().discard();

                if (!card.getTurn().equals("")) {
                    rotator(player.state.getRotation(),card.getTurn());
                }
                else{
                    moveIt(card.getNumberOfMoves());
                }
            }
        }catch (EmptyStackException e){
            e.printStackTrace();
        }
    }

    public void rotator(int rot, String dir) {

        if(dir.equals("RIGHT")){
            if(rot - 1 < 0){
                rot = 4;
            }
            player.state.setRotation(rot - 1);
        }
        if(dir.equals("LEFT")){
            if(rot + 1 > 3){
                rot = -1;
            }
            player.state.setRotation(rot + 1);
        }
        if(dir.equals("U-TURN")){
            System.out.println("U-TURN");
        }

        if(dir.equals("BACK-UP")){
            System.out.println("BACK-UP");

        }
    }

    public void moveIt(int moves) {

        if(moves == 0){
            return;
        }else {
            virtMover(moves);
            moveIt(moves-1);
        }
    }

    public void virtMover(int x) {

        Vector2 nextPos = player.getPosition().cpy();
        System.out.println(x);
        try {
            if (player.state.getRotation()==1)
                if (!logic.dirChecker(nextPos.add(-1, 0)).contains("EAST")
                        && !logic.dirChecker(player.getPosition()).contains("WEST")) {
                    player.getPosition().add(-1, 0);
                }
            if (player.state.getRotation()==3)
                if (!logic.dirChecker(nextPos.add(1, 0)).contains("WEST")
                        && !logic.dirChecker(player.getPosition()).contains("EAST")) {
                    player.getPosition().add(1, 0);
                }
            if (player.state.getRotation()==0)
                if (!logic.dirChecker(nextPos.add(0, 1)).contains("SOUTH")
                        && !logic.dirChecker(player.getPosition()).contains("NORTH")) {
                    player.getPosition().add(0, 1);
                }
            if (player.state.getRotation()==2)
                if (!logic.dirChecker(nextPos.add(0, -1)).contains("NORTH")
                        && !logic.dirChecker(player.getPosition()).contains("SOUTH")) {
                    player.getPosition().add(0, -1);
                }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

