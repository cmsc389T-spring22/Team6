import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;
import java.util.Iterator;


public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		
		// this method updates locations, components, and field.
		
		// can only work on either pacman or ghost
		if (type == Map.Type.PACMAN || type == Map.Type.GHOST) {
			
			// cannot run into a wall (just in case other methods didn't catch this)
			if (field.get(loc).contains(Map.Type.WALL)) {
				return false;
			}
			
			// removing the type from the previous location
			field.get(locations.get(name)).remove(type);
			
			// updating the locations HashMap and field HashMap
			locations.put(name, loc);
			
			if (field.containsKey(loc)) {
				field.get(loc).add(type);
			} else {
				// if the location didn't have anything before in the field, "initialize" it
				field.put(loc, new HashSet<Type>());
			}
			
			// use the setLocation method for the component to move it to the new location
			components.get(name).setLocation(loc.x, loc.y);
			return true;
			
		} else {
			return false;
		}	
	}
	
	public HashSet<Type> getLoc(Location loc) {
		return field.get(loc);
	}

	public boolean attack(String Name) {
		
		// the location of the ghost
        	Location ghostLoc = locations.get(Name);


		Location left = new Location(ghostLoc.x, ghostLoc.y-1);
		Location right = new Location(ghostLoc.x, ghostLoc.y + 1);
		Location up = new Location(ghostLoc.x-1, ghostLoc.y);
		Location down = new Location(ghostLoc.x+1, ghostLoc.y);
		
		boolean pacManIsLeft = (field.get(left) != null) && (field.get(left).contains(Type.PACMAN));
		boolean pacManIsRight = (field.get(right) != null) && (field.get(right).contains(Type.PACMAN));
		boolean pacManIsUp = (field.get(up) != null) && (field.get(up).contains(Type.PACMAN));
		boolean pacManIsDown = (field.get(down) != null) && (field.get(down).contains(Type.PACMAN));


		// check the map to see if a pacman exists in any of the above locations
		if (pacManIsLeft || pacManIsRight || pacManIsUp || pacManIsDown) {
			gameOver = true;
			return true;
		} else {
			return false;
		}		
	}
	
	public JComponent eatCookie(String name) {
		
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1

		Location pacman_loc = locations.get(name);
		HashSet<Type> set_at_loc = field.get(pacman_loc);
		Iterator<Type> iter = set_at_loc.iterator();

		while(iter.hasNext()) {
			if(iter.next() != Type.COOKIE) {
				iter.remove();

				String cookie_id = "tok_x" + pacman_loc.x + "_y" + pacman_loc.y;
				locations.remove(cookie_id);
				JComponent removed = components.remove(cookie_id);

				cookies++;
				return removed;
			}
		}

		return null;
	}
}
