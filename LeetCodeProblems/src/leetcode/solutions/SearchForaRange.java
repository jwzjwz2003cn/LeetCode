package leetcode.solutions;

import java.util.Arrays;

public class SearchForaRange implements ISolution {

	
	/**
	 * 	binary search for the number and find the index
	 * 	binary search the the left most occurance using the left region to the index
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int[] searchRange(int [] A, int target){
		
		int [] retA = new int[2];
		int init = binarySearch(A, target);
		if (init == -1){
			retA[0] = -1; retA[1] = -1;
		}
		else{
			int left = init;
			int right = init;
			int leftMost = init;
			int rightMost = init;
			while (left != -1){
				left = binarySearch(Arrays.copyOfRange(A, 0, left), target);
				leftMost = left == -1 ? leftMost: left;
			}
			while (right != -1){
				int toRight = binarySearch(Arrays.copyOfRange(A, right+1, A.length), target); //nummber of index to the right of the current right
				right = toRight == -1 ? -1: right + toRight +1;  // need to add toRight to the right to get the right index
				rightMost = right == -1 ? rightMost: right;
			}
			retA[0] = leftMost;
			retA[1] = rightMost;
		}
		return retA;
	}
	
	public int binarySearch(int[] A, int target){
		
		int count = A.length;
		int middle = count/2;
		
		if (count == 0)   //special cases, needs to include empty array
			return -1;
		if (count == 1 && A[0] != target)
			return -1;
		
		if (A[middle] == target)		//base case when middle = target
			return middle;
		else if (target < A[middle]){
			int i = binarySearch(Arrays.copyOfRange(A, 0, middle), target);
			if (i < 0)
				return -1;
			return i;
		}
		else{
			int j = binarySearch(Arrays.copyOfRange(A, middle, A.length), target);
			if (j < 0)
				return -1;
			return middle+j;  // need to add to the middle for right index
		}
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int[] A = {0,1,1,2,3,4,5};
		int [] B = searchRange(A, 1);
		System.out.println(String.format("[%d, %d]", B[0], B[1]));
	}

}
