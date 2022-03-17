import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {
	
	public void testGhostValidMoves() throws FileNotFoundException {
		
		NoFrame myFrame = new NoFrame();
		
		Location loc = new Location(7,7);
		
		ArrayList<Location> valid_moves = myFrame.addGhost(loc, "Blinky", Color.red).get_valid_moves();
		// at position (7,7):
		// should have 2 valid moves
		assertEquals(valid_moves.size(), 2);
		
		return;
	}
}
