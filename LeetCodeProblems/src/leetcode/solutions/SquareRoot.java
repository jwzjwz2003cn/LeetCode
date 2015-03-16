package leetcode.solutions;

public class SquareRoot implements ISolution {

	/**
	 *  - use binary search
	 *  - search range 0 to x/2+1
	 * @param x
	 * @return
	 */
	public int sqrt(int x){
		
		int left = 0;
		int right = x/2 + 1;
		int mid = (left + right)/2;
		while (left <= right){
			if (mid * mid > x || (mid!=0 && Integer.MAX_VALUE/mid < mid)){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			mid = (left + right)/2;
			
		}
		return mid;
			
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		System.out.println(sqrt(2147483647));
		
	}

}
