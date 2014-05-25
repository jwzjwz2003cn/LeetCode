package Solutions;

public class PrintSpiral implements ISolution {

	public void printChar(char c)
	{
		System.out.println(c);
	}
	
	public void printSpiral(char[][] msg)
	{
		if (msg.length == 0)
			return;
		for (int i = 0; i < msg.length; i++)
		{
			int j,k,m,n;
			for (j = i; j < msg[i].length-i; j++)
			{
				printChar(msg[i][j]);
			}
			for (k = i+1; k < msg.length-i; k++)
			{
				printChar(msg[k][j-1]);
			}
			for (m = j-2; m >= 0+i; m--)
			{
				printChar(msg[k-1][m]);
			}
			for (n = k-2; n > 0+i; n--)
			{
				printChar(msg[n][m+1]);
			}
		}
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		char[][] table = {{'H', 'A', 'V'}, {'D', 'A', 'E'}, {'E', 'Y', 'A'}, {'C','I','N'}};
		printSpiral(table);
	}

}
