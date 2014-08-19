package leetcode.solutions;

import java.util.ArrayList;

public class RadixSort implements ISolution {

	/**
	 * 
	 * @param A
	 */
	public void radixSort(int[] A, int maxDigits){
		
		int exp = 1;
		for (int i = 0; i < maxDigits; i++){
			
			ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>(10);
			
			for (int j= 0; j < A.length; j++){
				int digit = (A[j]/exp)%10;
				bucket.get(digit).add(A[j]);
			}
			
		}
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
