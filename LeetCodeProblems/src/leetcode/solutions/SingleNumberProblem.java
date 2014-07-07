package leetcode.solutions;

public class SingleNumberProblem {

    public int singleNumber(int[] A) {
        
    	int result = A[0];
    	for (int i = 1; i<A.length; i++)
    	{
    		result = result ^ A[i];
    	}
    	return result;
    }
    
    public void test()
    {
    	int[] A = {2,3,4,5,5,4,3};
    	int a = singleNumber(A);
    	System.out.println(a);
    }
}
