package leetcode.solutions;

public class LengthLastWord implements ISolution {

	public int lengthOfLastWord(String S){
		
		String[] stringArry = S.trim().split(" ");
		String lastWord = stringArry[stringArry.length-1];
		return lastWord.length();
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String s = "Hi this is Frank";
		System.out.println(lengthOfLastWord(s));
	}

}
