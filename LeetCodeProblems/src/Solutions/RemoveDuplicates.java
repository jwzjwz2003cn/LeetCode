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
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [] A = {1,2};
		System.out.println(removeDuplicates(A));
	}

}
