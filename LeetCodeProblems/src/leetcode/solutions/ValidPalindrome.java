package leetcode.solutions;

public class ValidPalindrome implements ISolution {

	
	/**
	 * 1. Use two pointers pointing at the beginning and end of the string
	 * 2. Compare and increment/decrement the pointers, return false when there is an inequality
	 * 3. skip the non-alphanumerical character
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s){
		
		if (s == "")
			return true;
		
		char[] a = s.toCharArray();
		
		int i = 0;
		int j = a.length - 1;
		
		while (i <= j){
			if (Character.isLetterOrDigit(a[i]) && Character.isLetterOrDigit(a[j])){
				if (Character.toLowerCase(a[i]) != Character.toLowerCase(a[j]))
					return false;
				else{
					i++;
					j--;
				}
			}
			else if (!Character.isLetterOrDigit(a[i])){
				i++;
			}
			else if (!Character.isLetterOrDigit(a[j])){
				j--;
			}
		}
		return true;
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String test = "A man, a plan, a canal: Panama";
		String test2 = "race a car";
		System.out.println(isPalindrome(test));
		System.out.println(isPalindrome(test2));
	}

}
