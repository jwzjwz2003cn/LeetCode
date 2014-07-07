package leetcode.solutions;

public class SortColors implements ISolution {

	public void sortColor(int[] A){
		int i = 0;
		int j= 0;
		int k = A.length-1;
		while (i < A.length){
			if (A[i] == 0 && j<=i){
				A[i] = A[j];
				A[j++]=0;
			}
			else if (A[i] == 2 && i <= k){
				A[i] = A[k];
				A[k--] = 2;
			}
			else{
				i+=1;
			}
		}
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {0,2,1};
		sortColor(A);
		for(int i = 0; i < A.length; i++){
			System.out.println(A[i]);
		}
	}	
}
