package leetcode.solutions;
import java.util.*;

public class Subset implements ISolution {

	public List<List<Integer>> subsets(int[] S){
		/**
		 *  build it recursively
		 *  for every extra member in S, added to each member of the previous list +
		 *  	all members from the previous list
		 *  
		 */  
		Arrays.sort(S);
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
			if (S.length == 0){
				retList.add(new ArrayList<Integer>());
				return retList;
			}
			else{
				for (int i = 1; i <= S.length; i++){
					retList = new ArrayList<List<Integer>>();
					int[] newArray = Arrays.copyOf(S, i-1);
					List<List<Integer>> prevList = subsets(newArray);
					retList.addAll(prevList);
					for(List<Integer> list: prevList){
						List<Integer> newList = new ArrayList<Integer>(list);
						newList.add(S[i-1]);
						retList.add(newList);
					}
				}
			}
			
			return retList;
		}
		
		
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] S = {};
		List<List<Integer>> result = subsets(S);
		for (List<Integer> list: result){
			System.out.println(list);
		}
		
	}

}
