package ReverseWord;

public class ReverseWordSolution {

	public static String reverseWords(String s){
		
		String[] words = s.trim().split("\\s+");
		String reversedString = "";
		for (int i = words.length-1; i >=0; i--)
		{
			reversedString = reversedString.concat(words[i].concat(" "));
		}
		return reversedString.trim();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "Microsoft   is    great";
		String result = reverseWords(test1);
		System.out.println(result);

	}

}
