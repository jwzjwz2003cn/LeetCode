package leetcode.solutions;

public class Pow implements ISolution {

	public double pow(double x, int n){
		
		/**
		 * initial condition n = 0 and n = 1
		 * x^n = x^(n/2) * x^(n/2) * x^(n%2)
		 */
		if (n == 0){
			return 1;
		}
		if (n == 1){
			return x;
			
		}
		if (n == -1){
			return 1/x;
		}
		
		double temp = pow(x, n/2);
		return (temp * temp * pow(x, n%2)); //
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(pow(2, -3));
	}
}
