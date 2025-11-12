## BlackJack Game Implementation Overview

### Class Diagram

The class diagram is comprehensive, showing all classes, their attributes, methods, and relationships (inheritance, association, aggregation, composition). It includes all relevant details and is easy to understand.

### Project Summary

The project summary is detailed and covers all aspects of the project, including the purpose, features, and usage. It provides a clear understanding of the project. in my `README.md` / `README.pdf` file and this file.

### Main Class

The main class output is as per the specification. It initializes the game correctly.

### Inheritance

1. **Player Class**
   - **Abstract Class**: The Player class is an abstract class that defines common attributes and methods for all players in the game.
   - **Subclasses**:
     - Dealer: Inherits from Player and implements dealer-specific actions.
     - UserPlayer: Inherits from Player and implements user-specific actions.

2. **Dealer Class**
   - **Inheritance**: The Dealer class extends the Player class.
   - **Implementation**: Implements the PlayerActions interface to define actions specific to the dealer.

3. **UserPlayer Class**
   - **Inheritance**: The UserPlayer class extends the Player class.
   - **Implementation**: Implements the PlayerActions interface to define actions specific to the user player.

4. **PlayerActions Interface**
   - **Interface**: The PlayerActions interface defines the actions that a player can perform, such as hit, stand, double down, and split.
   - **Implemented By**:
     - Dealer
     - UserPlayer

5. **GameDataHandler Class**
   - **Inheritance**: The GameDataHandler class extends the DataHandler abstract class.

6. **DeckDataHandler Class**
   - **Inheritance**: The DeckDataHandler class extends the DataHandler abstract class.

### Association

1. **GameEngine and Player**
   - **Association**: The GameEngine class interacts with the Player class to manage player actions and determine winners.

2. **GameEngine and Dealer**
   - **Association**: The GameEngine class interacts with the Dealer class to manage dealer actions.

3. **GameEngine and GameDataHandler**
   - **Association**: The GameEngine class uses the GameDataHandler class to update player data in the YAML file.

4. **UserPlayer and Deck**
   - **Association**: The UserPlayer class interacts with the Deck class to draw cards.

5. **Dealer and Deck**
   - **Association**: The Dealer class interacts with the Deck class to draw cards.

6. **Player and GameDataHandler**
   - **Association**: The Player class uses the GameDataHandler class to save and update player data in the YAML file.

7. **TableDrawer and GameDataHandler**
   - **Association**: The TableDrawer class uses the GameDataHandler class to read player data from the YAML file.

8. **BlackjackGame and GameEngine**
   - **Association**: The BlackjackGame class interacts with the GameEngine class to start the game and manage the game loop.

9. **BlackjackGame and Player**
   - **Association**: The BlackjackGame class interacts with the Player class to initialize players.

10. **BlackjackGame and Deck**
    - **Association**: The BlackjackGame class interacts with the Deck class to manage the deck of cards.

### Constructor/Chaining

1. **Deck Class**
   - **Constructor**: Initializes the deck and shuffles it.

2. **Player Class**
   - **Constructor**: Initializes common attributes for all players.

3. **Dealer Class**
   - **Constructor**: Initializes the dealer and sets up the initial hand.

4. **UserPlayer Class**
   - **Constructor**: Initializes the user player and sets up the initial hand.

5. **GameDataHandler Class**
   - **Constructor**: Initializes the YAML object for data handling.

6. **BlackjackGame Class**
   - **Constructor**: Initializes the game, sets up initial settings, and starts the game loop.

7. **Card Class**
   - **Constructor**: Initializes the card with a suit and rank.

### Visibility Modifiers

1. **Deck Class**
   - **Private Modifier**: The deck variable is private to restrict direct access.

2. **Player Class**
   - **Protected Modifier**: The countHandValue method is protected to allow access within the package and subclasses.

3. **Dealer Class**
   - **Public Modifier**: The dealerActions method is public to allow access from other classes.

4. **UserPlayer Class**
   - **Private Modifier**: The playerId variable is private to restrict direct access.

5. **GameDataHandler Class**
   - **Public Modifier**: The updatePlayerGameData method is public to allow access from other classes.

6. **DataHandler Class**
   - **Protected Modifier**: The readData method is protected to allow access within the package and subclasses.

7. **Card Class**
   - **Public Modifier**: The getRank method is public to allow access from other classes.

### Packages

1. **cards**
   - **Description**: Contains classes related to card management.
   - **Classes**:
     - Card: Represents a single card with a rank and suit.
     - CardRank: Enum for card ranks.
     - CardSuit: Enum for card suits.
     - Deck: Manages a deck of cards, including shuffling and drawing cards.

2. **data**
   - **Description**: Handles reading and writing game data.
   - **Classes**:
     - DataHandler: Abstract class for reading
     - DeckDataHandler: Handles deck-specific data operations.
     - GameDataHandler: Manages player game data.

3. **exceptions**
   - **Description**: Custom exceptions used in the game.
   - **Classes**:
     - InsufficientChipsException: Thrown when a player tries to bet more chips than they have.
     - InvalidPlayerDataException: Thrown when player data is invalid.

4. **game**
   - **Description**: Contains the main game logic and engine.
   - **Classes**:
     - BlackjackGame: Starts the game and initializes the game engine.
     - GameEngine: Contains the core game loop and logic for determining winners.
     - TableDrawer: Draws the game table in the console.

5. **players**
   - **Description**: Manages player actions and data.
   - **Classes**:
     - Player: Abstract class representing a player.
     - Dealer: Extends Player and implements dealer-specific actions.
     - UserPlayer: Extends Player and implements user-specific actions.
     - PlayerActions: Interface for player actions like hit, stand, double down, and split.

### Enum

1. **CardRank Enum**
   - **Description**: Represents the rank of a card.
   - **Values**: ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING.

2. **CardSuit Enum**
   - **Description**: Represents the suit of a card.
   - **Values**: HEARTS, DIAMONDS, CLUBS, SPADES.

### Static vs Instance

1. **Deck Class**
   - **Static Variables**: deckDataHandler and deck are static, shared across all instances of the Deck class.
   - **Instance Methods**: Methods like shuffleDeck, clearDeck, and drawCard operate on the instance of the Deck class.

2. **Player Class**
   - **Instance Variables**: name, chips, bets, hands, and countValues are instance variables, unique to each player.
   - **Instance Methods**: Methods like getName, getChips, setChips, getBets, getHands, and getCountValues operate on the instance of the Player class.

3. **GameEngine Class**
   - **Static Methods**: Methods like actionLoop and determineWinners are static, as they operate on the game state rather than on an instance of the GameEngine class.

4. **UserPlayer Class**
   - **Static Variables**: gameDataHandler and settings are static, shared across all instances of the UserPlayer class.
   - **Instance Variables**: playerId is an instance variable, unique to each user player.

### Abstract Class

1. **Player Class**
   - **Description**: The Player class is an abstract class that defines common attributes and methods for all players in the game.
   - Attributes:
     - name: The name of the player.
     - chips: The number of chips the player has.
     - bets: The bets placed by the player.
     - hands: The hands of cards the player has.
     - countValues: The count values of the player's hands.
   - **Methods**:
     - getName(): Returns the name of the player.
     - getChips(): Returns the number of chips the player has.
     - setChips(Integer chips): Sets the number of chips the player has.
     - getBets(): Returns the bets placed by the player.
     - getHands(): Returns the hands of cards the player has.
     - getCountValues(): Returns the count values of the player's hands.
     - countHandValue(List<String> hand): Counts and returns the value of the hand.
     - savePlayerToFile(String file, Player player): Saves the player to a YAML file.
     - removePlayerFromYaml(String file, Integer playerId): Removes the player from a YAML file.
     - dealInitialHand(): Deals the initial hand for the player.
     - hit(int handIndex): Hits the player's hand (draws one card).
     - stand(int handIndex): Stands the player's hand (does nothing).
     - doubleDown(int handIndex): Doubles down on the player's hand (doubles the bet and draws one card).
     - split(int handIndex): Splits the player's hand (creates a new hand with the second card if the two cards have the same value).
     - updateYaml(String file, Integer playerId, String key, Object value): Updates the player in a YAML file.

2. **DataHandler Class**
   - **Description**: The DataHandler class is an abstract class that defines common methods for reading and writing data.
   - **Methods**:
     - readData(String file): Reads data from a file.
     - writeData(String file, Object data): Writes data to a file.
     - updateData(String file, String key, Object value): Updates data in a file.

### Abstract Method

1. **Player Class**
   - **Description**: The Player class defines several abstract methods that must be implemented by its subclasses (Dealer and UserPlayer).
   - **Abstract Methods**:
     - dealInitialHand(): Deals the initial hand for the player.
     - hit(int handIndex): Hits the player's hand (draws one card).
     - stand(int handIndex): Stands the player's hand (does nothing).
     - doubleDown(int handIndex) throws InsufficientChipsException: Doubles down on the player's hand (doubles the bet and draws one card).
     - split(int handIndex): Splits the player's hand (creates a new hand with the second card if the two cards have the same value).
     - updateYaml(String file, Integer playerId, String key, Object value): Updates the player in a YAML file.

2. **DataHandler Class**
   - **Description**: The DataHandler class defines an abstract method that must be implemented by its subclasses (DeckDataHandler and GameDataHandler).
   - **Abstract Method**:
     - updateData(String file, String key, Object value): Updates data in a file.

### Final Class

1. **Dealer Class**
   - **Description**: The `Dealer` class is a final class that extends the `Player` class and implements dealer-specific actions.

### Final Method

1. **UserPLayer Class**
   - **Description**: The `UserPlayer` class contains final methods to ensure that certain actions cannot be overridden by any subclass.
   - **Final Methods**:
     - dealInitialHand(): Deals the initial hand for the player.

### Interfaces

1. **PlayerActions Interface**
   - **Description**: Defines the actions that a player can perform in the game.
   - **Methods**:
     - `hit(int handIndex)`: Hits the player's hand (draws one card).
     - `stand(int handIndex)`: Stands the player's hand (does nothing).
     - `doubleDown(int handIndex) throws InsufficientChipsException`: Doubles down on the player's hand (doubles the bet and draws one card).
     - `split(int handIndex)`: Splits the player's hand (creates a new hand with the second card if the two cards have the same value).
   - **Implemented By**:
     - `Dealer`
     - `UserPlayer`

### Exceptions

1. **InsufficientChipsException**
   - **Description**: Thrown when a player tries to bet more chips than they have.

2. **InvalidPlayerDataException**
   - **Description**: Thrown when player data is invalid.
