import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException {
		
		MainFrame myFrame = new MainFrame();
		
		Location loc = new Location(9,9);
		
		ArrayList<Location> valid_moves = myFrame.addGhost(loc, "Blinky", Color.red).get_valid_moves();
		assertEquals(valid_moves.size, 4);
		// since this method relies on map's getLoc() method, which the branch currently doesn't have,
		// this is all i can test for
		
		return;
	}
}
