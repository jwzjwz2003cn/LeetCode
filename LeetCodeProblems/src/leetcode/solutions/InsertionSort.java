package leetcode.solutions;

public class InsertionSort {

	
	/**
	 * Worst case O(n^2) Best case O(n), Space complexity O(n)
	 * @param a
	 * @return
	 */
	public int[] insertionSort(int[] a)
	{
		for (int i = 1; i < a.length; i++) //start from index 1, so we have index 0 to compare with
		{
			int temp = a[i]; //make a back up
			int j;
			for (j = i ; j > 0 && temp < a[j-1]; j--) // compare with previous index
			{
				a[j] = a[j-1]; //shift larger number to the right
			}
			a[j] = temp; // retrieve the comparing the number from back up
		}
		return a;
	}
	
	public void displayArray(int[] a)
	{
		String s = "";
		for (int i = 0; i < a.length; i++)
		{
			s += Integer.toString(a[i]);
			s += " ";
		}
		System.out.println(s);
	}
	
	public void test()
	{
		int[] a = {2,3,14,0,3,1,4,6,7};
		int[] b = insertionSort(a);
		displayArray(b);
		
	}
}
