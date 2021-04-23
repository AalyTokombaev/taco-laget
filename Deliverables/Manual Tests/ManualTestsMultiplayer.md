# Manual Multiplayer Test
## Purpose:
* Check that:
    * The client can connect to the host
    * The player board pieces move on both the client side and host side
    
* Check that the client can connect to the host:
1. Start the game by running "Main.java"
2. Click the "Multiplayer"-button
3. Click the "Host"-button
4. Start a new game by running "Main.java" again
5. Click the "Client"-button
    * The test fails if there is any connection errors in the terminal
    
* Check that the player board pieces move on both the client side and host side
    * Continue from the steps in "Check that that the clients can connect to the host"
    6. Move around, using the arrow keys, on the Client board
    7. Move around, using the arrow keys , on the Host board
        * If the piece from the Client side is not in the same position on both of the boards, 
    the test has failed