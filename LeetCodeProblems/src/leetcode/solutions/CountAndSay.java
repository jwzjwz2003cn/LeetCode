package leetcode.solutions;

public class CountAndSay implements ISolution {
	
    public String countAndSay(int n) {

    	if (n <= 0)
    		return null;
    	
    	String[] retString = new String[n];
    	for (int i = 0; i < n; i++){
    		if (i < 1)
    			retString[i] = "1";
    		else{
    			char[] prevArray = retString[i-1].toCharArray();
    			StringBuffer buffer = new StringBuffer();
    			char current = prevArray[0];
    			int count = 0;
    			for (int j = 0; j < prevArray.length; j++){
    				if (prevArray[j] == current){
    					count ++;  					
    				}
    				else{
    					buffer.append(count);
    					buffer.append(current);
    					current = prevArray[j];
    					count = 1;
    				}
    			}
    			retString[i] = buffer.toString();
    		}
    	}
    	return retString[n-1];
    	
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
}
