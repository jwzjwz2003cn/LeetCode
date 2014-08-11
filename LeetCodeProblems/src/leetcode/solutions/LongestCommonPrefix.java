package leetcode.solutions;

import java.util.Arrays;

public class LongestCommonPrefix implements ISolution {

	/**
	 * convert each string to char array
	 * initial common prefix is the first word
	 * compare char to char and update the common prefix for each string
	 * 
	 * @param strs
	 * @return
	 */
    public String longestCommonPrefix(String[] strs) {
    	
    	if (strs.length == 0)
    		return "";
    	char[] lcp = strs[0].toCharArray();
    	for (int i = 1; i < strs.length; i++){
    		char[] current = strs[i].toCharArray();
    		int count = 0;
    		for ( count = 0; count < lcp.length; count++){
    			if (count == current.length || lcp[count] != current[count])
    				break;
    		}
    		lcp = Arrays.copyOf(lcp, count);
    	}
    	return new String(lcp);
        
    }
    
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String[] strs = {"aa", "a"};
		System.out.println(longestCommonPrefix(strs));
	}

}
