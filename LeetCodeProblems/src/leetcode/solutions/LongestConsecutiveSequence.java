package leetcode.solutions;

import java.util.HashMap;

public class LongestConsecutiveSequence implements ISolution {

	/**
	 * 
	 * @param num
	 * @return
	 * 
	 *  - Use a hashmap to map the number in the num and their index
	 *  - iterate through num to see if num-1 and num+1 are in the hash
	 *  - 
	 */
	public int longestConsecutive(int[] num){
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i<num.length; i++){
			hash.put(num[i], i);
		}
		
		for (int i = 0; i<num.length; i++){
		}
	}
	
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
