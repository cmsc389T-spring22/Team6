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
		return null;
	}

	public boolean move() {
		return false;
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
		return false;
	}
}
