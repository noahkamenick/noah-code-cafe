package cs145.tictactoe;

/**
 * 
 * These are Junit tests for various methods within the TicTacToe class
 * 
 * @author Noah Kamenick
 * 
 * @version 02.26.2021
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeTest {

	/**
	 * 
	 * Tests the values instantiated by the default constructor
	 * 
	 */

	@Test
	void testTicTacToe() {

		TicTacToe tic = new TicTacToe();

		assertEquals('X', tic.getCurrentPlayer());
		assertEquals(' ', tic.getWinner());
		assertEquals('O', tic.getNextPlayer());
		assertEquals(' ', tic.getPrevious());

	}

	/**
	 * 
	 * 
	 * Tests the validInput setter
	 * 
	 * 
	 */

	@Test
	void testSetValidInput() {

		TicTacToe valid = new TicTacToe();

		valid.setValidInput(false);
		assertEquals(false, valid.isValidInput());
		valid.setValidInput(true);
		assertEquals(true, valid.isValidInput());

	}

	/**
	 * 
	 * 
	 * Tests the setRunning setter
	 * 
	 * 
	 * 
	 */

	@Test
	void testSetRunning() {

		TicTacToe setRunning = new TicTacToe();

		setRunning.setRunning(true);
		assertEquals(true, setRunning.isRunning());
		setRunning.setRunning(false);
		assertEquals(false, setRunning.isRunning());
	}

	/**
	 * 
	 * 
	 * Tests the setCol setter method
	 * 
	 */

	@Test
	void testSetCol() {

		TicTacToe setCol = new TicTacToe();

		setCol.setCol(2);
		assertEquals(2, setCol.getCol());
		setCol.setCol(0);
		assertEquals(0, setCol.getCol());
	}

	/**
	 * 
	 * 
	 * Tests the setRow setter method
	 * 
	 */

	@Test
	void testSetRow() {

		TicTacToe setRow = new TicTacToe();

		setRow.setRow(2);
		assertEquals(2, setRow.getRow());
		setRow.setRow(1);
		assertEquals(1, setRow.getRow());

	}

	/**
	 * 
	 * 
	 * tests the setCurrentPlayer setter method
	 * 
	 */

	@Test
	void testSetCurrentPlayer() {

		TicTacToe currentPlayer = new TicTacToe();

		currentPlayer.setCurrentPlayer('O');
		assertEquals('O', currentPlayer.getCurrentPlayer());
		currentPlayer.setCurrentPlayer('X');
		assertEquals('X', currentPlayer.getCurrentPlayer());

	}

	/**
	 * 
	 * 
	 * Tests the setWinner setter method
	 * 
	 */

	@Test
	void testSetWinner() {

		TicTacToe setWin = new TicTacToe();

		setWin.setWinner('X');
		assertEquals('X', setWin.getWinner());
		setWin.setWinner('O');
		assertEquals('O', setWin.getWinner());
	}

	/**
	 * 
	 * Tests the setNextPlayer setter method
	 * 
	 * 
	 */
	@Test
	void testSetNextPlayer() {

		TicTacToe nextPlay = new TicTacToe();

		nextPlay.setNextPlayer('X');
		assertEquals('X', nextPlay.getNextPlayer());
		nextPlay.setNextPlayer('O');
		assertEquals('O', nextPlay.getNextPlayer());
	}

	/**
	 * 
	 * Tests the checkInput method
	 * 
	 * 
	 * 
	 */

	@Test
	void testCheckInput() {

		TicTacToe checkInput2 = new TicTacToe();

		TicTacToe checkInput = new TicTacToe();

		// test substring extraction

		String number = "00";

		checkInput.setCol(checkInput.checkInput(number.substring(0, 1)));

		checkInput.setRow(checkInput.checkInput(number.substring(1, 2)));

		assertEquals(0, checkInput.getCol());

		assertEquals(0, checkInput.getRow());

		// test substring extraction on second string

		String number2 = "21";

		checkInput2.setCol(checkInput2.checkInput(number2.substring(0, 1)));

		checkInput2.setRow(checkInput2.checkInput(number2.substring(1, 2)));

		assertEquals(2, checkInput2.getCol());

		assertEquals(1, checkInput2.getRow());

	}

	/**
	 * 
	 * 
	 * 
	 * Tests the takeTurn method
	 * 
	 */

	@Test
	void testTakeTurn() {

		TicTacToe takeTurnObj = new TicTacToe();

		char takeTurnBoard[][] = new char[3][3];

		// Test values in board

		takeTurnBoard[0][2] = 'O';

		takeTurnBoard[1][1] = ' ';

		takeTurnBoard[2][0] = 'X';

		takeTurnObj.setBoard(takeTurnBoard);

		// already occupied

		assertEquals(false, takeTurnObj.takeTurn(0, 2));

		// Open to make a turn here

		assertEquals(true, takeTurnObj.takeTurn(1, 1));

		assertEquals(false, takeTurnObj.takeTurn(2, 0));

	}

	/**
	 * 
	 * 
	 * tests the checkForWinner method
	 * 
	 * 
	 */

	@Test
	void testCheckForWinner() {

		TicTacToe checkOWins = new TicTacToe();

		char testOWins[][] = new char[3][3];

		// O wins across the top of the board

		testOWins[0][0] = 'O';

		testOWins[0][1] = 'O';

		testOWins[0][2] = 'O';

		testOWins[1][0] = ' ';

		testOWins[1][1] = ' ';

		testOWins[1][2] = 'X';

		testOWins[2][0] = 'X';

		testOWins[2][1] = ' ';

		testOWins[2][2] = ' ';

		checkOWins.setBoard(testOWins);

		assertEquals(true, checkOWins.checkForWinner());

		TicTacToe checkXWins = new TicTacToe();

		char testXWins[][] = new char[3][3];

		// X wins diagonally starting from the right of the board

		testXWins[0][0] = 'X';

		testXWins[0][1] = ' ';

		testXWins[0][2] = 'O';

		testXWins[1][0] = ' ';

		testXWins[1][1] = 'X';

		testXWins[1][2] = 'O';

		testXWins[2][0] = 'O';

		testXWins[2][1] = ' ';

		testXWins[2][2] = 'X';

		checkXWins.setBoard(testXWins);

		assertEquals(true, checkXWins.checkForWinner());

	}

	/**
	 * 
	 * 
	 * This method tests the toString method and its output
	 * 
	 * 
	 */

	@Test
	void testToString() {

		TicTacToe checkOWin = new TicTacToe();

		assertEquals("Play TicTacToe\nCurrent Player: X\nNext Player: O\n\t0 \t1 \t2\n0\t\t\t\n1\t\t\t\n2\t\t\t",
				checkOWin.toString());

	}

}
