# Deloppgave 1:

## Does the roles in the team work?
* The roles work good, and all ambiguity that arised in the beginnning of the project is cleared up. Everyone is confident with their role in the project.
* Teamlead takes responsibility for the meetings and meeting minutes and for clearing up whatever is unclear at the time. Makes sure all the user stories applies and is put down on "paper"
* QA is taking resonsibility for everything needed ot be tested and makes sure tests that do are not optimal or not in use are removed before the final commit.
* Senior and Junior developers comes up with a lot of good code and solutions for the most optimal solutions. They cooperate a lot with rulekeeper, shich also contributes with a lot of good solutions to problems.
* Rulekeeper has everything under control regarding rules and makes sure the game is developed correctly according to the rules of the traditional board game, Roborally.

## Are there experiences worth mentioning reagarding the team or the teams method?
* The team works good and we collaborate very well. We meet and talk several times a week and you can see that we have progress in the project.
* Physical meetings work a lot better, faster is more effective. We still keep most meetings digital because the team has more time to meet then.
* It works good for the team to focus on one problem at a time considering that most of the meetings and lectures are digital, so we do not need to wonder what is going on since we do not yet trust the project board 100%.
* Playing multiplayer from several computers has taken a lot more time and is a lot more challenging than expected.
* We have now learned from about MVP and what it means and takes to satisfy and MVP. We have learned that time-demanding tasks should be started pretty early in the process. We chose to delay the most demanding task till the end, since we wanted 
  as most as possibly done early. For next time we know to start earlier on critical/demanding tasks. Despite pushing it, it has worked out fine.

## Does the team agree on the choices taken, and if not what could be improved?
* We have had a good dialog thoughout the project, and the choices have been discussed with everyone that wished to take part.
* We have met several times a week to discuss potential problems and progress.  
* Whenever there has been a big issue, it has been dicussed in the meetings with everyone to find a solution as quickly as possible.  
* We all agree on the choices we have done throughout.
* If there is something we would change it is starting earlier on the multiplayer part of the MVPs since it was a bigger task than first expected.  
* There has been a few cases where the tasks have been done in the last minute, which could have been avoided with a bit more planning.
* For the third sprint we should have everything ready at least a day before the deadline, so no one needs to work at night or right before the deadline to finish tasks.



 

## Retrospektiv
* Hva har vi klart til nå?
  * Vi har lært mer om arbeidsmåtene/rutinene til hverandre og det gjør det lettere å vite hva man kan forvente fra hverandre og hvor lang tid ting kan ta
  * Mvp-krav
    * Vi har gjennomført alle MvP-krav utenom multiplayer som igjen var mer arbeid enn forventet.
    * Vi jobber med å forbedre 
  * Vi har et fungerende spill som kan spilles single player atm
  * Vi har implementert en Main menu
* Hva kan forbedres?
  * Main menu
  * Vi ønsker å legge på lyd på spillet
  * Vi ønske å ha en innebygd chat i spillet som en enkel måte å kommunisere gjennom spillet på.
  * Disse tingene kommer til å bli jobbet med ila denne sprinten, og vi håper å ha mest mulig ferdig til oblig 3 innlevering
* Hvordan fungerer kommunikasjon og arbeidet
  * Arbeidet fungerer bra.
  * Kommunikasjonen fungerer bra. 
  * kan fortsatt bli bedre på Project Board, flytte issues osv, men det går veldig fint nå da oppgavene vi jobber med er såpass store at vi jobber sammen på de, og dermed vet nøyaktig hva som bedrives
  

## Maks tre forbedringspunkter fra retrospektiv
* Lage issues for alle små arbeidsoppgaver
* Lage en mer detaljert plan til oblig 4 slik at ingenting gjøres i siste liten.

## Hvordan har vi prioritert oppgavene fremover?
* Legg ved skjermdump av projectboard
* Prioritering er å bli ferdig med Multiplayer
* Dermed finne ut om det er flere ting vi mener bør være en del av MVP-kravene


## Hvordan fungerer gruppedynamikken og kommunikasjonen?

## Krav
* Oppdater krav, hvor langt vi har kommet, prioriterte krav og hva vi har gjort siden sist?
  * Krav
  1. Multiplayer
  2. Main menu
  3. 



## Mvp-krav:
* Om endringer i MVP krav er gjort, hvorfor?
* Vi har levert krav 5: Multiplayer, sist av de obligatoriske kravene
  * Grunnen til dette er at vi så på de andre oppgavene som lettere og fortere å få unna. Vi hadde ikke satt oss nok inn i prioritereing av MVP-krav
  før oblig 2 til å vite at man bør prioritere kritiske/tidskrevende og vanskelige oppgaver. 
    * Hadde vi visste dette burde vi startet med mvp-kravet ang multiplayer tidligere.
  * Vi syns dog det går fint nå, og er fornøyd med det vi har fått til, og at vi kan begynne å se på andre MVp krav enn de obligatoriske og håper på å bli ferdig med multiplayer innen oblig 3
  
* Hvilke Mvp-krav er viktigst og hvorfor
  * Det viktigste MVP-kravet er å vise et spillebrett og å flytte player-brikken slik at det er mulig å gjøre noe i spillet
  * Uten et brett eller en spille er det ikke mulig å foreta seg noe i et sånt spill og dette er dermed viktigst

## Hva vil vi ha med ekstra:
* Chat
* Lyd
* Main menu

## Bugs i kravene

## Klassediagram
* Kommer med siste commit før innlevering

## Testing: Manuelle og automatiske
* Anders lager

## Ulikhet i commits
* Da vi har ulike ansvarområder blir det mye ulikhet i commits der Alex og Tore vil ha en del fler commits enn resten av teamet
siden de har ansvar for at det er de beste løsningene som blir brukt og pushet til prosjektet sin main branch.

## Document how to run the game on all operative systems from git to playing for newbs
* Explain what buttons are used to play
* Linux, OS, Windows

## Update readmed in project to include intro on the team and the project
  * Short intro on the game

## User stories:

* Playing from several computers:
  * As a player I want to engage in a online game of RoboRally, so I can play with my friends.
  * Acceptance Criteria:
    * I see the board
    * I see the other robots on the board
    * I see the game cards
    * I am in the same game as the players I am playing online with
  * Tasks:
    * Set up a TCP connection
    * Implement P2P
  
* Checking if the robot is allowed to go a certain direction
  * As a player I want my robot not be able to go through walls, so I can play the game without cheating.
  * Acceptance Criteria:
    * I see a wall
    * I can not go through the wall
    * My robot stands still when hitting a wall
  * Tasks: 
    * Creating a grid
    * Deny the robot to walk on a object Wall
  
* Checking if a robot is moving outside the board
  * As a player I want my robot not to go outside the board, so I see my robot at all times
  * Acceptance Criteria: 
    * I see the board
    * I see my robot on the board constantly
    * If I stand on the edge of the board, my robot won't go further out
  * Tasks:
    * Using for-loops to check if the robot is trying to move outside the board
  
* Implementing chat:
  * As a player I want to be able to chat so I can talk to my friends while playing multiplayer with them
  * Acceptance criteria:
    * I see a chat
    * I can write in the chat
    * I can receive messages in the chat
  * Tasks:
    * Implement a chat
  
* Implementing a main menu
  * As a player I want to be able to choose whether I want to play multiplayer or single and other settings before playing, so I can play how I prefer
  * Acceptance criteria:
    * I see a main menu with different choices
    * I can choose the settings in the menu I prefer
  * Tasks: 
    * Implement a main menu
    * Include settings that a player would want to decide for themselves
  
* Implementing sound in the game
  * As a player I want to be able to hear sound in the game so I can have a better gaming experience
  * Acceptance criteria:
    * I can choose to turn on sound
    * I can regulate the volume
    * The sound fits the actions happening in the game
  * Tasks: 
    * Implement sound
    * Implement a volume button to change the volume and to turn it on/off.
  
  
