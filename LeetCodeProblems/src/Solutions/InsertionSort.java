package Solutions;

public class InsertionSort {

	public int[] insertionSort(int[] a)
	{
		
		for (int i = 1; i < a.length; i++)
		{
			int temp = a[i];
			int j;
			for (j = i ; j > 0 && a[j-1] > temp; j--)
			{
				a[j] = a[j-1];
			}
			a[j] = temp;
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
