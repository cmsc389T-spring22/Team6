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
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
