import java.util.Scanner;

public class JavaMain2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Size of tictactoe
		System.out.print("Insert size of tic tac toe board : ");
		int boardSize = scan.nextInt();

		char[][] board = new char[boardSize][boardSize];

		//Create board
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = '=';
			}
		}

		Scanner in = new Scanner(System.in);
		System.out.print("Player 1: ");
		String p1 = in.nextLine();
		System.out.print("Player 2:");
		String p2 = in.nextLine();
		//For changing turn player1 and player2
		boolean player1 = true;

		boolean gameOver = false;
		while (!gameOver) {

			//Draw the board
			Board.drawBoard(board);

			//Print whose turn it is
			if (player1) {
				System.out.println(p1 + "'s Turn is (x):");
			} else {
				System.out.println(p2 + "'s Turn is (o):");
			}

			//Create a char variable that stores either 'x' or 'o' based on what player's turn it is
			char c = '-';
			if (player1) {
				c = 'x';
			} else {
				c = 'o';
			}

			//Create row and col variables which represent indexes that correspond to a position on our board
			int row = 0;
			int col = 0;

			//Only break out of the while loop once the user enters a valid position
			while (true) {

				//Ask the user for what position they want to place their x or o
				System.out.print("Enter a row number: ");
				row = in.nextInt();
				System.out.print("Enter a column number: ");
				col = in.nextInt();

				//Check if the row and col are outside of the board
				if (row < 0 || col < 0 || row >= boardSize || col >= boardSize) {
					System.out.println("This position is off the bounds of the board! Try again.");

					//Check if the position on the board the user entered is empty (has a -) or not
				} else if (board[row][col] != '=') {
					System.out.println("Someone has already made a move at this position! Try again.");

					//Otherwise, the position is valid so break out of the while loop
				} else {
					break;
				}
			}

			//Set the position on the board at row, col to c
			board[row][col] = c;

			//Check to see if either player has won
			if (playerHasWon(board) == 'x') {
				System.out.println(p1 + " has won!");
				gameOver = true;
			} else if (playerHasWon(board) == 'o') {
				System.out.println(p2 + " has won!");
				gameOver = true;
			} else {

				//If neither player has won, check to see if there has been a tie (if the board is full)
				if (Board.boardFilled(board)) {
					System.out.println("It's a tie!");
					gameOver = true;
				} else {

					//If player1 is true, make it false, and vice versa; this way, the players alternate each turn
					player1 = !player1;
				}
			}
		}

		//Draw the board at the end of the game
		Board.drawBoard(board);
	}

	//Make a function to see if someone has won and return the winning char
	public static char playerHasWon(char[][] board) {

		// Checking each row
		for (int i = 0; i < board.length; i++) {

			// The boolean inARow is true if a player has won by putting n of their chars in row i and false otherwise
			boolean inARow = true;

			// The char value is one of the chars in row i; we can use this to check if every other char in row i is equal to value
			char value = board[i][0];

			// First we have to check if the value is not -, because if it is, that means that there is an empty spot in the row so we can automatically say that inARow is false
			if (value == '=') {
				inARow = false;

				// Otherwise, we can use a nested for loop to check each position in the row starting at index 1 (since index 0 is our value and we don't need to check if board[i][0] equals value) and check if that position equals value
			} else {
				for (int j = 1; j < board[i].length; j++) {

					// If board[i][j] doesn't equal value, then we know that inARow is false; we can also break out of the nested for loop because we don't need to look at the rest of this row
					if (board[i][j] != value) {
						inARow = false;
						break;
					}
				}
			}
		}
		return ' ';
	}
}