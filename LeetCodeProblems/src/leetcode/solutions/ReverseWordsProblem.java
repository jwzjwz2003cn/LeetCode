package leetcode.solutions;

public class ReverseWordsProblem {
	
	public String reverseWords (String s)
	{
		String[] words = s.trim().split("\\s+");
		String reversedString = "";
		for (int i = words.length-1; i >=0; i--)
		{
			reversedString = reversedString.concat(words[i].concat(" "));
		}
		return reversedString.trim();
	}
	
	public void testReverseWords()
	{
		String s = "Microsoft is Great";
		String result = reverseWords(s);
		System.out.println(result);
	}
}
