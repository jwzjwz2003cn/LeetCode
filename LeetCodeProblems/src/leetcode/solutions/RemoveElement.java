package leetcode.solutions;

public class RemoveElement implements ISolution {

	public int removeElement(int[] A, int elem){
		 
		int j = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != elem){
				A[j] = A[i];
				j+=1;
			}
				
		}
		return j;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] a = {3,3};
		System.out.println(removeElement(a, 3));
		
	}
	
	

}
