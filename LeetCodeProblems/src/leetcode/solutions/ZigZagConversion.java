package leetcode.solutions;

/**
 * 1. P A H N
 * 2. APLSIIG
 * 3. Y I R
 * @author Frank
 *
 * 1232123212321
 * use 3 StringBuffer to represent the number of rows
 * store characters in the fashion of 1232123212321
 * 
 */

public class ZigZagConversion implements ISolution{

	
	public String convert(String s, int nRows){
		
		StringBuffer buffer = new StringBuffer(s);
		StringBuffer[] sbArray = new StringBuffer[3];
		int index = 0;
		
		for (int i = 0; i < buffer.length(); i++){
			sbArray[index].append(buffer.charAt(i));
		}
		
		
	}
	
	//nRows-1 up and nRows-1 down
	private boolean isCountingUp(int index, int nRows){
		int set = nRows - 1;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
