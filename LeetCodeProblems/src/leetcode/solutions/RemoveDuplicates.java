package leetcode.solutions;

public class RemoveDuplicates implements ISolution {

	/**
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

		Do not allocate extra space for another array, you must do this in place with constant memory.

		For example,
		Given input array A = [1,1,2],

		Your function should return length = 2, and A is now [1,2].

	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A){
		/** 
		 *  use a second index pointer, while i increase for ever iteration, j only increase when j-1 != i
		 *  
		 */
		
		if (A.length < 2)
			return A.length;
		int j = 1;
		
		for (int i = 1; i < A.length; i++)
		{
			if (A[j-1] != A[i])
			{
				A[j] = A[i];
				j+=1;
			}
				
		}
		return j;	
	}
	
	public int removeDuplicates2(int[] A){
		
		if (A.length < 2)
			return A.length;
		int j = 2;
		
		for (int i = 2; i < A.length; i++)
		{
			if (A[j-2] != A[i])
			{
				A[j] = A[i];
				j+=1;
			}
				
		}
		return j;	
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [] A = {1,1,1,2,2,3};
		System.out.println(removeDuplicates2(A));
	}

}
