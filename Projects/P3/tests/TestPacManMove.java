import junit.framework.*;
import java.awt.Color;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{

		NoFrame frame = new NoFrame(); 
		Location loc1 = new Location(1,1);
		PacMan pacman = frame.addPacMan(loc1);

		assertTrue(frame.getMap().getLoc(loc1).contains(Map.Type.PACMAN));
		assertTrue(pacman.move());
		assertTrue(!(frame.getMap().getLoc(loc1).contains(Map.Type.PACMAN)));
		
	}
}
