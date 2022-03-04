# Team 6's CMSC389T Pacman Project

By Ava Zhang, ...

(put image of Pacman code running here)

Run the following command(s) in your terminal to run the program:
```
java -cp "src/" StartMenu
```

## Function Descriptions:

### Pacman Functions

#### consume()
- This method checks the pacman's map to see if there is a COOKIE type in its location.  If so, the method calls pacman's map's eatCookie() method and returns its results
- This method returns the CookieComponent as a JComponent if a cookie was successfully eaten, null otherwise
- Its JUnit test TestConsume creates a map with a Pacman and 2 cookies.  The pacman is spawned in the same location as one of the cookies.  consume() is called twice, it should first successfully return the cookie in pacman's location, the second time it should return null (since the cookie has been removed).

### Ghost Functions

#### attack()
- This method checks to see if pacman is within attack range (using Ghost's is_pacman_in_range()).  If so, it executes the ghost's map's attack() method and returns the result.
- This method returns true if an attack was made and false if it wasn't.

### Map Functions

#### eatCookie(String name)
- This method takes in the pacman's name and looks for its location using the map's locations instance variable.  It then iterates through the set of Types at that location using map's field variable, and deletes the cookie type if it exists.  If the cookie exists it also deletes the cookie from locations and components.
- This method returns the deleted CookieComponent (as a Jcomponent) if the pacman ate a cookie, and returns null otherwise.
