package leetcode.solutions;

public class FindMinimumRotatedSortedArray implements ISolution {

	
	/**
	 * iterate through array
	 * if m[i] < m[i-1], m[i] = min
	 * else m[0] = min 
	 * @param m
	 * @return
	 */
	public int findMin(int[] m){
		
		int min = m[0];
		for (int i = 0; i < m.length; i++){
			
			if (i > 0 && m[i] < m[i-1])
				min = m[i];
			
		}
		return min;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] m = {4,5,6,7,0,1,2};
		System.out.println(findMin(m));
 		
	}

}
