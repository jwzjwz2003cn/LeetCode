package Solutions;


public class RotateImage implements ISolution {

	public void rotateImage(int[][] matrix){
		
		int [][] retMat = new int[matrix.length][matrix.length];
		for (int i = 0; i < retMat.length; i++){
			for (int j = 0; j < retMat.length; j++){
				retMat[i][j] = matrix[matrix.length-1-j][i];
			}
		}
		System.arraycopy(retMat, 0, matrix, 0, retMat.length);
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotateImage(matrix);
		for (int i = 0; i < matrix.length; i++){
			String row ="";
			for (int j = 0; j < matrix[i].length; j++){
				row += matrix[i][j];
			}
			System.out.println(row);
		}
	}

}
