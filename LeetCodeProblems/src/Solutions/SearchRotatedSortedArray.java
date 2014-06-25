package Solutions;

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
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
