import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(3, 2));

		// the below 4 ghost should attack the pacman because
		Ghost ghostLeft = frame.addGhost(new Location(3, 1), "testLeft", Color.red);
		Ghost ghostRight = frame.addGhost(new Location(3, 3), "testRight", Color.red);
		Ghost ghostUp = frame.addGhost(new Location(2, 2), "testUp", Color.red);
		Ghost ghostDown = frame.addGhost(new Location(4, 2), "testDown", Color.red);

		// should not attack because it is outside the attack range
		Ghost outOfRange  = frame.addGhost(new Location(3, 4), "outOfRange", Color.red);


		Map map = frame.getMap();

		assertTrue(ghostLeft.is_pacman_in_range());
		assertTrue(ghostRight.is_pacman_in_range());
		assertTrue(ghostUp.is_pacman_in_range());
		assertTrue(ghostDown.is_pacman_in_range());

		assertEquals(outOfRange.is_pacman_in_range(), false);

	}
}
