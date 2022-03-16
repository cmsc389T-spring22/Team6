import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
		int scale = 20;
		Map testMap = new Map(scale);
		Location loc = new Location(3, 2);
		Location ghostLoc = new Location(3, 1);
		Location ghostLoc2 = new Location(4, 5);

		PacMan pacman = new PacMan("pacman", loc, testMap);
		PacManComponent pc = new PacManComponent(loc.x, loc.y, scale);
		testMap.add("pacman", loc, pc, Map.Type.PACMAN);

		// create a ghost that are in range
		Ghost attackLeft = new Ghost("left", ghostLoc, testMap);
		GhostComponent gc = new GhostComponent(ghostLoc.x, ghostLoc.y, scale);
		testMap.add("left", ghostLoc, gc, Map.Type.GHOST);


		// should be in range
		assertTrue(pacman.is_ghost_in_range());
	}

	public void testGhostInRange2() throws FileNotFoundException {
		int scale = 20;
		Map testMap = new Map(scale);
		Location loc = new Location(3, 2);
		Location ghostLoc = new Location(3, 1);
		Location ghostLoc2 = new Location(4, 5);

		PacMan pacman = new PacMan("pacman", loc, testMap);
		PacManComponent pc = new PacManComponent(loc.x, loc.y, scale);
		testMap.add("pacman", loc, pc, Map.Type.PACMAN);


		// create a ghost that are out of range
		Ghost attackRight = new Ghost("right", ghostLoc2, testMap);
		GhostComponent gc2 = new GhostComponent(ghostLoc2.x, ghostLoc2.y, scale);
		testMap.add("right", ghostLoc2, gc2, Map.Type.GHOST);

		// should not attack
		assertFalse(pacman.is_ghost_in_range());
	}
}

