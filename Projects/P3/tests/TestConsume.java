import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;

public class TestConsume extends TestCase {

	public void testConsume()  {
		int scale = 20;
 
        Map testMap = new Map(scale);
        Location loc = new Location(1,1);
 
        PacMan pacman = new PacMan("pacman", loc, testMap);
        PacManComponent pc = new PacManComponent(loc.x,loc.y,scale);
        testMap.add("pacman", loc, pc, Map.Type.PACMAN);
 
       
        CookieComponent tok = new CookieComponent(loc.x,loc.y,scale);
        testMap.add("tok_x1_y1", loc, tok, Map.Type.COOKIE);
 
        assertEquals(pacman.consume(), tok);
        assertNull(pacman.consume());
	}
}
