package leetcode.solutions;

public class MinimumPathSum implements ISolution {
	
	public int minPathSum(int[][] grid){
		/**
		 *  minPath[x][y] =Min(minPath[x-1][y], minPath[x][y-1])+grid[i][j]
		 */
		int m = grid.length, n = grid[0].length;
		if (m == 0 && n == 0)
			return -1;
		int[][] minSumMat = new int[m][n];
		minSumMat[0][0] = grid[0][0];
		for (int i = 1; i < m; i++){ 
			minSumMat[i][0] = minSumMat[i-1][0] + grid[i][0]; 
		}
		for (int i = 1; i < n; i++){
			minSumMat[0][i] = minSumMat[0][i-1] + grid[0][i];
		}
		for (int i = 1; i < m && m > 1; i++){
			for (int j = 1; j < n && n > 1; j++){
				minSumMat[i][j] = Math.min(minSumMat[i-1][j], minSumMat[i][j-1])+grid[i][j];
			}
		}
		
		return minSumMat[m-1][n-1];
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2,3},{3,2,1},{4,5,6}};
		System.out.println(minPathSum(grid));
	}

}
