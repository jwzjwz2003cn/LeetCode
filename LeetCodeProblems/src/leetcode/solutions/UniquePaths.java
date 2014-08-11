package leetcode.solutions;

public class UniquePaths implements ISolution {
	
	/**
	 * 2D DP
	 * use a 2d array grid to store the number of unique paths for each indexes
	 * grids[i][j] = grids[i-1][j] + grids[i][j-1]
	 * base cases are first row and first column, since there will always be only
	 * one way to move up and down
	 * @param m
	 * @param n
	 * @return
	 */

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
	
	/**
	 * an 2d grid is passed in with obstacles represented by 1
	 * same as UniquePath 1, except if obstacle will be considered
	 * @return
	 */
	public int uniquePaths2(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] grid = new int[m][n];
		
		if (m == 0 && n == 0)
			return 0;
		
		if (obstacleGrid[0][0] == 1)
			return 0;
		grid[0][0] = 1; // we have to assume the starting point can never be 0, as well as the end point
		for (int i = 1; i < m; i++){
			if (grid[i-1][0] == 0 || obstacleGrid[i][0] == 1)
				grid[i][0] = 0;
			else
				grid[i][0] = 1;
		}
		for (int j = 1; j < n; j++){
			if (grid[0][j-1] == 0 || obstacleGrid[0][j] == 1)
				grid[0][j] = 0;
			else
				grid[0][j] = 1;
		}
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (obstacleGrid[i][j] == 1)
					grid[i][j] = 0;
				else
					grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}
		return grid[m-1][n-1];
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [][] obstacle = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePaths2(obstacle));
	}
	
	
	
}
