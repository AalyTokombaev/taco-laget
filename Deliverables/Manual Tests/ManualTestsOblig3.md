# Manual Player Movement Tests

__Purpose:__
Check that:
* The player can move freely around the map.
* The player cannot move outside edges of the map.
* The player piece turns red when moving over a hole.
* The player piece turns blue when moving over flags.

__Check that the player can move freely around the map__
1. Start the game by runnning "Main.java"
2. In the menu, click on "NEW GAME"
3. Use the keyboard keys to move around the board:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow left: to move left
    * Arrow right: to move right
4. Move over all the tiles of the map
    * If some squares are inaccessible, the test fails.
    
__Check that the player cannot move outside the edges of the map__
1. Start the game by running "Main.java"
2. In the menu, click on "NEW GAME"
3. Use the keyboard keys to move:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow left: to move left
    * Arrow right: to move right
4. Move to the leftmost side of the map by using the Arrow Left key. Once on the edge, move to the left.
    * If the player can move outside the edge of the game, the test fails.
5. Move to the rightmost side of the map by pressing right arrow key. Once on the edge, press right arrow key again.
    * If the player can move outside the edge of the game, the test fails.
6. Move to the top of the map by pressing arrow up. Once on the top edge, press arrow up.
    * If the player can move outside the edge, the test fails.
7. Move to the bottom of the map by pressing Arrow Down key on your keyboard. Once on the edge, press arrow down.
    * If the player can move outside the edge, the test fails.
    
__Check that the player piece turns red when moving over holes__
1. Start the game by running "Main.java"
2. In the meny, click on "NEW GAME"
3. Use the keyboard keys to move:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow left: to move left
    * Arrow right: to move right
4. Move over each of the holes on the map using the arrow keys above.
    * If the piece does NOT turn red when moving over a hole, the test fails.
    
__Check that the player turns blue when moving over the flags__
1. Start the game
2. In the meny, click on "NEW GAME"
3. Use the keyboard keys to move:
    * Arrow up: to move up
    * Arrow down: to move down
    * Arrow left: to move left
    * Arrow right: to move right
4. Move over each of the flags on the map using the arrow keys above.
    * If the piece does NOT turn blue when moving over a hole, the test fails.
    

# Manual User Interface Tests
__Purpose__
Check that: 
* The menu buttons work as intended
* Check that the cards on top of the board are clickable
* Check that the visual aspects of the game are working as intended

__Check that the "New Game" button work as intended__
1. Start the game by running "Main.java"
2. Click the "New Game" button
    * If a new game is not started, the test has failed
    
__Check that the "Preferences" button work as intended__
1. Start the game by running "Main.java"
2. Click the "Preferences" button
    * If a screen with preferences does not appear, the test has failed
    
3. Drag the music volume bar sideways
4. CLock on and off the music check mark
5. Drag the sound volume bar sideways
6. Click on and off the sound effect check mark.
    * If the volume bars are stuck, or if the check marks do not work, the test has failed.
    
7. Click on "Back"
    * If you are not returned to the main menu, the test has failed.
    
__Check that the "Exit" button works as intended
1. Start the game by running "Main.java"
2. Click the "Exit" button
    * If the game client does not close, the test has failed.
    
__Check that the player card on the top of the board is clickable__
1. Start the game by running "Main.java"
2. Click the "New Game" button in the main menu
3. Click on all the cards on top of the board and confirm in the terminal that the cards have been clicked.
    * You should see "You have added [Card] to the card deck", and "clicked [number]!"
    * If there is no output in the terminal, the test has failed.
    
__Check that the graphics of the map is working as intended__
1. Start the game by running "Main.java"
2. Click the "New Game" button in the main meny
3. Check that there is 20x20 squares on the map.
4. Check that there is at least one tile in each of the squares
    * If there is a square without tile(s), the test has failed.
