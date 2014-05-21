package Solutions;
import java.util.*;

public class TwoSum implements ISolution{
	public int[] twoSum(int[] numbers, int target){
		
		int[] twoNums = new int[2];
		int[] operands2 = new int[numbers.length];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++)
		{
			operands2[i] = target - numbers[i];
			hm.put(operands2[i], i+1);
		}
		for (int i = 0; i < numbers.length; i++)
		{
			if (hm.containsKey(numbers[i]) && hm.get(numbers[i]) != i+1)
			{
				if (hm.get(numbers[i]) < i+1)
				{
					twoNums[0] = hm.get(numbers[i]);
					twoNums[1] = i+1;					
				}
				else
				{
					twoNums[0] = i+1;
					twoNums[1] = hm.get(numbers[i]);
				}
				return twoNums;
			}
		}
		return twoNums;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int target = 11;
		int[] twoSum = twoSum(nums, target);
		String s = Integer.toString(twoSum[0]) + " " + Integer.toString(twoSum[1]);
		System.out.println(s);
	}
}
