package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ThreeSum implements ISolution {
	
	/**
	 * 1. sort the array
	 * 2. back tracking with a stack
	 * 3. stop condition: solution found & currentSum - currentMin > 0
	 * @param nums
	 * @return
	 */
	
	public void searchSolution (List<List<Integer>> retList, Stack<Integer> solution, int[] nums, int i, int sum){
		
		//add solution
		solution.push(nums[i]);
		sum -= nums[i];
		
		if (sum == 0 && solution.size() == 3){
			retList.add(new ArrayList<Integer>(solution));
		} else {
			if (solution.size() < 3){
				for (int j = i+1; j < nums.length; j++){
					searchSolution(retList, solution, nums, j, sum);
				}
			}

		}
		
		
		//remove solution
		solution.pop();
		sum += nums[i];
		
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
    	
    	Arrays.sort(nums);
    	List<List<Integer>> retList = new ArrayList<List<Integer>>();
    	
    	Stack<Integer> solution = new Stack<Integer>();
    	
    	for (int i = 0; i < nums.length - 2; i++){
    		if (!(i > 0 && nums[i] == nums[i-1])){
    			searchSolution(retList, solution, nums, i, 0);
    		}
    		
    	}
    	return retList;
        
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] nums = {-15,10,0,-2,14,-1,-10,-14,10,12,6,-6,10,2,-11,-9,2,13,2,-9,-14,-12,-10,-12,13,13,-10,-3,2,-11,3,-6,6,10,7,5,-13,4,-2,12,1,-11,14,-4,6,-12,-6,-14,8,11,-8,1,7,-3,5,5,-13,10,9,-3,6,-10,6,-3,7,-9,-13,9,10,0,-1,-11,4,-10,-8,-13,-15,2,-12,8,-2,-12,-14,-10,-8,6,2,-5,-7,-11,7,14,-6,-10,-12,8,-4,-10,-5,14,-3,9,-12,8,14,-13};
		System.out.println(threeSum(nums));
	}

}
