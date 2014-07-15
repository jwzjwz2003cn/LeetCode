package leetcode.solutions;
import java.util.*;
public class GrayCode implements ISolution {

	/**
	 * 
	 * @param n
	 * @return
	 * 
	 *  - Gary Code for n  {0xxx , 1xxx} xxx is the members of n-1
	 *  - 0xxx is the same value of xxx,
	 *  - 1xxx are 1<<(n-1)
	 */
	
	public List<Integer> grayCode(int n){
		
		
		List<List<Integer>>listHistory = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++)
		{
			List<Integer> tempList = new ArrayList<Integer>();
			List<Integer> zeroList = new ArrayList<Integer>();
			List<Integer> oneList = new ArrayList<Integer>();
			if (i == 0)
			{	
				tempList.add(0);
			}		
			else
			{
				zeroList = listHistory.get(i-1);
				for (int j = zeroList.size()-1; j>=0; j-- )
				{
					oneList.add(zeroList.get(j)+(1<<(i-1)));
				}
			}
			tempList.addAll(zeroList);
			tempList.addAll(oneList);
			listHistory.add(tempList);
		}
		
		return listHistory.get(n);
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int n = 0;
		List<Integer> result = grayCode(n);
		for (Integer i: result){
			System.out.println(i);
		}
		
	}

}
