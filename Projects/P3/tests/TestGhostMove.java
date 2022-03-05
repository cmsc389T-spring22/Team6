import junit.framework.*;
import java.awt.Color;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
	
		NoFrame frame = new NoFrame(); 
		Location loc1 = new Location(1,1);
		Ghost ghost = frame.addGhost(loc1,"Blinky",Color.red);

		assertTrue(frame.getMap().getLoc(loc1).contains(Map.Type.GHOST));
		assertTrue(pacman.move());
		assertTrue(!(frame.getMap().getLoc(loc1).contains(Map.Type.GHOST)));
	}
}
