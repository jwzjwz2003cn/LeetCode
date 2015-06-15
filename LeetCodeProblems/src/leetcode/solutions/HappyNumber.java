package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber implements ISolution {

	
	/**
	 * doing it recursively
	 * use a map to detect a loop
	 * break condition when sum of digits equal to 1 or a loop is detected
	 * @param n
	 * @return
	 */
    public boolean isHappy(int n) {
        
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	return isHappyWithMap(map, n);
    	
    }
    
    private boolean isHappyWithMap(Map<Integer, Integer> map, int n){
    	
    	int currentDigit = 0;
    	int sum = 0;
    	while (n != 0){
    		currentDigit = n % 10;
    		n = n / 10;
    		sum += (currentDigit * currentDigit);
    	}
    	if (sum == 1){
    		return true;
    	}
    	if (map.containsKey(sum))
    		return false;
    	map.put(sum, sum);
    	return isHappyWithMap(map, sum);
    	
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int n = 19;
		System.out.println(isHappy(2));
		
	} 
}
