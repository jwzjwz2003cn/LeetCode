package Solutions;

public class SingleNumber2 implements ISolution {

	
	public int singleNumber(int[] A)
	{
		int[] sum = new int [32];
		int singleNumber = 0;
		
		for (int i = 0; i < 32; i++)
		{
			for (int j = 0; j < A.length; j++)
			{
				if ((A[j] >> i & 1) == 1)
				{
					sum[i] += 1;
				}
			}
			if (sum[i] %3 != 0)
			{
				singleNumber += (sum[i]%3 << i);
			}
		}
		
		return singleNumber;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int [] A = {1,1,1,2,3,3,3,4,4,4};
		System.out.println(singleNumber(A));
		
	}

}
