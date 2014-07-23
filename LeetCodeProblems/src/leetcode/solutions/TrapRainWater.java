package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TrapRainWater implements ISolution {

	
	/**
	 * 
	 * 1. Map the highest left bank relative to position i
	 * 2. Map the highest right bank relative to position i
	 * 3. For each A[i], the trapped water volume is min(leftHighestBank, rightHighestBank)-A[i]
	 * @param A
	 */
	public int trap(int[] A){
		
		if (A.length <= 2){
			return 0;
		}
		
		int[] leftHighest = new int[A.length];
		int[] rightHighest = new int[A.length];
		
		int totalWater = 0;
		
		leftHighest[0] = A[0];
		rightHighest[A.length-1] = A[A.length-1];
		for (int i = 1; i < A.length; i++){
			if(leftHighest[i-1]<A[i])
				leftHighest[i] = A[i];
			else
				leftHighest[i] = leftHighest[i-1];
		}
		
		for (int i = A.length-2; i>=0; i--){
			if(rightHighest[i+1]<A[i])
				rightHighest[i] = A[i];
			else
				rightHighest[i] = rightHighest[i+1];
		}
		
		for (int i = 0; i < A.length; i++){
			int effectiveHeight = Math.min(leftHighest[i], rightHighest[i]);
			if (effectiveHeight > A[i]){
				int volume = effectiveHeight - A[i];
				totalWater += volume;
			}
		}
		return totalWater;
	}
	
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		//int[] A = {5,4,1,2};
		//int[] A = {2,1,0,2};
		int[] A = {4,2,0,3,2,5};
		System.out.println(trap(A));
	}

}
