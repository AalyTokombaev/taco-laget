# Mandatory Assignment 4:

## Roles and team-work
* The roles still work as planned, and they have stayed pretty much the same all through the project. 
* The team has been very good, and I think it exceeded all expectations from what we have heard about teams not working.
* We have all been active and interested in getting as much as possible done, and been available for eachother. 

## Experience within the team
* It has been easier for everyone to meet digital after the study hall got limited capacity, so people prefer to work from home.
* We took a break during easter on the project, and continued the work the week after. 
* It has been good to have a plan for the last weeks to be able to get everything we find important and that is in the "Retteskjema" in for the final project. 
* We have still struggled with the multiplayer part as we thought it worked, but then it didn't work from all computers.
* We have managed to get through all the mvp's by just working thorough and together, and we are comfortable questioning things that are being done, so we can get the best solution.

## The choices we have made
* We all have a common understanding of the choices that are made. 
* We ask questions, come up with solutions and work together as a group.
* Out weekly meeting have been a good way of discussing new things we could potentially use and create in the project. 

## Communication
* Communication is still good, and we talk almost daily to get everything to work either on discord or facebook.
* We both text and talk and have meeetings on discord in both the Inf112 channel, but mostly in our own Taco-laget discord channel
* On facebook we announce meetings and other things we might want people to see asap. 

## Retrospective
* Our project method is based on Kanban, and we use the project board to keep track of what is being done and not, so others know what to start on and not.
* We feel like we have been really lucky with this group as everyone does their part in getting things done and helps eachother. 
* We still use Kanban and the projectboard, as well as remote pair-programming over discord.   
* What have we managed to do?
  * Started on new tasks from the project board
  * Had meetings online and discussed the plan till the final deadline
* What can we get better at?
  * We can still get better at moving things around in Project board when it is done, so it is live updated. 
  * Writing more informative meeting minutes. 
  * Make everyone test everything in the project, so we know it works from most possible computers before turning the code in.
  
* If we were to start from the beginning, we would lay out a more detailed plan for the whole project with more deadlines for ourselfes.
* The communication is obviously a lot better now, as we know eachother a bit more, and it is therefore easier to tell eachother what me mean, and want out of the project.
  
## Points of improvement
1. Live update the project board
2. Let everyone test the project before final delivery

## Prioritizing of the tasks
1. Finish a phase in the game
2. Debug multiplayer and find out why it do not work as planned
3. Implement chat(If time)
4. Implement sound(if time)

## Demands
* Out of the MVP's it is only Multiplayer that do not work as expected.
* Our goal is to make it work fine.
* For the fourth sprint:
  * We have worked on finishing the multiplayer
  * We have worked on creating a phase in the game, so you can acutally play a whole round
  * If we have time when all this is done, we will try to implement sound and a chat but this is not important and neither a focus in the project. 
  
## MVP-demands
* As mentioned our main goal for this sprint is to fix the multiplayer to make it work as we want it to.
* The most important MVP demand for us now is to set up a game-phase so the game can be played. 

## Extra features
* It would be fun to implement a in-game chat, and some sound elements if we have time when everything else is done. 

## Testing
Huske å sjekke at testene ikke returnerer nullpointerexception

## Difference in commits
* There is a difference in commits as we do a lot of remote programming where everyone watches one screen and one code. 
* After a meeting we get responsibility for things we need to do until next time. Often this is that Arild, Tore and Alex should
find solutions to existing problems and find out what to implement, while Anders is responsible for testing what is already created and 
  Maria is responsible for updating the readme file with what we have agreed on and come up with. This does create a difference in commits.
  
## How to run the game on Windows, Mac and Linux
Running the game on
* Windows:
  1. Go to our project-page on git: https://github.com/OlderNed/taco-laget, and clone the project to your computer
  2. Go to taco-laget/Robo Rally/src/main/inf112.RoboRally.app/Main
  3. Right click on Main and press "Run Main.main()"
  4. You will now see a game-board for our game
  5. Navigate the game-piece(UiB-owl) with the arrows on your keyboard
  6. To choose cards and use them, you simply click them with the mouse

* Mac OS:
  1. Go to the projects Github page at https://github.com/OlderNed/taco-laget
  2. Click on 'Code' and navigate down to 'Download as ZIP'
  3. Open IntelliJIDEA and open the downloaded project
  4. Navigate to Robo Rally/src/main/java/inf112.RoboRally.app
  5. Right click on 'Main' and select 'Run Main.main()'
     5b. If you get an error, find the 'Main' configuration in the top right corner of intellij(by the run button), click on 'Main' and click 'Edit configuration'.
     This should open up a new window called 'Run/Debug Configurations'
     5c. In 'Run/Debug Configurations' you should see a dropdown menu called 'Modify Options', click on
     'Add VM options'. This adds another input field in 'Run/Debug Configurations'. Here you need
     to add '-XstartOnFirstThread'. Click 'Apply' and 'Ok' at the bottom right of the window.
  6. Find the run button on the top right of the intellij window and press it to run the project.
  7. You will now see a game-board for our game
  8. Navigate the game-piece(UiB-owl) with the arrows on your keyboard
  9. To choose cards and use them, you simply click them with the mouse

* Linux:
  1. Open Intellij
  2. go to 'file' and then 'new project from version control'
  3. Choose github, and then enter the URL, which is https://github.com/OlderNed/taco-laget
  4. Download the repo
  5. Navigate to Robo Rally/src/main/java/inf112.RoboRally.app
  6. Right click on the 'Main', and select 'Run Main.main()'
  7. You will now see a game-board for our game
  8. Navigate the game-piece(UiB-owl) with the arrows on your keyboard
  9. To choose cards and use them, you simply click them with the mouse

* Multiplayer:
  * To start multiplayer as a host press `t` on your keyboard. 
  * This will spawn a dummy player which is removed when player 2 connects. 
  * To join a started game, press `j` on your keyboard.

## Class diagram
Kommer siste dag

## Project board
Kommer siste dag

## User-stories:
* **Creating a map with a conveyorbelt**
  * As a player I want my robot to move accordingly to the conveyor belt so the game turn is done correctly.
  * Acceptance Criteria:
    * I see the board
    * I see the map 
    * I see the conveyorbelt on the map
    * When I move on the conveyorbelt, the robot moves accordingly
  *Tasks:
    * Implement methods that makes the robot go the way the arrow on the conveyorbelt shows
  
* **Adding player 3, 4, 5, and 6**
  * As a player I want there to be several players on the board, so I do not play alone
  * Acceptance Criteria:
    * I see the board
    * I see up to six players on the board
  * Tasks:
    * Create more player-objects
    * Put several players on the board
  
* **Playing a round in the game**
  * As a player I want to be able to play a round so I can see who wins and to know that the game works as it should.
  * Acceptance criteria:
    * I see a board
    * I see my robot on the board
    * I can choose the right amount cards from the deck  
    * I can move my robot accordingly to my first card
    * If I end up on a whole, I lose HP and life tokens
    * If I land on a flag, I can tell that I'm closer to a victory
    * If I have landed on all three flags, the game will tell me I have won.
  * Tasks:
    * Finish the conveyor belt
    * Make a method that will tell the player in what order the player have landed on flags
    * Make a method that tells the player it has been on holes too much and therefore lost.
    * Make a method that tells the player it has won if it has been on all flags in the correct order.
  
* **Implementing chat**
  * As a player I want to be able to chat so I can talk to my friends while playing multiplayer with them
  * Acceptance criteria:
    * I see a chat
    * I can write in the chat
    * I can receive messages in the chat
  * Tasks:
    * Implement a chat
  
* **Implementing sound in the game**
  * As a player I want to be able to hear sound in the game so I can have a better gaming experience
  * Acceptance criteria:
    * I can choose to turn on sound
    * I can regulate the volume
    * The sound fits the actions happening in the game
  * Tasks:
    * Implement sound
    * Implement a volume button to change the volume and to turn it on/off.

  
