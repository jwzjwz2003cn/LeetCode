package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters implements ISolution {
	
	/**
	 *  - use a map and a counter and a max
	 *  - if key exists, reset counter & map & update max, else add the key to the map
	 *  - 
	 * @param s
	 * @return
	 */
	
    public int lengthOfLongestSubstring(String s) {
    	
    	if (s == null || s.isEmpty())
    		return 0;
    	
    	char[] a = s.toCharArray();
    	int max = 0;
    	int counter = 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < a.length; i++ ){
    		counter ++;
    		if (!map.containsKey(a[i])){
    			map.put(a[i], i);
    		}
    		else {
    			counter = (i - map.get(a[i])) < counter ? (i - map.get(a[i])) : counter;
    			map.remove(a[i]);
    			map.put(a[i], i);
    		}
			max = max > counter ? max : counter;
    	}
    	return max;
        
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		String[] test = {"dvdf", "tmmzuxt", "i"};
		for (String s: test){
			System.out.println(lengthOfLongestSubstring(s));
		}

		
	}

}
