package leetcode.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestNumber implements ISolution {

	/**
	 * 
	 *   Use PriorityQueue and Comparator
	 * 		- comparator to compare the two string that can concat into larger string lexicographically
	 * 		- Add String to the priorityQueue
	 * 		- Convert PriorityQueue to String using StringBuilder
	 * 	  Edge cases: num.length = 0 and num.length = 1
	 *
	 * @param num
	 * @return
	 */
	
	/**
	 * 0 when o1o2 == o2o1
	 * < 0 when o1o2 < o2o1
	 * > 0 when o1o2 > o2o1
	 * @author Frank
	 *
	 */
	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.equals(o2))
				return 0;
			
			return -(o1 + o2).compareTo(o2 + o1) ;
		}
		
	}
	
    public String largestNumber(int[] num) {
    	
    	if (num.length == 0)
    		return "";
    	
    	Queue<String> pQue = new PriorityQueue<String> (num.length, new StringComparator());
    	
    	for (int i = 0; i < num.length; i++){
    		pQue.add(String.valueOf(num[i]));
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	while(!pQue.isEmpty()){
    		String s = pQue.poll();
    		if (!(sb.toString().equals("0") && s.equals("0")))
    			sb.append(s);
    	}

    	return sb.toString();
        
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] num = {0,0};
		System.out.println(largestNumber(num));
	}

}
