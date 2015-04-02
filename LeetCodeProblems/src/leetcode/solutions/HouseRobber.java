package leetcode.solutions;

import java.util.Arrays;

public class HouseRobber implements ISolution {
	
	//5 9 4 9 2 1 4 6 6
	//    9 18 
	/**
	 * - DP
	 * - i, max(i-1), max(i-2)
	 * - max(i-1, i+i-2)
	 * @param num
	 * @return
	 */
    public int rob(int[] num) {
    	
    	if (num.length == 0)
    		return 0;
    	
    	if (num.length == 1)
    		return num[0];
    	
    	if (num.length == 2)
    		return Math.max(num[0], num[1]);
    	
    	int[] numMax = new int[num.length];
    	numMax[0] = num[0];
    	numMax[1] = Math.max(num[0], num[1]);
    	for (int i = 2; i < num.length; i++){
    		int c = num[i];
    		int c1 = numMax[i-1];
    		int c2 = numMax[i-2];
    		numMax[i] = Math.max(c1, c + c2);
    	}
    	return numMax[num.length - 1];
    	
        
    }
    
    


	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] num = {2,1,1,2};
		System.out.println(rob(num));
	}
}
