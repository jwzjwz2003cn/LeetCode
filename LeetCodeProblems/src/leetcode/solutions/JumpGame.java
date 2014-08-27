package leetcode.solutions;

public class JumpGame implements ISolution {

	/**
	 * 1 dim DP
	 * keep track of the maximum distance can be reached at the index
	 * max = max(max, i+A[i])
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A){
		if (A.length == 1)
			return true;
		if (A[0] == 0)
			return false;
		int max = 0;
		for (int i = 0; i < A.length; i++){
			max = Math.max(max, i+A[i]);
			if(A[i] == 0 && max == i && i < A.length-1)
				return false;
		}
		return true;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}

}
