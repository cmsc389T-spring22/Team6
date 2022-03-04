import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume()  {
		Mainframe frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(3, 4));
		assertTrue(true);
	}
}
