package Solutions;
import java.util.*;

public class PascalTriangle implements ISolution {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numRows; i++){
			ArrayList<Integer> rowList = new ArrayList<Integer>();
			rowList.add(1);
			if (i>1)
			{
				for (int j = 1; j < i; j++)
				{
					ArrayList<Integer> lastRow = retList.get(i-1);
					int val = lastRow.get(j-1)+lastRow.get(j);
					rowList.add(val);
				}
			}
			if (i>0)
				rowList.add(1);
			retList.add(rowList);
		}
		return retList;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> a = generate(5);
		for (ArrayList<Integer> b: a)
		{
			System.out.println(b);
		}
		
	}

}
