package leetcode.solutions;

public class FindPeak implements ISolution {

	
	/**
	 * - use binary search
	 * - if mid+1 is greater than mid, assume peak on the right
	 * - if mid+1 is less than mid, assume peak on the left (including mid)
	 * - terminate when !(l < r)
	 * @param num
	 * @return
	 */
	public int findPeakElement(int[] num){
		
		int left = 0;
		int right = num.length-1;
		int mid = (left + right) / 2;
		while (left < right) {
			
			if (num[mid + 1] > num[mid])
				left = mid + 1;
			else
				right = mid;
			
			mid = (left + right)/2;
		}
		return mid;
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int[] num = {1,2,3,1};
		System.out.println(findPeakElement(num));
	}

}
