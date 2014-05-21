package Solutions;

public class ClimbingStairs {

	public int climbStairs(int n) {
		
		if (n == 0 || n == 1 || n == 2)
		{
			return n;
		}
		else if (n < 0)
		{
			return 0;
		}
		int[] results = new int[n];
		results[0] = 1;
		results[1] = 2;
		for (int i = 2; i < n; i++)
		{
			results[i] = results[i-1]+results[i-2];
		}
		return results[n-1];
	}
	
	public void test(){
		
		int n = 44;
		System.out.println(climbStairs(n));
	}
}
