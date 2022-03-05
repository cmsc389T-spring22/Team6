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
        	wall.add(Map.Type.WALL);
		
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
		ArrayList<Location> locs = new ArrayList<>();
		if (locs.size() == 0)
			return false;
		else {
			myLoc = locs.get(0);
			return myMap.move("pacman",myLoc,Map.Type.GHOST);
		}
	}

	public boolean is_pacman_in_range() {
		// check the left, right, up, and down location, which is 1 radius from the ghost loc
		Location left = new Location(this.myLoc.x, this.myLoc.y - 1);
		Location right = new Location(this.myLoc.x, this.myLoc.y - 1);
		Location up = new Location(this.myLoc.x-1, this.myLoc.y);
		Location down = new Location(this.myLoc.x+1, this.myLoc.y);

		// check the map to see if pacman exists in any of the above locations
		if (myMap.getLoc(left).contains(Map.Type.PACMAN) || myMap.getLoc(right).contains(Map.Type.PACMAN) ||
				myMap.getLoc(up).contains(Map.Type.PACMAN) || myMap.getLoc(down).contains(Map.Type.PACMAN)) {
			return true;
		}
		return false;
	}

	public boolean attack() {
		if(is_pacman_in_range()) {
			return myMap.attack(myName);
		}

		return false;
	}
}
