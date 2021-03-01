/**
 * 
 */
package cs145.tictactoe;

import java.util.Scanner;

/**
 * This class allows you to play a game of Tic Tac Toe in Java
 * 
 * @author KamenickNoah
 * @version 02.26.2021
 */
public class TicTacToe {

	// Declarations

	private char currentPlayer;

	private char board[][];

	private char winner;

	private char nextPlayer;

	private boolean validInput;

	private boolean running;

	private char previous;

	private int col;

	private int row;

	/**
	 * 
	 * Default constructor that sets up the board for Tic Tac Toe
	 * 
	 */

	public TicTacToe() {

		currentPlayer = 'X';

		winner = ' ';

		nextPlayer = 'O';

		previous = ' ';

		board = new char[3][3];

		for (int r = 0; r < board.length; r++) {

			for (int c = 0; c < board[r].length; c++) {

				board[r][c] = ' '; // Init array to blank spaces

			}

		}

	}

	/**
	 * 
	 * A getter method for the CurrentPlayer char variable
	 * 
	 * @return char that represents the current player
	 */

	public char getCurrentPlayer() {

		return currentPlayer;

	}

	/**
	 * 
	 * A getter method for the NextPlayer char variable
	 * 
	 * @return char that represents the next player
	 */

	public char getNextPlayer() {

		return nextPlayer;

	}

	/**
	 * 
	 * A getter method for the winner char variable
	 * 
	 * @return char that represents the winning player
	 */

	public char getWinner() {

		return winner;

	}

	/**
	 * 
	 * Getter Method that returns the board as a char array
	 * 
	 * @return the board as a char array
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * 
	 * Setter Method that sets the board values
	 * 
	 * @param board the board to set
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}

	/**
	 * Checks if the calling object has valid Input
	 * 
	 * @return the validInput
	 */
	public boolean isValidInput() {
		return validInput;
	}

	/**
	 * Setter method for the validInput boolean
	 * 
	 * @param validInput the validInput to set
	 */
	public void setValidInput(boolean validInput) {
		this.validInput = validInput;
	}

	/**
	 * 
	 * Getter Method for the isRunning boolean
	 * 
	 * 
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * 
	 * Setter method for setting the running status boolean
	 * 
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * 
	 * Getter for the col int variable
	 * 
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * 
	 * Setter for the col int variable
	 * 
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * 
	 * 
	 * Getter for the row int variable
	 * 
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * Setter for the row int variable
	 * 
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Setter for Current player char variable
	 * 
	 * @param currentPlayer the currentPlayer to set
	 */
	public void setCurrentPlayer(char currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * 
	 * Setter for winner char variable
	 * 
	 * @param winner the winner to set
	 */
	public void setWinner(char winner) {
		this.winner = winner;
	}

	/**
	 * 
	 * Setter for nextPlayer char variable
	 * 
	 * @param nextPlayer the nextPlayer to set
	 */
	public void setNextPlayer(char nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	/**
	 * 
	 * Getter for previous char variable
	 * 
	 * @return the previous
	 */
	public char getPrevious() {
		return previous;
	}

	/**
	 * 
	 * 
	 * Setter previous char variable
	 * 
	 * @param previous the previous to set
	 */
	public void setPrevious(char previous) {
		this.previous = previous;
	}

	/**
	 * 
	 * This method checks to see if the first and second numbers inputted by the
	 * user are legal. Checks if the length is 2 characters long, and there isn't
	 * any whitespace, and that the input isn't part of the alphabet. The string
	 * input is then parsed into an integer and checked to see if it meets the range
	 * given on the ticTacToe board. If so, then return it to the method as an int.
	 * 
	 * @param scannerSubstringInput substring from a string
	 * @return the checked digit from the users' substring input
	 */
	public int checkInput(String scannerSubstringInput) {

		if (scannerSubstringInput.length() == 1 && !scannerSubstringInput.isBlank()
				&& !Character.isAlphabetic(scannerSubstringInput.charAt(0))) // If input contains a number and
		// is not blank
		{

			int inputInt = Integer.parseInt(scannerSubstringInput);

			if (inputInt >= 0 && inputInt <= 2) {

				return inputInt;

			}

			else {

				System.out.println("Number out of Range: enter values between 0 and 2");

			}

		}

		else {
			System.out.println(
					"Input doesn't contain 2 digit without a space: Please enter numbers between 0 and 2 in form xy");

		}

		return 5;

	}

	/**
	 * 
	 * This inputs the currentPlayers chosen coords and takes a turn. Also sets
	 * previous for correct winner. Gather info from array according to resp- ective
	 * xy value positions. Set's current player to O if it's X, X if it's O, and
	 * returns true to the method.
	 * 
	 * @param x value from int row
	 * @param y value from int col
	 * @return a boolean indicating if the turn has completed successfully
	 */

	public boolean takeTurn(int x, int y) { // takes in x and y value through params

		if (board[y][x] == ' ') { // if loop hits the values of col and row, and the
			setPrevious(getCurrentPlayer()); // element is a space character
			board[y][x] = currentPlayer; // set element value of current index to either x or y, depending on the
											// currentPlayer
			switch (this.getCurrentPlayer()) { // depending on who the currentPlayer is
			case 'X': // if its X, change currentPlayer to O, set nextPlayer to opposite, return true
						// to method heading
				this.setCurrentPlayer('O');
				this.setNextPlayer('X');
				return true;
			case 'O': // if currentPlayer is O, change currentPlayer to X, set nextPlayer to opposite,
						// return true to method
						// heading
				this.setCurrentPlayer('X');
				this.setNextPlayer('O');
				return true;
			default: // if something fails for some reason, notify and return false
				System.out.println("Fatal Error");
				return false;
			}

		}

		else if (board[y][x] != ' ') { // if none of the conditions come out to work, notify the user to try again

			System.out.print(x + " , " + y + " is occupied. Try again\n");
			return false;

		}

		return false;
	}

	/**
	 * 
	 * This method tests TicTacToe logic through different if statements. Sets a
	 * winner to previous since this method needs to run and save the real winner,
	 * not the oppposite.
	 * 
	 * 
	 * @return either true or false if there is a winner or not
	 */

	public boolean checkForWinner() {

		if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
				| (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')) {
			this.setWinner(previous);
			return true;

		}

		else if ((board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
				| (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')) {

			this.setWinner(previous);
			return true;
		}

		else if ((board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
				| (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')) {

			this.setWinner(previous);
			return true;
		}

		else if ((board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
				| (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')) {

			this.setWinner(previous);
			return true;
		}

		else if ((board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
				| (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')) {

			this.setWinner(previous);
			return true;
		} else if ((board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
				| (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')) {

			this.setWinner(previous);
			return true;
		}

		else if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
				| (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')) {

			this.setWinner(previous);
			return true;
		}

		else if ((board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')
				| (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')) {

			this.setWinner(previous);
			return true;
		}

		else {

		}

		return false;

	}

	/**
	 * 
	 * Prints the board and the values from the board 2D array
	 * 
	 * 
	 * @return formatted board as a string
	 */

	public String toString() {

		while (winner == ' ') {
			String s = "Play TicTacToe" + "\nCurrent Player: " + this.getCurrentPlayer() + "\nNext Player: "
					+ this.nextPlayer + "\n\t0 \t1 \t2";

			for (int r = 0; r < board.length; r++) {

				s += "\n" + r;

				for (int c = 0; c < board[r].length; c++) {

					s += "\t";

					switch (board[r][c]) {
					case 'X':
						s += board[r][c];
						break;
					case 'O':
						s += board[r][c];
						break;
					case ' ' | '-':
						s += board[r][c];
						break;

					}

				}

			}

			return s;

		}

		return "";

	}

	/**
	 * Runs the game
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// System.out.println("Spot taken, try Again: ");

		// -----------------SET GAME UP--------------------

		TicTacToe gameTest = new TicTacToe(); // New object

		Scanner n = new Scanner(System.in);

		Scanner keyboard = new Scanner(System.in); // Create new Scanner object for user input

		gameTest.setRunning(true);

		gameTest.setValidInput(false);

		do {
			//Do
			System.out.print(gameTest.toString()); // Print the board

			do {
				//But do user input validation first
				System.out.print("\nEnter coords xy (ex. 00): "); // Prompt User Input

				String input = keyboard.next(); // Assign user string input

				gameTest.setCol(gameTest.checkInput(input.substring(0, 1))); // Extract x value from coord string input

				gameTest.setRow(gameTest.checkInput(input.substring(1, 2))); // extract y value from coord string input

				if (gameTest.getCol() >= 0 && gameTest.getRow() >= 0 && gameTest.getCol() != 5
						&& gameTest.getRow() != 5) {

					gameTest.setValidInput(true);

				}

			} while (gameTest.isValidInput() == false);

			gameTest.takeTurn(gameTest.getCol(), gameTest.getRow()); // Pass x and y ints into and run takeTurn method

			gameTest.checkForWinner();

			
			//if game detects a winner 
			
			if (gameTest.checkForWinner() == true) {

				System.out.print(gameTest.previous + " is the winner! Play again? (Y/n): ");

				String keyboardTwo = n.next();

				if (keyboardTwo.equalsIgnoreCase("y")) {

					gameTest.setRunning(true);

					gameTest.setValidInput(false);

					gameTest.setCurrentPlayer('X');

					gameTest.setWinner(' ');

					gameTest.setPrevious(' ');

					gameTest.setNextPlayer('O');

					for (int r = 0; r < gameTest.getBoard().length; r++) {

						for (int c = 0; c < gameTest.getBoard()[r].length; c++) {

							gameTest.getBoard()[r][c] = ' '; // Init array to blank spaces

						}

					}

					continue;

				}

				if (keyboardTwo.equalsIgnoreCase("n")) {

					System.out.println("Come Again!");
					gameTest.setRunning(false);

				}

			}

			else {

				gameTest.setRunning(true);
				continue;

			}

		} while (gameTest.isRunning() == true);

		keyboard.close();
		n.close();
	}
}