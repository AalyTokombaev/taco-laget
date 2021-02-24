package inf112.RoboRally.app.Objects;

import com.badlogic.gdx.math.Vector2;

public class gameMech {

    int x,y;

    public gameMech() {
    }

    public Player Action(Board board, Player player){

        Vector2 vec = player.getPosition();
        x = (int) vec.x;
        y = (int) vec.y;
            board.playerLayer.setCell(x, y, player.getState());
            if (board.holeLayer.getCell(x, y) != null) {
                player.setDamage(1);
            }
            if (board.flagLayer.getCell(x, y) != null) {
                player.setScore(1);
            }
            if (player.getScore() >= 5) {
                player.states.win();
            }
            return player;

        }
    }

