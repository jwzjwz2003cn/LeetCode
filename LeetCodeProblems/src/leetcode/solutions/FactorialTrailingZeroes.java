package leetcode.solutions;

public class FactorialTrailingZeroes implements ISolution {

	
	/**
	 * if n = 0?
	 * logarithmic time complexity = recursion!
	 * n < 5: no trailing 0s
	 * 0 will be generated for 5, 10, 15, 20, 25....
	 * Additional 0s will be generated for 5^2, 5^3, 5^4
	 * 
	 * ...
	 * 
	 * @param n
	 * @return
	 */
    public int trailingZeroes(int n) {
        if (n < 5)
        	return 0;
        
        return (n/5 + trailingZeroes(n/5));
        
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(25));
		
	}

}
