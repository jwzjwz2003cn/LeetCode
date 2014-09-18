package leetcode.solutions;

public class CountAndSay implements ISolution {
	
	/**
	 * 1. do it iteratively
	 * 2. scan through each number in the previous iteration
	 * 3. count the occurrence of each number and append both the count and the number
	 * @param n
	 * @return
	 */
    public String countAndSay(int n) {

    	if (n <= 0)
    		return null;
    	
    	String[] retString = new String[n];
    	for (int i = 0; i < n; i++){
    		if (i < 1)
    			retString[i] = "1";
    		else{
    			String prev = retString[i-1];
    			char[] prevArray = prev.toCharArray();
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
    			buffer.trimToSize();
    			if (buffer.length() == 0 || buffer.charAt(buffer.length()-1) != current){
    				buffer.append(count);
    				buffer.append(current);
    			}
    			retString[i] = buffer.toString();
    		}
    	}
    	return retString[n-1];
    	
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
		
	}
}
