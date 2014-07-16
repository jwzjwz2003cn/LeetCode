package leetcode.solutions;

public class ValidSudoku implements ISolution {

	public boolean isValidSudoku(char[][] board){
		/**
		 * Check each of the rows, columns and squares
		 * use a tester array net int[9] to test if number 1-9 appeared only once in each of the row, column and square 
		 */
		int m = board.length;
		int n = board[0].length;
		if (m != 9 || n != 9)
			return false;
		int[] tester;
		for (int i = 0; i < 9; i++){
			tester = new int[9];
			for (int j= 0; j<9; j++){
				if (board[i][j]!='.'){
					int num = Character.getNumericValue(board[i][j]);
					if (num > 9 || num < 1)
						return false;
					if (tester[num-1]!=0)
						return false;
					tester[num-1] = num;
				}
			}
		}
		
		for (int i = 0; i < 9; i++){
			tester = new int[9];
			for (int j= 0; j<9; j++){
				if (board[j][i]!='.'){
					int num = Character.getNumericValue(board[j][i]);
					if (num > 9 || num < 1)
						return false;
					if (tester[num-1]!=0)
						return false;
					tester[num-1] = num;
				}
			}
		}
		
		for (int i = 1; i < 9; i+=3){
			for (int j = 1; j < 9; j+=3){
				tester = new int[9];
				for (int x = i-1; x<=i+1; x++){
					for (int y = j-1; y<=j+1; y++){
						if(board[x][y]!='.'){
							int num = Character.getNumericValue(board[x][y]);
							if (num > 9 || num < 1)
								return false;
							if (tester[num-1]!=0)
								return false;
							tester[num-1] = num;
						}
					}
				}
			}
		}
		return true;
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		char[][] board = {{'.','.','.','.','.','.','5','.','.'}, {'.','.','.','.','.','.','.','.', '.'}, {'.','.','.','.','.','.','.','.', '.'}, {'9','3','.','.','2','.','4','.', '.'}, {'.','.','7','.','.','.','3','.', '.'}, {'.','.','.','.','.','.','.','.', '.'}, {'.','.','.','3','4','.','.','.', '.'}, {'.','.','.','.','.','3','.','.', '.'}, {'.','.','.','.','.','5','2','.', '.'}};
		System.out.println(isValidSudoku(board));
	}

}
