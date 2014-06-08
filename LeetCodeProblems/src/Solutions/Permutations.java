package Solutions;
import java.util.*;

public class Permutations implements ISolution {

	public ArrayList<ArrayList<Integer>> permute(int[] num){
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> singleList = new ArrayList<Integer>();
		boolean [] visited = new boolean[num.length];
		for (int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
		permuteDFS(num, visited, retList, singleList);
		return retList;
		
	}
	
	public void permuteDFS(int[] num, boolean [] visited, ArrayList<ArrayList<Integer>> retList, ArrayList<Integer> singleList){
		
		if (singleList.size() == num.length){
			ArrayList<Integer> finalSingleList = new ArrayList<Integer>(singleList);
			retList.add(finalSingleList);
			return;
		}
		
		for (int i = 0; i < num.length; i++){
			if (!visited[i]){
				visited[i] = true;
				singleList.add(num[i]);
				permuteDFS(num, visited, retList, singleList);
				
				visited[i] = false;
				singleList.remove(new Integer(num[i]));
			}
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		List<Integer> singleList = new ArrayList<Integer>();
		boolean [] visited = new boolean[num.length];
		Arrays.sort(num);
		for (int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
		permuteUniqueDFS(num, visited, retList, singleList);
		return retList;
	}
	
	public void permuteUniqueDFS(int[] num, boolean [] visited, List<List<Integer>> retList, List<Integer> singleList){
		
		if (singleList.size() == num.length){
			List<Integer> finalSingleList = new ArrayList<Integer>(singleList);
			retList.add(finalSingleList);
			return;
		}
		int lastVisited = num[0];
		
		for (int i = 0; i < num.length; i++){
			if (!visited[i]){
				if (i > 0 && num[i] == lastVisited){
					continue;
				}
				visited[i] = true;
				singleList.add(num[i]);
				permuteUniqueDFS(num, visited, retList, singleList);
				
				visited[i] = false;
				singleList.remove(new Integer(num[i]));
				lastVisited = num[i];
			}
		}
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int[] num = {1,1};
		List<List<Integer>> a = permuteUnique(num);
		for (List<Integer> al: a){
			System.out.println(al);
		}
		
	}

}
