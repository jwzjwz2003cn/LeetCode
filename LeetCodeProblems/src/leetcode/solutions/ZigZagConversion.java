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
		
		if (s == null || s.isEmpty() || nRows == 1)
			return s;
		
		String rtnVal = "";
		StringBuffer buffer = new StringBuffer(s);
		StringBuffer[] sbArray = new StringBuffer[nRows];
		int index = 0;
		
		for (int i = 0; i < buffer.length(); i++){
			if (sbArray[index] == null)
				sbArray[index] = new StringBuffer();
			sbArray[index].append(buffer.charAt(i));
			if (isCountingUp(i, nRows))
				index ++;
			else
				index --;
		}
		
		for (int j = 0; j < sbArray.length; j++){
			if (sbArray[j] != null)
				rtnVal += sbArray[j].toString();
		}
		return rtnVal;
		
		
	}
	
	//nRows-1 up and nRows-1 down, odd to be true, even to be false
	private boolean isCountingUp(int index, int nRows){
		int set = nRows - 1;
		index = index + 1;
		int iter = (index % set == 0) ? (index / set): (index/set + 1);
		if (iter % 2 == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
		
	}

}
