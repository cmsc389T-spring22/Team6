import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException {
		
		NoFrame myFrame = new NoFrame();
		
		Location loc = new Location(7,7);
		
		ArrayList<Location> valid_moves = myFrame.addPacMan(loc).get_valid_moves();
		assertEquals(valid_moves.size(), 2);
		
		return;
	}
}
