package leetcode.solutions;
import java.util.*;

public class RomanToInteger implements ISolution {

    private static LinkedHashMap<Integer, String> IntegerToRomanHash = new LinkedHashMap<Integer, String>();
	static {
		IntegerToRomanHash.put(1000, "M");
		IntegerToRomanHash.put(900, "CM");
		IntegerToRomanHash.put(500, "D");
		IntegerToRomanHash.put(400, "CD");
		IntegerToRomanHash.put(100, "C");
		IntegerToRomanHash.put(90, "XC");
		IntegerToRomanHash.put(50, "L");
		IntegerToRomanHash.put(40, "XL");
		IntegerToRomanHash.put(10, "X");
		IntegerToRomanHash.put(9, "IX");
		IntegerToRomanHash.put(5, "V");
		IntegerToRomanHash.put(4, "IV");
		IntegerToRomanHash.put(1, "I");
	}    
	
	public int romanToInt(String s)
	{
		char[] romanArray = s.toCharArray();
		int retVal = 0;
		int lastDigit = 0;
		for (int i = 0; i < romanArray.length; i++)
		{
			int digitVal = 0;
			switch (romanArray[i]){
				case 'I': digitVal += 1; break;
				case 'V': digitVal += 5; break;
				case 'X': digitVal += 10; break;
				case 'L': digitVal += 50; break;
				case 'C': digitVal += 100; break;
				case 'D': digitVal += 500; break;
				case 'M': digitVal += 1000; break;
			}
			if (lastDigit !=0 && lastDigit < digitVal)
				retVal = retVal - lastDigit;
			else
				retVal += lastDigit;
			lastDigit = digitVal;
		}
		retVal += lastDigit;
		return retVal;
	}
	
    public String intToRoman(int num) {
		String retVal = "";
		for (Integer i: IntegerToRomanHash.keySet())
		{
			if (num >= i){
				retVal = IntegerToRomanHash.get(i) + intToRoman(num-i);
				return retVal;
			}
		}
		return retVal;   
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String testRoman = "MCMXCVI";
		System.out.println(romanToInt(testRoman));
	}

}
