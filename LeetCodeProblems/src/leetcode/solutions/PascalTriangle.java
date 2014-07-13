package leetcode.solutions;
import java.util.*;

public class PascalTriangle implements ISolution {

	/**
	 * Pascal Triangle I
	 * Key thought & facts:
	 *  - number for members in each row goes from 1,2,3,4,5....
	 * 	- Store all the rows in a list
	 *  - For each member in current row at index j, j < number of members in the, it's the sum of last row's member j-1 and j
	 */
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
	
	
	/**
	 * @param rowIndex
	 * @return
	 * - Key thoughts and facts
	 * 		- use recursion
	 * 		- rowIndex = 1 is the base case and rowIndex = 2 is a special case
	 */
    public List<Integer> getRow(int rowIndex) {
    	
        List<Integer> rowList = new ArrayList<Integer>();
        rowList.add(1);
        if (rowIndex < 1){
        	return rowList;
        }
        if (rowIndex > 1){
            List<Integer> lastRow = getRow(rowIndex-1);
            for (int i = 1; i < rowIndex; i++){
            	rowList.add(lastRow.get(i-1)+lastRow.get(i));
            }        	
        }
        rowList.add(1);
        return rowList;
        
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		/*ArrayList<ArrayList<Integer>> a = generate(5);
		for (ArrayList<Integer> b: a)
		{
			System.out.println(b);
		}*/
		
		List<Integer> list = getRow(2);
		for (Integer i:list){
			System.out.println(i);
		}
		
	}

}
