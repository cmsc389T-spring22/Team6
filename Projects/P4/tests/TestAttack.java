import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() {
		int scale = 20;
		Map testMap = new Map(scale);
		Location loc = new Location(1,1);

		PacMan pacman = new PacMan("pacman", loc, testMap);
		PacManComponent pc = new PacManComponent(loc.x,loc.y,scale);
        testMap.add("pacman", loc, pc, Map.Type.PACMAN);

		Ghost blinky = new Ghost("Blinky", loc, testMap);
		GhostComponent gh1 = new GhostComponent(loc.x, loc.y, scale);
		testMap.add("Blinky", loc, gh1, Map.Type.GHOST);

		Location otherLoc = new Location(2,2);
		Ghost inky = new Ghost("Inky", otherLoc, testMap);
		GhostComponent gh2 = new GhostComponent(otherLoc.x, otherLoc.y, scale);
		testMap.add("Inky", otherLoc, gh2, Map.Type.GHOST);

		assertTrue(blinky.attack());
		assertFalse(inky.attack());
	}
}
