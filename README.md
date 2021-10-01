# Monopoly

This is a multiplayer Monopoly game that runs on a remote server while players connect via the client desktop application on their machines.
This will fulfill the project requirements for the CS3321 Course Project

## Installation
 Coming Soon

## Usage 
Coming Soon
## MVP
The MVP for this project must consist of at least the following:

A Graphical User Interface which  depicts all players, the board, and any animations showing what occurs during game play.
A Client which houses the UI and which connects to a game server, this client must be implemented as a desktop client. It may not be a separate web interface
A microservice providing the game engine
The basic rules of gameplay which include the following
Setup of a new game between 2 or more connected clients
Management of the bank (including houses, hotels, money, chance and community chest cards)
Management of Gameplay
Roll of the dice
Knowledge of board state including player locations
Sending game state data to client (including any details such as the player went to Jail, they can roll again, they passed go, etc.)
Receiving information from clients such as desire to buy property, paying rent, etc.
Bankruptcy and Handling of End of Game
Saving the state of the game in a data store, with the option of loading a prior game.
The basic datastore is simply a named json file. (But this may be replaced, as a feature enhancement, with a database using an ORM)
Additional Rules (mortgaging property, selling property, selling buildings, trading, etc.) are considered advanced and do not require implementation in the MVP
These can be features to implement to achieve the requirements for a B or an A

# Credits

CS 3321 Team 3, The Team Without a Name, consisting of:

Pawan Acharya

Rowan Murphy

Fernando Diaz

Madison May


License:
MIT License

Copyright (c) 2021 The-Team-Without-A-Name

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
