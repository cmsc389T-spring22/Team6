import java.awt.Color;
import junit.framework.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws Exception {
		// testing map attack
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(3, 2));

		// the below 4 ghost should attack the pacman because
		Ghost ghostLeft = frame.addGhost(new Location(3, 1), "testLeft", Color.red);
		Ghost ghostRight = frame.addGhost(new Location(3, 3), "testRight", Color.red);
		Ghost ghostUp = frame.addGhost(new Location(2, 2), "testUp", Color.red);
		Ghost ghostDown = frame.addGhost(new Location(4, 2), "testDown", Color.red);

		// should not attack because it is outside the attack range
		Ghost outOfRange  = frame.addGhost(new Location(3, 4), "outOfRange", Color.red);

		
		Map map = frame.getMap();

		assertTrue(map.attack("testLeft"));
		assertTrue(map.attack("testRight"));
		assertTrue(map.attack("testUp"));
		assertTrue(map.attack("testDown"));

		assertFalse(map.attack("outOfRange"));
	}
}
