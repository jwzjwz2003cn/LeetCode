package leetcode.solutions;

public class SearchRotatedSortedArray implements ISolution {

	public int search(int[] A, int target){
		int L = 0;
		int R = A.length-1;
		
		while (L <= R){
			int M = L + (R-L)/2;
			if (A[M] == target)
				return M;
			if (A[M]>=A[L]){
				if (A[L] <= target && target <= A[M])
					R = M -1;
				else
					L = M+1;
			}
			else{
				if (A[M] <= target && target <= A[R])
					L = M+1;
				else
					R = M-1;
				
			}
		}
		return -1; 		
	}
	
    public boolean search2(int[]A, int target){
		int L = 0;
		int R = A.length-1;
		
		while (L <= R){
			int M = L + (R-L)/2;
			if (A[M] == target || A[L] == target || A[R] == target)
				return true;
			//definitely sorted from L to M
			if (A[M]>A[L]){
				if (A[L] < target && target < A[M])
					R = M -1;
				else
					L = M+1;
			}
			else if (A[M] == A[L]){
				L = L+1;
				R = R-1;
			}
			//might be from sorted M to R 
			else{
				//13111 vs. 11131
				if (A[M] < target && target < A[R])
					L = M+1;
				else
					R = M-1;
				
			}
		}
		return false;     	
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
