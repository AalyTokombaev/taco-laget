package inf112.RoboRally.app.Objects;

/**
 * This class encapsulates the game mechanics in regards to interactions between the Board and the Players
 */

public class GameMechanics {
    int x, y; // worldUnit x,y variables to define position

    public GameMechanics() {
    }

    /**
     * Method to handle the current possible actions to be triggered on the Player by the Board
     *
     * @param board  is the board in question
     * @param player is the player in question
     * @return the Player after being affected by the action
     */

    /*
    public Player Action(Board board, Player player) {
        Vector2 vec = player.getPosition();
        x = (int) vec.x;
        y = (int) vec.y;
        board.playerLayer.setCell(x, y, player.getState());
        if (board.holeLayer.getCell(x, y) != null) {
            player.setDamage(100);
        }
        if (board.flagLayer.getCell(x, y) != null) {
            player.setScore(1);
        }
        if (player.getScore() >= 5) {
            player.states.win();
        }
        return player;
    }
    */


}

