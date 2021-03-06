package leetcode.solutions;

import java.util.Arrays;

public class PlusOne implements ISolution {
	
	/**
	 * When last digit < 9, simply + 1 to last digit
	 * Otherwise, use recursion base case when digits.length = 1 and digits = 9
	 * @param digits
	 * @return
	 */
	
	public int[] plusOne(int[] digits){
		int[] retDigits;
		if (digits[digits.length-1] < 9){ // when last digits = 1-8
			digits[digits.length-1] += 1;
			retDigits = Arrays.copyOfRange(digits,0,digits.length);
			return retDigits;
		}
		else{ 							// when last digits == 9
			if (digits.length == 1)
			{
				retDigits = new int[2];
				retDigits[0]=1;
				retDigits[1]=0;
				return retDigits;
			}
			digits[digits.length-1] = 0; //last digits to 0
			int[] subArray = Arrays.copyOfRange(digits, 0, digits.length-1);
			int[] allButLastDigits = plusOne(subArray);
			if (allButLastDigits.length > subArray.length){
				retDigits = new int[digits.length+1];
			}
			else{
				retDigits = new int[digits.length];
			}
			for (int i = 0; i < allButLastDigits.length; i++){
				retDigits[i] = allButLastDigits[i];
			}
			retDigits[retDigits.length-1] = digits[digits.length-1];
			return retDigits;
		}
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,3,4,5,6,7,8,9};
		int[] b = plusOne(a);
		for (int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
	}

}
