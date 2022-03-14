import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase {

	public void testMapMove() throws FileNotFoundException {
		
		NoFrame myFrame = new NoFrame();
		Location oldLoc = new Location(9,9);
		Location newLoc = new Location(8,9);
		
		myFrame.addPacMan(oldLoc);
		Map gameMap = myFrame.getMap();
		
		// test to see if move method returns true
		assertTrue(gameMap.move("pacman", newLoc, Map.Type.PACMAN));
		
		// see if field hashmap has been updated
		assertTrue(gameMap.getLoc(newLoc).contains(Map.Type.PACMAN));
	}
}
