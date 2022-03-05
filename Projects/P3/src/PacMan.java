import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		
		HashSet<Map.Type> empty = new HashSet<>();
		empty.add(Map.Type.EMPTY);
		HashSet<Map.Type> cookie = new HashSet<>();
		empty.add(Map.Type.COOKIE);
		
		// checking top
		if (myMap.getLoc(this.myLoc.shift(0, -1)) == empty || myMap.getLoc(this.myLoc.shift(0, -1)) == cookie) {
			valid_moves.add(this.myLoc.shift(0, -1));
		}
		
		// checking bottom
		if (myMap.getLoc(this.myLoc.shift(0, 1)) == empty || myMap.getLoc(this.myLoc.shift(0, 1)) == cookie) {
			valid_moves.add(this.myLoc.shift(0, 1));
		}
		
		// checking left
		if (myMap.getLoc(this.myLoc.shift(-1, 0)) == empty || myMap.getLoc(this.myLoc.shift(-1, 0)) == cookie) {
			valid_moves.add(this.myLoc.shift(-1, 0));
		}
		
		// checking right
		if (myMap.getLoc(this.myLoc.shift(1, 0)) == empty || myMap.getLoc(this.myLoc.shift(1, 0)) == cookie) {
			valid_moves.add(this.myLoc.shift(1, 0));
		}
		
		return valid_moves;
	}

	public boolean move() {
		ArrayList<Location> locs = new ArrayList<>();
		if (locs.size() == 0)
			return false;
		else {
			myLoc = locs.get(0);
			return myMap.move("pacman",myLoc,Map.Type.PACMAN);
		}
	}

	public boolean is_ghost_in_range() {
		// check the left, right, up, and down location, which is 1 radius from the pacman loc
		Location left = new Location(this.myLoc.x, this.myLoc.y - 1);
		Location right = new Location(this.myLoc.x, this.myLoc.y - 1);
		Location up = new Location(this.myLoc.x-1, this.myLoc.y);
		Location down = new Location(this.myLoc.x+1, this.myLoc.y);

		// check the map to see if a ghost exists in any of the above locations
		if (myMap.getLoc(left).contains(Map.Type.GHOST) || myMap.getLoc(right).contains(Map.Type.GHOST) ||
				myMap.getLoc(up).contains(Map.Type.GHOST) || myMap.getLoc(down).contains(Map.Type.GHOST)) {
			return true;
		}
		return false;
	}

	public JComponent consume() { 
		if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
			return myMap.eatCookie(myName);
		}

		return null;
	}
}
