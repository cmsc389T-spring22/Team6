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
		int current_x = myLoc.x;
		int current_y = myLoc.y;
		Location currentLoc;
		
		// looking in top and bottom directions
		for (int i = current_x-1; i <= current_x+1; i++) {
			currentLoc = new Location(i, current_y-1);
			if (myMap.getLoc(currentLoc) == Map.Type.EMPTY || myMap.getLoc(currentLoc) == Map.Type.COOKIE) {
				valid_moves.add(currentLoc);
			}
			currentLoc = new Location(i, current_y+1);
			if (myMap.getLoc(currentLoc) == Map.Type.EMPTY || myMap.getLoc(currentLoc) == Map.Type.COOKIE) {
				valid_moves.add(currentLoc);
			}
		}
		
		// looking left
		currentLoc = new Location(current_x-1, current_y);
		if (myMap.getLoc(currentLoc) == Map.Type.EMPTY || myMap.getLoc(currentLoc) == Map.Type.COOKIE) {
			valid_moves.add(currentLoc);
		}
		
		// looking right
		currentLoc = new Location(current_x+1, current_y);
		if (myMap.getLoc(currentLoc) == Map.Type.EMPTY || myMap.getLoc(currentLoc) == Map.Type.COOKIE) {
			valid_moves.add(currentLoc);
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
