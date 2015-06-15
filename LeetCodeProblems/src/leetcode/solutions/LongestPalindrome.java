package leetcode.solutions;

public class LongestPalindrome implements ISolution {
	
	/**
	 * O(N^2) solution
	 *  - 2 centers: YxY & YxxY
	 *  - expand for each types of centers to find longest length
	 *  
	 *  special cases:
	 *  
	 *  s = null or empty;
	 * 
	 *  
	 * @param s
	 * @return
	 */
	
	private String expandPalindromeFromCenter(String s, int c1, int c2){
		while (c1 >= 0 && c2 < s.length() && s.charAt(c1) == s.charAt(c2)){
			c1--;
			c2++;
		}
		c1++;
		c2--;
		return s.substring(c1, c2+1);
	}
	
	public String longestPalindrome(String s){
		
		if (s == null || s.isEmpty())
			return s;
		
		int len = s.length();
		String max = String.valueOf(s.charAt(0));
		
		for (int i = 0; i < len; i++){
			String p1 = expandPalindromeFromCenter(s, i, i);
			if (p1.length() > max.length())
				max = p1;
			if (i > 0){
				String p2 = expandPalindromeFromCenter(s, i-1, i);
				if (p2.length() > max.length()){
					max = p2;
				}
			}
		}
		
		return max;
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		String s = "abb";
		System.out.println(longestPalindrome(s));
	}

}
