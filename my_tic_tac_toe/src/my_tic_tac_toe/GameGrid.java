package my_tic_tac_toe;

public class GameGrid {
	/** This will be the tic tac toe game "board"
	 * it will use a 'virtual' 3x3 grid to keep track of
	 * 'x' and 'o' placement and be able to determine winner*/
	
	private int[][] grid = new int[3][3]; //tic tac toe grid
	private int current_row = 0; //default
	private int current_col = 0; //default
	private int current_player = -1; //default -1 to indicate 'x'
	
	public void place(String piece) {
		/** This method takes in an input String in 
		 * the form: 'x00'. This means "place x at location [0,0]" - [row, col].
		 * x will be represented by -1, and o will be represented by 1.
		 * */

		String player_is = piece.replaceAll("[0-9]", ""); //get the letter, eliminates all numbers
		String desired_location = piece.replaceAll("[^0-9]", ""); //get number, eliminate everything else
		char[] location_is = desired_location.toCharArray();
		
		if (player_is.equals("o")) {
			current_player = 1; 
		} else {
			current_player = -1;
		}
		current_row = Integer.parseInt(Character.toString(location_is[0])); 
		current_col = Integer.parseInt(Character.toString(location_is[1])); 
		
		if (grid[current_row][current_col] == 0) { //check to make sure valid location to add
			grid[current_row][current_col] = current_player; 
		} else {
			System.out.println("Location taken, pick another.");
		}
	}
	
	public String get_winner() {
		/** returns the winner */
		int x_first_row = 0;
		int y_first_row = 0;
		int x_second_row = 0;
		int y_second_row = 0;
		int x_third_row = 0;
		int y_third_row = 0;
		int x_first_col = 0;
		int y_first_col = 0;
		int x_second_col = 0;
		int y_second_col = 0;
		int x_third_col = 0;
		int y_third_col = 0;
		int x_diagonal_back_slash = 0;
		int y_diagonal_back_slash = 0;
		int x_diagonal_forward_slash = 0;
		int y_diagonal_forward_slash = 0;
		
		
		String winner_is = "No winner";
		//loop through grid to find winner
		for (int i = 0; i < grid.length; i++) {
			if (grid[0][i] == -1) {
				x_first_row += -1;
			}
			if (grid[0][i] == 1) {
				y_first_row += 1;
			}
			if (grid[1][i] == -1) {
				x_second_row += -1;
			}
			if (grid[1][i] == 1) {
				y_second_row += 1;
			}
			if (grid[2][i] == -1) {
				x_third_row += -1;
			}
			if (grid[2][i] == 1) {
				y_third_row += 1;
			}
			if (grid[i][0] == -1) {
				x_first_col += -1;
			}
			if (grid[i][0] == 1) {
				y_first_col += 1;
			}
			if (grid[i][1] == -1) {
				x_second_col += -1;
			}
			if (grid[i][1] == 1) {
				y_second_col += 1;
			}
			if (grid[i][2] == -1) {
				x_third_col += -1;
			}
			if (grid[i][2] == 1) {
				y_third_col += 1;
			}
			if (grid[i][i] == -1) {
				x_diagonal_back_slash += -1;
			}
			if (grid[i][i] == 1) {
				y_diagonal_back_slash += 1;
			}
			if (grid[i][2-i] == -1) {
				x_diagonal_forward_slash += -1;
			}
			if (grid[i][2-i] == -1) {
				y_diagonal_forward_slash += 1;
			}
		}

		if (x_first_row == -3 || x_second_row == -3 || x_third_row == -3 ||
				x_first_col == -3 || x_second_col == -3 || x_third_col == -3 ||
				x_diagonal_back_slash == -3 || x_diagonal_forward_slash == -3) {
			winner_is = "x";
		}
		if (y_first_row == 3 || y_second_row == 3 || y_third_row == 3 ||
				y_first_col == 3 || y_second_col == 3 || y_third_col == 3 ||
				y_diagonal_back_slash == 3 || y_diagonal_forward_slash == 3) {
			winner_is = "o";
		}
		
		return winner_is;
	}
	
	public void print_grid() {
		/** this will print out the game grid */
		for (int i = 0; i < grid.length; i++) { //row
			System.out.println();
			for (int j = 0; j < grid[0].length; j++) { //column
				System.out.print(grid[i][j] + " ");
			}
		}
		System.out.println();
	}
	
//	private int check_for_winner(int player, int row, int col) {
//		/** going to try recursion here....*/
//		
//		int result = 0; //default
//		
//		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) { //make sure in range
//			check_for_winner(player, row-1, col); 
//			check_for_winner(player, row-1, col-1);
//			//check_for_winner(player, )
//		}
//		
//		return result;
//	}
}
