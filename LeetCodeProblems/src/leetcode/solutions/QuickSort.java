package leetcode.solutions;

public class QuickSort implements ISolution {
	
	/**
	 * 
	 * @param A
	 * @param start
	 * @param end
	 */
	public void quickSort(int[] A, int start, int end){
		if (start < end){
			int pIndex = partion(A, start, end);
			quickSort(A, start, pIndex-1);
			quickSort(A, pIndex+1, end);
		}
		else
			return;
		
	}
	
	/**
	 * 1. choose last element of array as pivot
	 * 2. assign pIndex to the start of the array
	 * 3. for each A[i] -> i = start: end
	 * 		if (A[i] < pivot)
	 * 			swap (A[i], A[pIndex])
	 * 			pIndex ++;
	 * 	4. finally swap A[end] and A[pIndex]
	 * @param A
	 * @param start
	 * @param end
	 * @return
	 */

	public int partion(int[] A, int start, int end){
		int pivot = A[end];
		int pIndex = start;
		for (int i = start; i < end; i++){
			if (A[i] <= pivot){
				swap(i, pIndex, A);
				pIndex += 1;
			}
		}
		swap(end, pIndex, A);
		return pIndex;
	}
	
	public void swap (int i, int j, int[] A){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {2,6,3,1,5};
		quickSort(A, 0, A.length-1);
		for (int i = 0; i < A.length; i++){
			System.out.println(A[i]);
		}
	}

}
