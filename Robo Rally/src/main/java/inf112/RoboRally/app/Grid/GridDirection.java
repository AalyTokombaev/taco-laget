package inf112.RoboRally.app.Grid;

public enum GridDirection {
    NORTH, SOUTH, EAST, WEST;

    public static GridDirection getDir(int i) {
        switch (i) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
        }
        return NORTH;
    }

    public static int getValue(GridDirection dir) {
        switch (dir) {
            case NORTH:
                return 0;
            case EAST:
                return 1;
            case SOUTH:
                return 2;
            case WEST:
                return 3;
        }
        return 0;
    }
}