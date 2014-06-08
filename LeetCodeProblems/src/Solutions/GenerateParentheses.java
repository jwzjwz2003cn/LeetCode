package Solutions;
import java.util.*;

public class GenerateParentheses implements ISolution {

	public List<String> generateParenthesis(int n){
	
    	List<List<String>> pastLists = new ArrayList<List<String>>();
    	for (int i = 0; i <= n; i++){
    		List<String> list = new ArrayList<String>();
    		if ( i <= 0 ){
    			list.add("");
    		}
    		else{
    			int k = i-1;
    			while (k >= 0){
    				List<String> previous = pastLists.get(k);
    				List<String> previous2 = pastLists.get(i-k-1);
    				for(String s1: previous){
    					for(String s2: previous2){
    						String s = "(".concat(s1).concat(")").concat(s2);
    						list.add(s);
    					}
    				}
    				k-=1;
    			}
    		}
			pastLists.add(list);		
    	}
    	return pastLists.get(n);
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
