package Solutions;

public class InterLeavingString implements ISolution {

	
	public boolean isInterleave(String s1, String s2, String s3){
		
		boolean result = true;
		if(s3.length() != (s1.length() + s2.length()))
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		int i2 = 0, i1 = 0;
		for (int i3 = 0; i1 < c1.length && i2 < c2.length && i3 < c3.length; i3++)
		{
			int identicalChars = 1;
			if (c3[i3] == c1[i1] && c3[i1] == c2[i2] )
			{
				identicalChars +=1 ;
				continue;
			}
			else if (c3[i3] == c1[i1])
			{
				i1 += identicalChars;
			}
			else if (c3[i3] == c2[i2])
			{
				i2 += identicalChars;
			}
			else if (c3[i3]!=c1[i1] && c3[i3]!=c2[i2])
			{
				return false;
			}
		}
		return result;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		boolean result = isInterleave(s1, s2, s3);
		System.out.println(result);
	}

}
