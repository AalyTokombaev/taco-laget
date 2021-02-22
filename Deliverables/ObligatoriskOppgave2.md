# Deloppgave 1:
Hvordan fungerer rollene i teamet? 
* Ganske flytende
* Arild(regelholder) fungerer veldig bra, har alt vit renger av tekniske detaljer
* Både Tore og Alex progger en del på branchen, senior developer 
* Anders ikke fornøyd med rollen sin, har ikke helt skjønt hva QA/tester går ut på 
* Viktig at vi tester og at testene passerer før vi pusher til main
* Junior og senior dev diskuterer implementasjoenen mye og finner de beste løsningene
* Teamlead setter krav og kaller inn til møter, og passer på progresjon
* Teamlead bør gjøre seg mer kjent med prosjekt tavla
* QA skriver issues på manglende funksjonalitet

# Prosjektmetodikk, gode valg, hva kan gjøres bedre?
* Dynamikke fungerer bra, greier å snakke sammen og blir enige
* Har god kommunikasjon, møter til møtene, har møter utenfor obligatorisk undervisning
* Bruker Discord kanaler mye
* Det fungerer bra med to som har mest med koding å gjøre, men om noen ser en bedre løsning, sier de ifra
* Har klart å bruke Kanban, bruker projectboardet flittig. Bruken av boardet kan forbedres
* Rutine på å gå inn å se sjekke hva som blir gjort

# Commits av kode
* Vi har to stykker som hovedsaklig programmerer, og de streamer ofte mens 

# Maks tre forbedringspunkter:
* Sette tydeligere delmål
* Alle må bli flinkere på å bruke project board og sjekke hver gang vi starter på noe
* Bli flinkere på å skrive tester

Merge everything to dev, before merging to main so to see if anything went wrong. 





# User stories:

* Playing from several computers: 
    * As a player I want to engage in a online game of RoboRally.
    * Acceptance Criteria:
        * I see the board
        * I see the other robots on the board
        * I see the game cards
        * I am in the same game as the players I am playing online with
    * Tasks:
        * Set up a TCP connection
        * Implement P2P
    
* Handing out cards
    * I need the cards to be dealt, for me to know my moves and to play
    * Acceptance Criteria:
        * I receive cards
        * I can see what my next move is
    * Tasks: 
        * Create a card class which makes the card
        * Create a method which divides the cards between the players
        * Create a method which lets the player draw cards
    
* Pick five cards
    * I need to be able to pick five cards to play the game
    * Acceptance Criteria:
        * I can decide which five cards I want to use from the cards I am dealt
    * Tasks: 
        * Create a method that shows me the cards I can pick from
        * Create a method that lets me choose the cards I want, up to five
    
* Moving the robot in the direction the cards tells me to
    * When I have put the cards in the order I want, I want to be able to move the robot accordingly. 
    * Acceptance Criteria: 
        * My robot moves in the direction mye first card says
        * After my robot has moved once, the card is thrown
    * Tasks:
        * Let the player choose what order to put the cards in
        * Make the robot what the card shows
    

        