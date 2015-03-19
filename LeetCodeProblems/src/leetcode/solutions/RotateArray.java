package leetcode.solutions;

public class RotateArray implements ISolution {

	
	/**
	 * method 1: calculate final index and store in a hashmap against original index O(N) time and space
	 * method 2: calculate final index for the current index until counter == nums.length  O(N) time and O(1) space
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k){
		
		//k = 0, nums.length % k = 0 || empty nums 
		if (k == 0 || k % nums.length == 0 || nums.length == 0)
			return;
		
		if (k > nums.length)
			k = k % nums.length;
		int length = nums.length;
		int count = 1;
		int current = 0;
		int currentCopy = nums[current];  // store a copy of current number
		while (count <= length){
			int newIndex = current + k < length ? current + k : current + k - length;
			int temp = nums[newIndex];    // replace currentCopy with the new number
			nums[newIndex] = currentCopy;
			currentCopy = temp;
			current = newIndex;		// update current index pointer
			
			if (count * k % length == 0){
				current += 1; 
				currentCopy = nums[current];
			}
				
			count += 1;

		}
		
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		rotate(nums, 2);
		for (int i: nums){
			System.out.print(i + " ");
		}
	}

}
