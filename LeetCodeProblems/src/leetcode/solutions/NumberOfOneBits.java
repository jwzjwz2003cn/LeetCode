package leetcode.solutions;

public class NumberOfOneBits implements ISolution {

	public int hammingWeight(int n){
		
		int count = 0;
		
		while (n != 0) {
			if ((n&1)==1)
				count ++;
			n >>>= 1;
		}
		return count;
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		System.out.println(hammingWeight(11));
	}
}
