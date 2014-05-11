package eclipsePackage;

public class LinearSystem {
	
	/*
	 * matrix[0][0- = a
	 */
	public double[] Solve (double[][] A, double [] B)
	{
		double [] xy = new double[2];
		
		double a,b,c,d;
		a = A[0][0];
		b = A[0][1];
		c = A[1][0];
		d = A[1][1];
		
		double i, j;
		i = B[0];
		j = B[1];
		
		double Det = a*d-b*c;
		
		double DetX = i*d - j*b;
		double DetY = a*j - c*i;
		double x = DetX/Det;
		double y = DetY/Det;
		
		xy[0] = x;
		xy[1] = y;
		return xy;
	}
	
	public String Display(double[][] A, double [] B)
	{
		String result = String.format("|%f %f| |x| = |%f|\n|%f %f| |y|   |%f|", A[0][0], A[0][1], B[0], A[1][0], A[1][1], B[1]);
		return result;
	}

	public void Test()
	{
		double [][] A = {{3, 4}, {1, 2}};
		double [] B = {5,6};
		
		double [] xy = Solve(A, B);
		System.out.println(Display(A, B));
		System.out.println("The solution is x = "+xy[0]+" y = " + xy[1]);
	}
}
