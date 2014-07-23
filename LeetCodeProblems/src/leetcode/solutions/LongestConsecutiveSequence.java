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
	 *  
	 */
	public int longestConsecutive(int[] num){
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i<num.length; i++){
			hash.put(num[i], i);
		}
		
		int max = 0;
		//find the 
		for (int i = 0; i<num.length; i++){
			int count = 1;
			int oneLess = num[i]-1;
			while (hash.containsKey(oneLess)){
				hash.remove(oneLess);
				oneLess--;
				count++;
			}
			
			int oneMore = num[i]+1;
			while(hash.containsKey(oneMore)){
				hash.remove(oneMore);
				oneMore++;
				count++;
			}
			max = Math.max(count, max);
		}
		return max;
	}
	
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] num = {0,1,3,4,5,2};
		System.out.println(longestConsecutive(num));
	}

}
