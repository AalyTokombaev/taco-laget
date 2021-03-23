package inf112.skeleton.app.GridTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import inf112.RoboRally.app.Grid.GridDirection;


public class DirectionTests {
    int north;
    int east;
    int south;
    int west;
    GridDirection dirNorth;
    GridDirection dirEast;
    GridDirection dirSouth;
    GridDirection dirWest;

    @Before
    public void setUp() throws Exception {
        north = 0;
        east = 1;
        south = 2;
        west = 3;
        dirNorth = GridDirection.NORTH;
        dirEast = GridDirection.EAST;
        dirSouth = GridDirection.SOUTH;
        dirWest = GridDirection.WEST;
    }

    @Test
    public void getDir(){
        assertEquals(GridDirection.getDir(north), dirNorth);
        assertEquals(GridDirection.getDir(east), dirEast);
        assertEquals(GridDirection.getDir(south), dirSouth);
        assertEquals(GridDirection.getDir(west), dirWest);
    }
    
    @Test
    public void getValue(){
        assertEquals(GridDirection.getValue(dirNorth), north);
        assertEquals(GridDirection.getValue(dirEast), east);
        assertEquals(GridDirection.getValue(dirSouth), south);
        assertEquals(GridDirection.getValue(dirWest), west);
    }
}
