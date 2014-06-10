package Solutions;

public class SearchMatrix implements ISolution {

	public boolean searchMatrix(int[][] matrix, int target){
		
		int rowLength = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[matrix.length-1][rowLength-1])
			return false;
		for (int i = 0; i < matrix.length; i++){
			if (target <= matrix[i][rowLength-1]){
				if (target == matrix[i][rowLength-1])
					return true;
				for (int j = 0; j < rowLength; j++){
					if (matrix[i][j]== target)
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		System.out.println(searchMatrix(matrix, 3));
	}
}
