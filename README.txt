1.0.0.1 README
Created: April 3, 2020 by Jacob Kieszkowski
Updated: April 25, 2020 by Jacob Kieszkowski



Blackjack Program
==============================================================


Minimum Requirements:
Java JDK 14


[ Overview ]
This program was designed by Joseph Branham, Dustin Chase, and Jacob Kieszkowski for a final project for 
INFO-C211-33192 online class for IU South Bend. It was designed in the Apache NetBeans IDE program. The 
purpose of the project is to show skills with the Java programming language, JavaFX, GUI, and team 
collaboration. The project should simulate the game of Blackjack, of which the rules are explained below.


[ Rules ]
The basic rules of Blackjack are as follows:
The goal of Blackjack is to beat the Dealer but not go over the number 21.
User and Dealer are initially dealt two card. User only knows their hand and the top card of the Dealer.
Going over 21 is an automatic loss and can happen to both User and Dealer.
If the Dealer hits 21 with their first two cards they automatically win, unless the User also has 21.
If the User hits 21 with their first two cards they automatically win, unless the Dealer also has 21.
In this version, if the User and Dealer show the same number at the end, it is a draw (known as a Push).
The User can Hit to receive another card.
The User can choose to Hit until they go over 21 in which they automatically lose.
The User can Stand to play against the Dealer with their current hand.
Face cards are worth 10. Aces are worth either 1 or 11 and the value can be changed at any time.


[ BlackJackGame.java ]
Written by Joseph Branham


Main function for project, which calls all other classes. This class contains most of rules and logic for
the game itself. It also calls all of the Gui elements from BlackJackGUI.java. This controls what the buttons
Play, Hit, and Stand do. Logically, the User can Hit until they go over 21 in which the program checks if
the User busted and runs the function to finish the game. Stand also runs this function. The finishGame() function
is the meat and potatoes of the class, which is what contains the Win, Lose, and Push criteria which are explained
in the rules above.


[ MyHand.java ]
Written by Jacob Kieszkowski

MyHand checks the value of the cards in the User's hand. It contains logic for setting initial values for the
User's Hand (which are initialized at 0), checks for BlackJack criteria, checks for Bust criteria, 
as well as how aces should be counted when a player exceeds 21. 


[ MyDeck.java ]
Written by Dustin Chase

Initializes a deck of cards when the program is started. The values are randomly shuffled to simulate a real
deck shuffle. The values are re shuffled when the program is restarted or if the number of games played exceeds
1000. 


[ MyCard.java ]
Written by Joseph Branham

Code used for displaying the card value and suit. This is called in the main function and subsequently shown
in the GUI.


[ BlackJackGUI.java ]
Written by Dustin Chase

All the code used to determine the user interface for the Blackjack Game itself. Sets the game window size, 
determines the functionality of each button as well as setting attributes for each including size and display,
and calls functions to display the User's and Dealer's hands. 


[ Update 1.0.0.1 ]

-Cleaned up code
-Made formatting more consistent
-Shortened variable names for easier reading
