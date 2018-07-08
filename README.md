Tic Tac Toe
================

Three players Tic-tac-toe console game

Summary
--------
After each move, the new state of the board is displayed and the
player can enter the next position of their character one after
another.

* 2 users play against each other and against the computer
* Who is starting is random
* Board size is configurable between 3x3 and 10x10. 
* User symbols (usually O and X) are can be changed.

Input format
------------
A user should type a value to put a mark in a format <Vertical,Horizontal>

Example input:  2,4

[] [] [] [] <br />
[] [] []  O <br />
[] [] [] [] <br />
[] [] [] [] <br />


The game is written in core Java (without any additional libraries)

Build automation tool: Maven,<br />
Unit-testing framework: JUnit

All settings are stored in "application.properties" file

How to build
------------

<code>"mvn clean install"</code>

You'll find an executable jar file "tic-tac-toe.jar" in folder 'target'

How to run
-----------
The following command starts the game. You should execute it from a folder with the jar file.</br>
<code>
java -jar tic-tac-toe.jar
</code>

Technical details
------------------

Singleton and strategy design patterns were used.

This is an initial version of the game.
Later improvements can be added, such as dockerizing, logic for AI level selection an so on.
