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
			for (j = 0; j < msg[i].length-i; j++)
			{
				printChar(msg[i][j]);
			}
			for (k = i+1; k < msg.length-i; k++)
			{
				printChar(msg[k][j]);
			}
			for (m = j-1; m >=0+i; m--)
			{
				printChar(msg[k][m]);
			}
			for (n = k-1; n >= 0+i; n--)
			{
				printChar(msg[n][m]);
			}
		}
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		char[][] table = {{'H', 'A', 'V'}, {'E', 'A', 'N'}, {'I', 'C', 'E'}, {'D','A','Y'}};
		printSpiral(table);
	}

}
