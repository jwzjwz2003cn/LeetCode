package leetcode.solutions;

public class ReverseBits implements ISolution {

	
	//start with the lsb and work to the left
	//times the 2^31 to 2^0
	//add to the sum
	public int reverseBits(int n) {
		long sum = 0;
		
		for (int i = 0; i < 32; i++){
			
			int bit = n & 1;
			sum += (bit * Math.pow(2, 31-i));
			n >>>= 1;
		}
		String sumString = String.valueOf(sum);
		return Integer.parseUnsignedInt(sumString);
	}
	
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(1));
	}

}
