package leetcode.solutions;

public class SetMatrixZeros implements ISolution {
	
    public void setZeroes(int[][] matrix) {
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean firstRowZero = false;
    	boolean firstColZero = false;
    	/**
    	 * Need to flag whether matrix[0][0] are meant for row zeroes or column zeroes
    	 */
    	for (int i = 0; i < m; i++){
    		for (int j = 0; j < n; j++){
    			if (matrix[i][j] == 0){
    				if  (i== 0){
    					firstRowZero = true;
    				}
    				if (j==0){
    					firstColZero = true;
    				}
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	
    	for (int i = m-1; i >= 0; i--){
    		for (int j = n-1; j >= 0; j--){
    			if (matrix[0][j] == 0 || matrix[i][0] == 0){
    				if (i==0)
    				{
    					if(firstRowZero){
    						matrix[i][j] = 0;
    					}
    				}
    				else if (j==0){
    					if(firstColZero){
    						matrix[i][j] = 0;
    					}
    				}
    				else{
        				matrix[i][j] = 0;
    				}

    			}
    		}
    	}   
        
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,1,1,1,0}, {1,1,1,1,0}, {1,1,1,1,1}};
		setZeroes(matrix);
		String output = "";
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				output = output + matrix[i][j] +" ";
			}
			output += "\n";
		}
		System.out.println(output);
	}

}
