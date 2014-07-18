package leetcode.solutions;

public class ReverseInteger {

	/**
	 * - Convert to string 
	 * - string to character array
	 * - get the numerical value by reversing the array 
	 * @param x
	 * @return
	 */
	public int Reverse(int x)
	{
		int newInt = 0;
		int intLength;
		String strX = Integer.toString(x);
		char[] arrayX = strX.toCharArray();
		if (x < 0)
		{
			intLength = arrayX.length -1;
			System.arraycopy(strX.toCharArray(), 1, arrayX, 0, intLength);
		}
		else
			intLength = arrayX.length;
		for (int i = 0; i<intLength; i++)
		{
			newInt = newInt + Character.getNumericValue(arrayX[intLength-i-1]) * (int)Math.pow(10, intLength-i-1);
		}
		if (x < 0)
			newInt = newInt * -1;
		return newInt;
	}
	
	public void Test()
	{
		int a = 1001;
		System.out.println(Reverse(a));
	}
}
