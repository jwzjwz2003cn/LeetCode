package Solutions;

public class MaximumSubarray implements ISolution {

	public int maxSubArray(int[] A)
	{
		int sum = 0, max = 0;
		
		for (int i = 0; i < A.length; i++)
		{
			sum = (sum > 0)? sum+A[i]: A[i];
			max = Math.max(max, sum);
		}
		return max;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] arry = {-2,1,-3,4,-1,2,1,-5,4};
		int sum = maxSubArray(arry);
		System.out.println(sum);
		
		
	}

}
