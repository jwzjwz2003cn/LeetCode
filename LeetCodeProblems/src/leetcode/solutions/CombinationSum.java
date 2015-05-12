package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum implements ISolution {

	
	/*
	 * use back tracking
	 * 1. sort array
	 * 2. backtracking is needed
	 * 3. use a currentIndex pointer to point to the current index of the array
	 * 4. use the value point by the currentIndex pointer to look for solution use backtracking
	 * 5. 
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		
		Stack<Integer> solution = new Stack<Integer>();
		searchSum(0, candidates, target, retList, solution);
		return retList;
		
	}
	
	public void searchSum(int currentIndex, int[] candidates, int target,
			List<List<Integer>> retList, Stack<Integer> solution) {
		
		//break condition
		if (candidates[currentIndex] > target){
			return;
		}
		//a while loop to keep the search going until the pointer points to the end of the array
		while (currentIndex < candidates.length) {

			//add current number to the new solution
			solution.push(candidates[currentIndex]);
			target -= candidates[currentIndex];
			System.out.println("IN: currentIndex="+currentIndex + " target=" + target + " solution="+solution);
			if (target == 0) {
				retList.add(new ArrayList<Integer>(solution));
			} else {
				searchSum(currentIndex, candidates, target, retList, solution);
			}
			System.out.println("OUT: currentIndex="+currentIndex + " target=" + target + " solution="+solution);
			//backtracking, restore to the original solution
			solution.pop();
			target += candidates[currentIndex];
			//increase the currentIndex
			currentIndex++;

		}

	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		System.out.println(combinationSum(candidates, 7));
		
	}

}
