# Number Guessing Game

A fun, interactive Java console game where the player tries to guess a randomly generated number within a limited number of attempts.

## 🚀 Features
* **Random Generation:** Numbers are generated randomly between a set range (1-100).
* **Limited Attempts:** Players have 7 tries to guess the correct number, adding a layer of challenge.
* **Smart Feedback:** The game tells you if your guess is "Too HIGH" or "Too LOW."
* **Score Tracking:** Keeps track of how many rounds you’ve won during a single session.
* **Replayability:** Option to start a new round immediately after finishing.

## 📂 Project Structure
* `GuessingNumberBLC.java`: The Business Logic Class that handles the random number generation and guess processing.
* `GuessingNumberELC.java`: The Execution Logic Class that handles the user interface, gameplay loop, and scoring.

## 🛠️ Installation & Running
1. **Compile the program:**
   ```bash
   javac GuessingNumberELC.java

2. **Run the program:**
   ```bash
   java GuessingNumberELC
