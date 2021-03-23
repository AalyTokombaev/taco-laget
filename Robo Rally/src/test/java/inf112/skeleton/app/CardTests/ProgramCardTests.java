package inf112.skeleton.app.CardTests;

import inf112.RoboRally.app.Cards.ProgramCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramCardTests {
    ProgramCard moveOneCard;
    ProgramCard moveTwoCard;
    ProgramCard moveThreeCard;
    ProgramCard uTurnCard;
    ProgramCard rotateRightCard;
    ProgramCard rotateLeftCard;
    ProgramCard backUpCard;

    @Before
    public void setUp(){
        moveOneCard = new ProgramCard(1, new String(), 650, "Move-1-490.jpg");
        moveTwoCard = new ProgramCard(2, new String(), 780, "Move-2-670.jpg");
        moveThreeCard = new ProgramCard(3, new String(), 840, "Move-3-790.jpg");
        uTurnCard = new ProgramCard(0, "U-Turn", 60, "U-Turn-10.jpg");
        rotateRightCard = new ProgramCard(0, "RotateRight", 420, "RotateRight-70.jpg");
        rotateLeftCard = new ProgramCard(0, "RotateLeft", 410, "RotateLeft-80.jpg");
        backUpCard = new ProgramCard(0, "Back-Up", 480, "Back-Up-430.jpg");
     }

     @Test
     public void getNumberOfMovesTest(){
         assertEquals(1, moveOneCard.getNumberOfMoves());
         assertEquals(2, moveTwoCard.getNumberOfMoves());
         assertEquals(3, moveThreeCard.getNumberOfMoves());
         assertEquals(0, uTurnCard.getNumberOfMoves());
         assertEquals(0, rotateRightCard.getNumberOfMoves());
         assertEquals(0, rotateLeftCard.getNumberOfMoves());
         assertEquals(0, backUpCard.getNumberOfMoves());
     }

     @Test
     public void getPriorityTest(){
         assertEquals(650, moveOneCard.getPriority());
     }

     @Test
     public void getTurnTest(){
         assertEquals("", moveOneCard.getTurn());
         assertEquals("U-Turn", uTurnCard.getTurn());
         assertEquals("RotateLeft", rotateLeftCard.getTurn());
         assertEquals("Back-Up", backUpCard.getTurn());
     }

     @Test
     public void getFilenameTest(){
         assertEquals("Move-1-490.jpg", moveOneCard.getFilename());
     }
}
