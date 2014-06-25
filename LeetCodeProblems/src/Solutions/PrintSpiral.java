package Solutions;
import java.util.*;

public class PrintSpiral implements ISolution {

	
	public List<Integer> printSpiral(int[][] matrix)
	{
		List<Integer> retList = new ArrayList<Integer>();
		if (matrix.length == 0)
			return retList;
		
		int layers = Math.min(matrix.length, matrix[0].length);
		layers = layers/2 + layers%2;
		for (int i = 0; i < layers; i++)
		{
			int j,k,m,n;
			
			if (matrix[i].length-2 * i == 1)
			{
				for (int x = i; x < matrix.length-i; x++){
					retList.add(matrix[x][i]);
				}
				return retList;				
			}
			
			if (matrix.length - 2 * i == 1){
				for (int y = i; y < matrix[i].length-i; y++){
					retList.add(matrix[i][y]);
				}
				return retList;				
			}
			
			
			for (j = i; j < matrix[i].length-i-1; j++)
			{
				retList.add(matrix[i][j]);
			}
			for (k = i; k < matrix.length-i-1; k++)
			{
				retList.add(matrix[k][j]);
			}
			for (m = j; m > i; m--) 
			{
				retList.add(matrix[k][m]);
			}
			for (n = k; n > i; n--)
			{
				retList.add(matrix[n][m]);
			}
		}
		return retList; 
	}
	
    public int[][] generateMatrix(int n) {
    	int[][] retMat = new int[n][n];
    	int counter = 1;
    	if (n == 0)
    		return retMat;
    	int layers = n/2 + n%2;
    	for (int i = 0; i < layers; i++){
    		if ((n-2*i) == 1){
    			for (int s = i; s < n-i; s++){
    				retMat[s][s] = counter++;
    			}
    		}
    		int j,k,x,y;
    		for ( j = i; j < n-i-1; j++){
    			retMat [i][j] = counter++;
    		}
    		for (k = i; k < n-i-1 ; k++){
    			retMat [k][j] = counter++;
    		}
    		for (x = j; x > i; x--){
    			retMat[k][x] = counter++;
    		}
    		for (y = k; y > i; y--){
    			retMat[y][x] = counter++;
    		}
    	}
    	return retMat;
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[][] table = generateMatrix(4);
		List<Integer> iList = printSpiral(table);
		for (Integer i: iList){
			System.out.println(i);
		}
	}

}
