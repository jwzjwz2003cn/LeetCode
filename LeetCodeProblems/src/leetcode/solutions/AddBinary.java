package leetcode.solutions;

public class AddBinary implements ISolution {

	/**
	 * 
	 * 1. Convert string a and b to char arrays
	 * 2. iterate a and b in reverse order
	 * 3. a[i] + b[i]
	 * @return
	 */
	public String addBinary(String a, String b){
		
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		int i = A.length - 1;
		int j = B.length - 1;
		String result = "";
		boolean carryOver = false;
		while (i >= 0 && j >= 0){
			if ( A[i] == '1' && B[i] == '1'){
				if (carryOver)
					result = "1" + result;
				else
					result = "0" + result;
				carryOver = true;
			}
			else if (A[i] == '0' && B[i] == 0){
				if (carryOver)
					result = "1" + result;
				else
					result = "0" + result;
				carryOver = false;
			}
			else{
				if (carryOver){
					result = "0" + result;
					carryOver = true;
				}else{
					result = "1" + result;
					carryOver = false;
				}
			}
			
		}
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
