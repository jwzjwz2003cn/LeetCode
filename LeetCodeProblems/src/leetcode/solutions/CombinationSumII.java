package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  1. sort the array
 *  2. use backtracking
 *  3. use a boolean array to store the solution
 * @author Frank
 *
 */
public class CombinationSumII implements ISolution {
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	
    	List<List<Integer>> retList = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
        
    	boolean[] solutionMap = new boolean[candidates.length];
    	
    	Stack<Integer> solution = new Stack<Integer>();
    	searchSolution(0, candidates, target, solutionMap, retList, solution);
    	
    	return retList;
    }
    
    public void searchSolution(int index, int[]candidates, int target, boolean[] solutionMap, List<List<Integer>> retList, Stack<Integer> solution){
    	
    	System.out.println("index =" + index);
    	for (int i = index; i < solutionMap.length; i++){
    		if (!solutionMap[i]){
    			
    			if (i > index && candidates[i-1] == candidates[i])
    				continue;
    			
    			solutionMap[i] = true;
    			solution.push(candidates[i]);
    			target -= candidates[i];
    			if (target == 0) {
    				retList.add(new ArrayList<Integer> (solution));
    			} else if (target >= candidates[index]) {
    				searchSolution(i+1, candidates, target, solutionMap, retList, solution);
    			} 
 
    			solutionMap[i] = false;
    			solution.pop();
    			target += candidates[i];
    			
    		}
    	}
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] candidates = {2,2,2};
		System.out.println(combinationSum2(candidates, 4));
	}

}
