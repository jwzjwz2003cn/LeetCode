package leetcode.solutions;

import java.util.ArrayList;

public class RadixSort implements ISolution {

	/**
	 * O(kN) perfornabce
	 * O(k+N) space complexity
	 * @param A
	 */
	public void radixSort(int[] A, int maxDigits){
		
		int exp = 1;
		for (int i = 0; i < maxDigits; i++){
			
			ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>(10);
			for (int k = 0; k < 10; k++){
				bucket.add(new ArrayList<Integer>()); //initialize bucket for each digits
			}
			
			for (int j= 0; j < A.length; j++){
				int digit = (A[j]/exp)%10;      //current significant digit
				bucket.get(digit).add(A[j]);	// add to the bucket
			}
			
			exp *= 10;
			int index = 0;
			for (int k = 0; k < 10; k++){   		//add the bucket back to the array
				for (Integer num: bucket.get(k)){
					A[index] = num;
					index ++;
				}
			}
			
		}
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {42,234,313,125,514};
		radixSort(A, 3);
		for (int i = 0; i < A.length; i++){
			System.out.println(A[i]);
		}
		
	}

}
