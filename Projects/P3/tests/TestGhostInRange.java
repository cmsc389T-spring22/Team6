import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	// should be in range
	public void testGhostInRange() throws FileNotFoundException{
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(3, 2));
		Ghost ghost= frame.addGhost(new Location(3, 1), "testLeft", Color.red);


		assertTrue(pacman.is_ghost_in_range());
	}

	// should not be in range
	public void testGhostInRange2() throws FileNotFoundException{
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(3, 2));
		Ghost ghost= frame.addGhost(new Location(4, 5), "testLeft", Color.red);


		assertEquals(pacman.is_ghost_in_range(), false);
	}
}

