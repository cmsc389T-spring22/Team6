import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException {

		int scale = 20;
		Map testMap = new Map(scale);
		Location loc = new Location(3, 2);


		Location ghostLeft = new Location(3, 1);
		Location ghostRight = new Location(3, 3);
		Location ghostUp = new Location(2, 2);
		Location ghostDown = new Location(4, 2);

		PacMan pacman = new PacMan("pacman", loc, testMap);
		PacManComponent pc = new PacManComponent(loc.x, loc.y, scale);
		testMap.add("pacman", loc, pc, Map.Type.PACMAN);

		// create a ghost that are in range
		Ghost attackLeft = new Ghost("left", ghostLeft, testMap);
		GhostComponent gc = new GhostComponent(ghostLeft.x, ghostLeft.y, scale);
		testMap.add("attack_left", ghostLeft, gc, Map.Type.GHOST);

		Ghost attackRight = new Ghost("right", ghostRight, testMap);
		GhostComponent gc2 = new GhostComponent(ghostRight.x, ghostRight.y, scale);
		testMap.add("attack_right", ghostRight, gc2, Map.Type.GHOST);

		Ghost attackUp = new Ghost("up", ghostUp, testMap);
		GhostComponent gc3 = new GhostComponent(ghostUp.x, ghostUp.y, scale);
		testMap.add("attack_up", ghostUp, gc3, Map.Type.GHOST);

		Ghost attackDown = new Ghost("down", ghostDown, testMap);
		GhostComponent gc4 = new GhostComponent(ghostDown.x, ghostDown.y, scale);
		testMap.add("attack_down", ghostDown, gc4, Map.Type.GHOST);


		// create a ghost that is out of range
		Ghost outOfRange  = new Ghost("range", new Location(3,4), testMap);
		GhostComponent gc5 = new GhostComponent(3, 4, scale);
		testMap.add("out_of_range", new Location(3,4), gc5, Map.Type.GHOST);


		// should be in range
		assertTrue(attackLeft.is_pacman_in_range());
		assertTrue(attackRight.is_pacman_in_range());
		assertTrue(attackUp.is_pacman_in_range());
		assertTrue(attackDown.is_pacman_in_range());
		
		// should not attack because it is outside the attack range
		assertFalse(outOfRange.is_pacman_in_range());
	}
}
