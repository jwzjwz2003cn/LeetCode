package Solutions;

public class RemoveDuplicates implements ISolution {

	public int removeDuplicates(int[] A){
		
		if (A.length < 2)
			return A.length;
		int j = 1;
		
		for (int i = 1; i < A.length; i++)
		{
			if (A[j-1] != A[i])
			{
				A[j] = A[i];
				j+=1;
			}
				
		}
		return j;	
	}
	
	public int removeDuplicates2(int[] A){
		
		if (A.length < 2)
			return A.length;
		int j = 2;
		
		for (int i = 2; i < A.length; i++)
		{
			if (A[j-2] != A[i])
			{
				A[j] = A[i];
				j+=1;
			}
				
		}
		return j;	
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [] A = {1,1,1,2,2,3};
		System.out.println(removeDuplicates2(A));
	}

}
