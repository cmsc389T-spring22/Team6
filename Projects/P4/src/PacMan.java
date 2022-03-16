import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

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
		
		// checking top
		Location top = this.myLoc.shift(0, -1);
       		if (myMap.getLoc(top) != null) {
        		if (!(myMap.getLoc(top).contains(Map.Type.WALL)) && !(myMap.getLoc(top).contains(Map.Type.GHOST))) {
        			valid_moves.add(top);
        		}
		}
		
		// checking bottom
        	Location bottom = this.myLoc.shift(0, 1);
        	if (myMap.getLoc(bottom) != null) {
        		if (!(myMap.getLoc(bottom).contains(Map.Type.WALL)) && !(myMap.getLoc(bottom).contains(Map.Type.GHOST))) {
        			valid_moves.add(bottom);
        		}
		}
        
        	// checking left
        	Location left = this.myLoc.shift(-1, 0);
        	if (myMap.getLoc(left) != null) {
        		if (!(myMap.getLoc(left).contains(Map.Type.WALL)) && !(myMap.getLoc(left).contains(Map.Type.GHOST))) {
        			valid_moves.add(left);
        		}
		}
        
       		// checking right
        	Location right = this.myLoc.shift(1, 0);
        	if (myMap.getLoc(right) != null) {
        		if (myMap.getLoc(right).contains(Map.Type.WALL)) {
        			valid_moves.add(right);
        		}
		}
		
		return valid_moves;
	}

	public boolean move() {
		ArrayList<Location> locs = get_valid_moves();
		if (locs.size() == 0) {
			System.out.println("pacman move false");
			return false;
		} else {
			Random random_gen = new Random();
			myLoc = locs.get(random_gen.nextInt(locs.size()));
			return myMap.move(myName,myLoc,Map.Type.GHOST);
		}
	}

	public boolean is_ghost_in_range() {
		// check the left, right, up, and down location, which is 1 radius from the pacman loc
		Location left = new Location(this.myLoc.x, this.myLoc.y - 1);
		Location right = new Location(this.myLoc.x, this.myLoc.y - 1);
		Location up = new Location(this.myLoc.x-1, this.myLoc.y);
		Location down = new Location(this.myLoc.x+1, this.myLoc.y);

		// check the map to see if a ghost exists in any of the above locations
		boolean ghostIsLeft = (myMap.getLoc(left) != null && myMap.getLoc(left).contains(Map.Type.GHOST));
		boolean ghostIsRight = (myMap.getLoc(right) != null && myMap.getLoc(right).contains(Map.Type.GHOST)); 
		boolean ghostIsUp = (myMap.getLoc(up) != null && myMap.getLoc(up).contains(Map.Type.GHOST)); 
		boolean ghostIsDown = (myMap.getLoc(down) != null && myMap.getLoc(down).contains(Map.Type.GHOST)); 
		
		if (ghostIsLeft || ghostIsRight || ghostIsUp || ghostIsDown) {
			return true;
		} else {
			return false;
		}
	}

	public JComponent consume() { 
		
		if (myMap.getLoc(myLoc).contains(Map.Type.GHOST)) {
			return myMap.eatCookie(myName);
		}

		return null;
	}
}
