package leetcode.solutions;

public class UniquePaths implements ISolution {

	public int uniquePaths(int m, int n){
		int[][] grids = new int [m][n];
		if (m == 1 || n == 1)
			return 1;
		for (int i = 0; i < m; i++){
			grids[i][0] = 1;
		}
		for (int j = 0; j < n; j++){
			grids[0][j] = 1;
		}
		for (int i = 1; i < m; i++){
			for (int j= 1; j < n; j++){
				grids[i][j] = grids[i-1][j] + grids[i][j-1] ;
			}
		}
		return grids[m-1][n-1];
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
