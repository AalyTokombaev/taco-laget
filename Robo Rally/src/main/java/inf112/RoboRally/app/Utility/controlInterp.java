package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Player.Player;


import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class controlInterp {

    private Player player;
    private GameLogic logic;
    private PlayerDeck deck;

    public controlInterp(Player player, GameLogic logic) {
        this.player = player;
        this.logic = logic;
        this.deck = player.getDeck();
    }

    public void translateMovement(Boolean go){
        List<ProgramCard> cards = player.getDeck().getCards();
        Stack cardz = new Stack();
        try {
            for (ProgramCard card : cards) {
                cardz.add(card);
                System.out.println(card);
            }

            if (go || (!cardz.empty())) {
                ProgramCard card = (ProgramCard) cardz.pop();
                if (!card.getTurn().equals("")) {
                    player.setDir(card.getTurn());
                    System.out.println(player.getDir());

                }
                virtMover();

            }
        }catch (EmptyStackException e){
            e.printStackTrace();
        }

    }


    public void virtMover() {

        Vector2 nextPos = player.getPosition().cpy();

        try {

            if(player.getDir().equals("LEFT")){
                if (!logic.dirChecker(nextPos.add(-1, 0)).contains("EAST")
                        && !logic.dirChecker(player.getPosition()).contains("WEST")) {
                    player.setPosition(-1, 0);
                }
            }
            if(player.getDir().equals("RIGHT")){
                if (!logic.dirChecker(nextPos.add(1, 0)).contains("WEST")
                        && !logic.dirChecker(player.getPosition()).contains("EAST")) {
                    player.setPosition(1, 0);
                }
            }
            if(player.getDir().equals("UP")){
                if (!logic.dirChecker(nextPos.add(0, 1)).contains("SOUTH")
                        && !logic.dirChecker(player.getPosition()).contains("NORTH")) {
                    player.setPosition(0, 1);
                }
            }
            if(player.getDir().equals("DOWN")){
                if (!logic.dirChecker(nextPos.add(0, -1)).contains("NORTH")
                        && !logic.dirChecker(player.getPosition()).contains("SOUTH")) {
                    player.setPosition(0, -1);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
