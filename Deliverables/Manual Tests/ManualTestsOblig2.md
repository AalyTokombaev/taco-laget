# Manual Player Movement Tests

## Purpose:
* Check that:
    * The player can move freely around the map.
    * The player cannot move outside edges of the map.
    * The player piece turns red when moving over a hole.
    * The player piece turns blue when moving over the flag.
    
### Checks that the player can move freely around the map.
* Start the game 
* Use the keyboard keys to move around the board
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow left: to move left
    * Arrow right: to move right
* Move over all the tiles of the map:
    * If some of the squares are inaccessible, the test fails
    
### Checks that the player cannot move outside the edges of the map
* Start the game
* Use the keyboard keys to move:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow left: to move left
    * Arrow right: to move right
* Move to the leftmost side of the map by using the Arrow Left Key. Once on the edge, move to the left.
    * If the player can move outside the edge of the game, the test fails.
* Move to the rightmost side of the map by pressing the right arrow key. Once on the edge, press right arrow key again.
    * If the player can move outside the edge of the game, the test fails.
* Move to the top of the map by pressing arrow up. Once on the top edge, press arrow up.
    * If the player can move outside the edge, the test fails. 
* Move to the bottom of the map by pressing Arrow Down key on your keyboard. Once on the edge, press arrow down.
    * If the player can move outside the edge, the test fails.
    
### Check that the player piece turns red when moving over holes:
* Start the game
* Use the keyboard keys to move:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow right: to move right
    * Arrow left: to move left
* Move over each of the holes on the map using the arrow keys above.
    * If the piece does NOT turn red  when moving over a hole the test fails.
    
### Check that the player piece turns blue when moving over holes:
* Start the game
* Use the keyboard keys to move:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow right: to move right
    * Arrow left: to move left
* Move over each of the flags on the map using the arrow keys above
    * If the piece does NOT turn blue when moving over a hole, the test fails. 