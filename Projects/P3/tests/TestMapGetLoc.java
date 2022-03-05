import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException{


		NoFrame frame = new NoFrame(); 
		Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); 
		PacMan pacman = frame.addPacMan(new Location(2, 1));
		Location one = new Location(1,1);
		Location two = new Location(2,1);

		HashSet<Map.Type> setOne = new HashSet<Map.Type>();
		setOne.add(Map.Type.GHOST);
		setOne.add(Map.Type.COOKIE);

		assertEquals(frame.getMap().getLoc(one), setOne);
		
		HashSet<Map.Type> setTwo = new HashSet<Map.Type>();
		setTwo.add(Map.Type.PACMAN);
		setTwo.add(Map.Type.COOKIE);

		assertEquals(frame.getMap().getLoc(two), setTwo);

		HashSet<Map.Type> setThree = new HashSet<Map.Type>();
		setThree.add(Map.Type.WALL);
		assertEquals(frame.getMap().getLoc(new Location(0,0)), setThree);
	}
}
