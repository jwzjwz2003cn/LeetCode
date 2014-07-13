package leetcode.solutions;

import java.util.*;

public class Combinations implements ISolution {

	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 * 
	 * Key thoughts and facts:
	 * 		Use DFS, similar to permutation
	 * 		use boolean[] visited
	 * 		use List<Integer> singleList to keep track of the current list
	 * 		return when singleList grow to the size of k
	 */
	public List<List<Integer>> combine(int n, int k){
		
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		List<Integer> singleList = new ArrayList<Integer>();
		dfsSearch(k, n, 0, singleList, retList);
		return retList;
	}
	
	public void dfsSearch(int k, int n, int index, List<Integer> singleList, List<List<Integer>> retList){
		
		if (singleList.size() == k){
			List<Integer> finalList = new ArrayList<Integer>(singleList);
			retList.add(finalList);
			return;
		}
		
		for (int i = index; i < n; i++){
			singleList.add(i+1);
			dfsSearch(k, n, i+1, singleList, retList);				
			singleList.remove(new Integer(i+1));
			
		}
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int n = 5, k = 3;
		List<List<Integer>> retList = combine(n, k);
		for (List<Integer> l: retList){
			System.out.println(l);
		}
		
	}

}
