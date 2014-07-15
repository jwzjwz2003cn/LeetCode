package leetcode.solutions;

public class ValidSudoku implements ISolution {

	public boolean isValidSudoku(char[][] board){
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
					if (num > 9 || num < 9)
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
					int num = Character.getNumericValue(board[i][j]);
					if (num > 9 || num < 9)
						return false;
					if (tester[num-1]!=0)
						return false;
					tester[num-1] = num;
				}
			}
		}
		
		
		return true;
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
