package leetcode.solutions;

public class ContainerWithMostWater implements ISolution {
	
	/**
	 * left and right pointer traversing from two end of the array
	 * the area is min(ai, aj) * (j-i)
	 * move the smaller pointer
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	
    	int i = 0;
    	int j = height.length-1;
    	
    	int maxArea = 0;
    	
    	while (i!=j){
    		int area = Math.min(height[i], height[j]) * (j-i);
    		if (maxArea < area)
    			maxArea = area;
    		if (height[i] < height[j])
    			i++;
    		else
    			j--;
    	}
    	return maxArea;
        
    }
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] height = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(maxArea(height));
		
	}

}
