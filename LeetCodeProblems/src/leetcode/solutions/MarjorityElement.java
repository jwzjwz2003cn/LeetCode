package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class MarjorityElement implements ISolution {

	/**
	 * element appears more than [n/2]
	 * Assume Array is non-empty and majority element always exists
	 * 
	 * - store number and occurrences into Dictionary
	 * - update and check if occurrences are marjority
	 * 
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int majority = num[0];
		for (int i = 0; i < num.length; i++)
		{
			if (!map.containsKey(num[i])){
				map.put(num[i], 1);
			}else {
				map.put(num[i], map.get(num[i])+1);
				if (map.get(num[i]) > num.length/2)
					majority = num[i];
			}
		}
		return majority;
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] num = {1,2,2,2,3,3,3,3,3};
		System.out.println(majorityElement(num));
	}

}
