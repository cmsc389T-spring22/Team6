import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		int current_x = this.myLoc.x;
		int current_y = this.myLoc.y;
		
		HashSet<Map.Type> wall = new HashSet<>();
        empty.add(Map.Type.WALL);
		
		// checking top
        if (myMap.getLoc(this.myLoc.shift(0, -1)) != wall) {
			valid_moves.add(this.myLoc.shift(0, -1));
		}
        
        // checking bottom
        if (myMap.getLoc(this.myLoc.shift(0, 1)) != wall) {
			valid_moves.add(this.myLoc.shift(0, 1));
		}
		
		// checking left
		if (myMap.getLoc(this.myLoc.shift(-1, 0)) != wall) {
			valid_moves.add(this.myLoc.shift(-1, 0));
		}
		
		// checking right
		if (myMap.getLoc(this.myLoc.shift(1, 0)) != wall) {
			valid_moves.add(this.myLoc.shift(1, 0));
		}
		
		return valid_moves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
