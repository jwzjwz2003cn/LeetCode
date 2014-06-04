package Solutions;

public class MergeSortedArray implements ISolution {

	public void merge(int A[], int m, int B[], int n){
		if (n==0)
			return;
		while (m > 0 && n > 0){
			if (A[m-1]<B[n-1])
			{
				A[m+n-1] = B[n-1];
				n-=1;
			}
			else{
				A[m+n-1] = A[m-1];
				m-=1;
			}
		}
		if (m==0)
		{
			for (int i = 0; i<n; i++)
			{
				A[i] = B[i];
			}
			return;
		}
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int [] A = new int[1];
		int [] B = {1};
		merge(A, 0, B, 1);
		for (int i = 0; i < A.length; i++){
			System.out.println(A[i]);
		}
	}

}
