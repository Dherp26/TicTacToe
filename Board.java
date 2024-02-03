public class Board {
	public static void drawBoard(char[][] board) {
		System.out.println("Board:");
		for (char[] chars : board) {

			//Loop each row
			for (char aChar : chars) {
				System.out.print(aChar);
			}

			//Makes a new line on each row on a separate line
			System.out.println();
		}
	}

	//Check if all of the positions on the board have been filled
	public static boolean boardFilled(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '=') {
					return false;
				}
			}
		}
		return true;
	}
}
