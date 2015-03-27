package leetcode.solutions;

public class CompareVersionNumber implements ISolution {

	
/**
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * 1.1 < 1.2 < 1.13 
 * 1.0 = 1
 * 1.1.0 = 1
 * 
 * compare first level revision before '.'
 * if unresolved, compare the second level revision after '.' and so on  
 * @param version1
 * @param version2
 * @return
 */
	
    public int compareVersion(String version1, String version2) {
     
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
    	
    	for (int i = 0; i < Math.min(v1.length, v2.length); i++){
    		int i1 = Integer.valueOf(v1[i]);
    		int i2 = Integer.valueOf(v2[i]);
    		if (i1 < i2)
    			return -1;
    		if (i1 > i2)
    			return 1;
    	}
    	
    	if (v1.length > v2.length && Integer.valueOf(v1[v2.length]) > 0)
    		return 1;
    	if (v1.length < v2.length && Integer.valueOf(v2[v1.length]) > 0)
    		return -1;
    	return 0;
    	
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.0", "1"));
		
	}

}
