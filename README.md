# Team 6's CMSC389T Pacman Project

By Ava Zhang, Kian Afkhami, Mikias Atnafu, and Zach Teselko

(put image of Pacman code running here)

Run the following command(s) in your terminal to run the program:
```
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## Function Descriptions:

### Pacman Functions

#### get_valid_moves()
- This method uses the shift() method of the Location class to take the current location, look one location above, below, to the left and to the right, and check to see if this spot is free for PacMan to move into. If it is, the Location is added into the valid_moves() ArrayList. This ArrayList is returned at the end of the function.
- The spot is free if it is empty or if there is a cookie there. (These conditions are different for Ghost)

#### move()
- This method uses get_valid_moves() to find valid moves for PacMan and chooses one(whatever is at index 0 of what it gets from get_valid_moves()). It then moves PacMan to that new location using move() in the Map class. 
- It returns true if PacMan was successfully moved and false if it could not be moved.

#### is_ghost_in_range()
- A method that checks if the a ghost is within one radius range. if so, the method will return true or false otherwise
- **Examples**:
  ```java
  //ghost at location (7,8)
  //pacman at location (7,9)
  ghost.is_pacman_in_range() -> true 
  ```

#### consume()
- This method checks the pacman's map to see if there is a COOKIE type in its location.  If so, the method calls pacman's map's eatCookie() method and returns its results
- This method returns the CookieComponent as a JComponent if a cookie was successfully eaten, null otherwise
- Its JUnit test TestConsume creates a map with a Pacman and 2 cookies.  The pacman is spawned in the same location as one of the cookies.  consume() is called twice, it should first successfully return the cookie in pacman's location, the second time it should return null (since the cookie has been removed).

### Ghost Functions

#### get_valid_moves()
- - This method uses the shift() method of the Location class to take the current location, look one location above, below, to the left and to the right, and check to see if this spot is free for the Ghost to move into. If it is, the Location is added into the valid_moves() ArrayList. This ArrayList is returned at the end of the function.
- The spot is free as long as there is not a Wall there. Therefore, the Ghost can move through PacMan and other Ghosts (These conditions are different for PacMan)

#### move()
- This method uses get_valid_moves() to find valid moves for a Ghost and chooses one(whatever is at index 0 of what it gets from get_valid_moves()). It then moves the Ghost to that new location using move() in the Map class. 
- It returns true if the Ghost was successfully moved and false if it could not be moved.

#### is_pacman_in_range()
- A method that checks if the pacman is within one radius range. if so, the method will return true or false otherwise
- **Examples**:
  ```java
  //ghost at location (7,8)
  //pacman at location (7,9)
  ghost.is_pacman_in_range() -> true 
  ```

#### attack()
- This method checks to see if pacman is within attack range (using Ghost's is_pacman_in_range()).  If so, it executes the ghost's map's attack() method and returns the result.
- This method returns true if an attack was made and false if it wasn't.

### Map Functions

#### move(String name, Location loc, Type type)
- This method updates the fields and locations HashMaps accordingly to represent what has now moved to the Location loc.
- Then, accesses the specific JComponent given the name parameter and the components HashMap, and moves the component in the GUI using the component's setLocation() method.

#### getLoc(Location loc)
- This method's field is a location. It returns a HashSet of Map.Type that are at that location.

#### attack(String name)
- checks if the ghost was able to successfully attack a pacman. if attack is sucessful it returns true, otherwise returns false.


#### eatCookie(String name)
- This method takes in the pacman's name and looks for its location using the map's locations instance variable.  It then iterates through the set of Types at that location using map's field variable, and deletes the cookie type if it exists.  If the cookie exists it also deletes the cookie from locations and components.
- This method returns the deleted CookieComponent (as a Jcomponent) if the pacman ate a cookie, and returns null otherwise.
