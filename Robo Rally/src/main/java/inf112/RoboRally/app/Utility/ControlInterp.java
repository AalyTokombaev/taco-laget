package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Cards.PlayerDeck;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Player.Player;
import java.util.EmptyStackException;
import java.util.Stack;


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

        Stack <ProgramCard> cardz = player.getDeck().getCards();


        try {
            if (go && (!cardz.empty())) {

                ProgramCard card = cardz.pop();

                if (!card.getTurn().equals("")) {
                    rotator(player.state.getRotation(),card.getTurn());
                }
                else{
                    virtMover(card.getNumberOfMoves());
                }
            }
        }catch (EmptyStackException e){
            e.printStackTrace();
        }
    }

    public void rotator(int rot, String dir) {

        if(dir.equals("LEFT")){
            if(rot - 1 < 0){
                rot = 4;
            }
            player.state.setRotation(rot - 1);
        }
        if(dir.equals("RIGHT")){
            if(rot + 1 > 3){
                rot = -1;
            }
            player.state.setRotation(rot + 1);
        }
        if(dir.equals("U-TURN")){
            System.out.println("U-TURN");
        }
        switch (player.state.getRotation()) {

            case 0: player.setDir("UP");
                    break;
            case 1: player.setDir("RIGHT");
                    break;
            case 2: player.setDir("DOWN");
                    break;
            case 3: player.setDir("LEFT");
                    break;
            default:
                    break;
        }
    }

    public void virtMover(int x) {

        Vector2 nextPos = player.getPosition().cpy();
        System.out.println(x);
        for (int y = 0; y < x; y++) {

            try {

                if (player.getDir().equals("LEFT"))
                    if (!logic.dirChecker(nextPos.add(-1, 0)).contains("EAST")
                            && !logic.dirChecker(player.getPosition()).contains("WEST")) {
                        player.getPosition().add(-1, 0);
                    }
                if (player.getDir().equals("RIGHT"))
                    if (!logic.dirChecker(nextPos.add(1, 0)).contains("WEST")
                            && !logic.dirChecker(player.getPosition()).contains("EAST")) {
                        player.getPosition().add(1, 0);
                    }
                if (player.getDir().equals("UP"))
                    if (!logic.dirChecker(nextPos.add(0, 1)).contains("SOUTH")
                            && !logic.dirChecker(player.getPosition()).contains("NORTH")) {
                        player.getPosition().add(0, 1);
                    }
                if (player.getDir().equals("DOWN"))
                    if (!logic.dirChecker(nextPos.add(0, -1)).contains("NORTH")
                            && !logic.dirChecker(player.getPosition()).contains("SOUTH")) {
                        player.getPosition().add(0, -1);
                    }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
