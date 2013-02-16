package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import Battleships.EmptySea;
import Battleships.Ocean;
import Battleships.Ship;

public class OceanTest {
    private Ocean oc;

    @Before
    public void setUp() throws Exception {
        oc = new OceanImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstruction() {

    }

    @Test
    public void testPlaceAllShipsRandomly() throws Exception {
        fail("oops");
    }

    @Test
    public void testIsOccupied() throws Exception {

    }

    @Test
    public void testShootAt() throws Exception {
        int x = 3;
        int y = 4;
        Ship[][] board = oc.getShipArray();
        // setup ocean with Ship at x,y
        board[x][y] = new SubmarineImpl();
        // fire at x,y
        assertTrue(oc.shootAt(x,y));
    }

    @Test
    public void testMissAt(){
        assertFalse(oc.shootAt(0,0));
    }

    @Test
    public void testGetShotsFired() throws Exception {

    }

    @Test
    public void testInitialGetHitCount() throws Exception {
        assertEquals(0, oc.getHitCount());
    }

    @Test
    public void testLaterGetHitCount(){
        // setup scenario for four hits
        // test for correct number of hits
        assertEquals(4, oc.getHitCount());
    }

    @Test
    public void testGetShipsSunk() throws Exception {
        assertEquals(0,oc.getShipsSunk());
    }

    @Test
    public void testIsGameOver() throws Exception {
        // setup end of game
        assertTrue(oc.isGameOver());
    }

    @Test
    public void testGameIsNotOver() {
        // setup nothing
        assertFalse(oc.isGameOver());
    }

    @Test
    public void testGetShipArray() throws Exception {
        Ship[][] ship = oc.getShipArray();
        for(Ship[] sarr: ship)
            for(Ship s : sarr)
                assertTrue(s instanceof Ship);
    }

    @Test
    public void testPrint() throws Exception {

    }
}
