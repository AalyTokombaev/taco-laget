#Project RoboRally - __Taco-laget__

##Part-task 1:

### Maria Lidsheim - Team leader
* __Skills/experience:__ Have worked in teams before, and have a good
overview of what needs to be done and when it should be done. Structured and experienced
student.
  
* __Experience from classes:__ inf100, inf101, inf102, inf226, inf214

* __Main task:__ Have control over the team, and make sure the deadlines are met, 
and keep track of meetings, meeting-minutes and summary of meetings.
  
### Alexander Iversen - Senior Developer
* __Skills/experience:__ Knows how the API work and is a very good
programmer, and easy-to-learn Java. Experienced and hard-working student.
  
* __Experience from classes:__ Inf100, inf101, inf102

* __Main task:__ Responsible for reviewing and refactoring the code.

### Arild Grimstveit - Rulekeeper
* __Skills/experience:__ Has played the game before a lot, and knows the rules
and the way to play the game very good.
  
* __Experience from classes:__ Inf100, inf101, inf102

* __Main task:__ Make sure the rules are implemented correctly and that the way
it is supposed to be played is correct.
  
### Tore Gjeset Schjølberg - Junior Developer
* __Skills/experience:__ Very good programmer and especially in Java. Learns things
easily. Very experienced student and from working in real life. 
  
* __Experience from classes:__ Inf100, inf101, inf102, inf214, inf226

* __Main task:__ Writing code and making sure Alexander gets it to review and refactor.

### Anders Mikkelsen - QA, Testing
* __Skills/experience:__ Has an eye for details and is very good at testing.
Structured and experienced person.
  
* __Experience from classes:__ Basic machinelearning and Python

* __Main task:__ Make tests and make sure they 
test the correct methods and expects the correct outputs. 
  

##Part-task 2:
### Project-methods:
We have chosen to follow Kanban as our main project-method. We have set up a 
project-board using git-issues, where we have created tasks which will be placed
under either "To do", "In progress" or "Done", depending on if we have started the
task or not. In addition to this we will use pair-programming, and more specific the
"Code-with-me" plugin for IntelliJ in the beginning. This is because it can be
difficult in the beginning to delegate the tasks to everyone as we are not to sure
the difficulty level of the different tasks. We also want to use tests to make the
methods as good as possible. 

###Meetings, communication and workload:
* We will have at least on weekly meeting in addition to the group session, and 
probably a few more in the beginning until we have a good strategy and everyone
is given enough to do and everyone understands all. The meetings will be on Discord
  until things open physical. If things open, we will try to meet in person mostly.
  
* In between meetings we have a discord and facebook-chat where we will communicate
about meetings, or other questions raised in between meetings.
  
* Our work/code/md-files should be done in branches in git, so the other team-members can approve
and agree before it is pushed to the main-branch and actually used. 

* Work that needs to be done will be put on cards under "To do" on the project board
in Git issues, and moved from there when being worked on. Meeting-minutes and summaries
will be shared on Google Disk. 
  

##Part-task 3:
###Superior goal for the application:
* The application in this project RoboRally is based on the boardgame RoboRally,
which is supposed to become a functional game, coded in Java. In addition, 
we use LibGDX to display the gameboard and Maven to set up the project. 
It should be working and understandable for users outside our project group 
for it to be successful. 
  
### User-stories:
* Showing a game-board:
    * As a player I wish to see the gameboard and place my game pieces.
    * Acceptance Criteria:
        * I see the board with tiles on.
        * There are no players on the board, if I haven’t placed any yet.
    * Tasks:
        * Create methods to retrieve the dimensions from the board.
        * Figure out how big the board should be
        * Place the right tiles and symbols on the right places.
    
* Showing a game-piece on the game-board:
    * As a player I want to see a  robot on the board if I have placed one.
    * Acceptance criteria:
        * I see the player where I placed it.
    * Tasks:
        * Create a player method that places the player-piece/robot on the board.
        * Figure out what symbol the player should be.
        * Create a method or class that stores the position of the robot
    
* Moving a game-piece:
    * As a player I want to be able to move the player where I want and for it to 
      stop if I try to move it through walls.
    * Acceptance Criterias:
        * The player moves accordingly to the arrow-button I press. 
        * The player stops if I try to move it through a wall.
        * The player stops if I try to move it out of the game board.
    * Tasks:
        * Create method that stops the robot or throws exception if it tries to go 
          out of the board.
        * Create method to move accordingly to the arrow-buttons.

* Robot visiting a flag:
    * As a player I want the robot to visit a flag if I move it there, and for 
      it to do something “special”, to understand it visits a flag.
    * Acceptance Criterias:
        * The robot changes an attribute when moved to a flag
        * A flag is visible and possible to move to
    * Tasks:
        * Place a flag on the board
        * Create a special attribute as a player moved to a flag
    
* The robot wins when visiting a flag:
    * As a robot I want to win when I visit all three flags, and get minor 
      reminders every time I visit one flag.
    * Acceptance Criteria:
        * When I visit a flag, something will tell me I have a win
        * When I visit several flags, something will tell me I have won
    * Tasks:
        * Create a method or class that lets the robot change an attribute or 
          something appearing on the screen that will tell me I won.



    




