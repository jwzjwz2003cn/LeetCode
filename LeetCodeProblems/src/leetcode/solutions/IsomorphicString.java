package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString implements ISolution {
	
	/**
	 * 1. traverse through s and add s[i] to dictionary' key and store t's char as value
	 * 2. if s[i] exists, check t[i] with the value, return false when there is a mismatch
	 * 3. return true at the end of the loop
	 * 
	 * special cases:
	 * 
	 * - two nulls
	 * - one null
	 * - length don't match
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isIsomorphic(String s, String t) {
        
    	if (s == null && t == null)
    		return true;
    	else if (s == null || t == null)
    		return false;
    	else if (s.length() != t.length())
    		return false;
    	else {
    		
    		char[] as = s.toCharArray();
    		char[] at = t.toCharArray();
    		
    		Map<Character, Character> mapS = new HashMap<Character, Character>();
    		Map<Character, Character> mapT = new HashMap<Character, Character>();
    		for (int i = 0; i < as.length; i++){
    			if (mapS.containsKey(as[i])){
    				if (mapS.get(as[i]) != at[i])
    					return false;
    					
    			} else {
    				mapS.put(as[i], at[i]);
    				if (mapT.containsKey(at[i])){
    					if (mapT.get(at[i]) != as[i])
    						return false;
    				} else{
    					mapT.put(at[i], as[i]);
    				}
    			}
    		}
    		return true;
    	}
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("ab", "aa"));
		
	}

}
