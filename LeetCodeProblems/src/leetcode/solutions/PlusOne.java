package leetcode.solutions;

import java.util.Arrays;

public class PlusOne implements ISolution {
	
	public int[] plusOne(int[] digits){
		int[] retDigits;
		if (digits[digits.length-1] < 9){
			digits[digits.length-1] += 1;
			retDigits = Arrays.copyOfRange(digits,0,digits.length);
			return retDigits;
		}
		else{
			if (digits.length == 1)
			{
				retDigits = new int[2];
				retDigits[0]=1;
				retDigits[1]=0;
				return retDigits;
			}
			digits[digits.length-1] = 0;
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
