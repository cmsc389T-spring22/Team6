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
		ArrayList<Location> valid_moves = new ArrayList<Location>;
		int current_x = myLoc.x;
		int current_y = myLoc.y;
		Location currentLoc;
		
		// looking in top and bottom directions
		for (int i = current_x-1; i <= current_x+1; i++) {
			currentLoc = new Location(i, current_y-1);
			if (myMap.getLoc(currentLoc) != Map.Type.WALL) {
				valid_moves.add(currentLoc);
			}
			currentLoc = new Location(i, current_y+1);
			if (myMap.getLoc(currentLoc) != Map.Type.WALL) {
				valid_moves.add(currentLoc);
			}
		}
		
		// looking left
		currentLoc = new Location(current_x-1, current_y);
		if (myMap.getLoc(currentLoc) != Map.Type.WALL) {
			valid_moves.add(currentLoc);
		}
		
		// looking right
		currentLoc = new Location(current_x+1, current_y);
		if (myMap.getLoc(currentLoc) != Map.Type.WALL) {
			valid_moves.add(currentLoc);
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
