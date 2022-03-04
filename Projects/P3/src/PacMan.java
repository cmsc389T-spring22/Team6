import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

import com.sun.jdi.Location;

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
		int current_x = this.myLoc.x;
		int current_y = this.myLoc.y;
		
		HashSet<Map.Type> empty = new HashSet<>();
        empty.add(Map.Type.EMPTY);
        HashSet<Map.Type> cookie = new HashSet<>();
        empty.add(Map.Type.COOKIE);
		
		// checking top and bottom
		for (int i = -1; i <= 1; i++) {
			if (myMap.getLoc(this.myLoc.shift(i, -1)) == empty || myMap.getLoc(this.myLoc.shift(i, -1)) == cookie) {
				valid_moves.add(this.myLoc.shift(i, -1));
			}
			if (myMap.getLoc(this.myLoc.shift(i, 1)) == empty || myMap.getLoc(this.myLoc.shift(i, 1)) == cookie) {
				valid_moves.add(this.myLoc.shift(i, 1));
			}
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
