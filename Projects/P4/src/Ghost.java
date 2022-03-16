import java.util.Random;
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

		// checking top
		Location top = this.myLoc.shift(0, -1);
        	if (myMap.getLoc(top) != null) {
        		if (!(myMap.getLoc(top).contains(Map.Type.WALL))) {
        			valid_moves.add(top);
        		}
		}

        	// checking bottom
        	Location bottom = this.myLoc.shift(0, 1);
        	if (myMap.getLoc(bottom) != null) {
        		if (!(myMap.getLoc(bottom).contains(Map.Type.WALL))) {
        			valid_moves.add(bottom);
        		}
		}

		// checking left
        	Location left = this.myLoc.shift(-1, 0);
        	if (myMap.getLoc(left) != null) {
        		if (myMap.getLoc(left).contains(Map.Type.WALL)) {
        			valid_moves.add(left);
        		}
		}

		// checking right
        	Location right = this.myLoc.shift(1, 0);
        	if (myMap.getLoc(right) != null) {
        		if (!(myMap.getLoc(right).contains(Map.Type.WALL))) {
        			valid_moves.add(right);
        		}
		}

		return valid_moves;
	}

	public boolean move() {
		//System.out.println("GETS TO GHOST MOVE");
		ArrayList<Location> locs = get_valid_moves();
		if (locs.size() == 0)
			return false;
		else {
			Random random_gen = new Random();
			myLoc = locs.get(random_gen.nextInt(locs.size()));
			return myMap.move(myName,myLoc,Map.Type.GHOST);
		}
	}

	public boolean is_pacman_in_range() {
		// check the left, right, up, and down location, which is 1 radius from the ghost loc
		Location left = new Location(this.myLoc.x, this.myLoc.y-1);
		Location right = new Location(this.myLoc.x, this.myLoc.y+1);
		Location up = new Location(this.myLoc.x-1, this.myLoc.y);
		Location down = new Location(this.myLoc.x+1, this.myLoc.y);
		
		// check the map to see if pacman exists in any of the above locations]
		boolean pacManIsLeft = (myMap.getLoc(left) != null && myMap.getLoc(left).contains(Map.Type.PACMAN));
		boolean pacManIsRight = (myMap.getLoc(right) != null && myMap.getLoc(right).contains(Map.Type.PACMAN)); 
		boolean pacManIsUp = (myMap.getLoc(up) != null && myMap.getLoc(up).contains(Map.Type.PACMAN)); 
		boolean pacManIsDown = (myMap.getLoc(down) != null && myMap.getLoc(down).contains(Map.Type.PACMAN)); 
		
		if (pacManIsLeft || pacManIsRight || pacManIsUp || pacManIsDown) {
			return true;
		} else {
			return false;
		}
	}

	public boolean attack() {
		if(is_pacman_in_range()) {
			return myMap.attack(myName);
		}

		return false;
	}
}
