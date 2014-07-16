package leetcode.solutions;

public class PalindromeNumber implements ISolution {

	public boolean isPalindrome(int x){
		/**
		 * compare first digits and last digits
		 * Get the right divisor to acquire first digits first
		 */
		if (x < 0){
			return false;
		}
		int div = 1;
		while (x/div >= 10){
			div *= 10;			//find divisor to get the first digits is the key
		}
		while (x != 0){
			int left = x / div;
			int right = x % 10;     
			if (left != right)
				return false;
			x = (x % div) / 10;   // remove the leading digits and then the last digits
			div /= 100;
		}
		return true;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int p = 422324;
		System.out.println(isPalindrome(p));
	}

}
