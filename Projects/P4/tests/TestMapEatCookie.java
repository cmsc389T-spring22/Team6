import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() {

		int scale = 20;

		Map testMap = new Map(scale);
		Location loc = new Location(1,1);

		PacMan pacman = new PacMan("pacman", loc, testMap);
		PacManComponent pc = new PacManComponent(loc.x,loc.y,scale);
		testMap.add("pacman", loc, pc, Map.Type.PACMAN);

		
		CookieComponent tok = new CookieComponent(loc.x,loc.y,scale);
		testMap.add("tok_x1_y1", loc, tok, Map.Type.COOKIE);

		Location newloc = new Location(2,2);
		CookieComponent xtra_tok = new CookieComponent(loc.x,loc.y,scale);
		testMap.add("tok_x2_y2", newloc, xtra_tok, Map.Type.COOKIE);

		assertEquals(testMap.eatCookie("pacman"), tok);
		assertNull(testMap.eatCookie("pacman"));
	}
}
