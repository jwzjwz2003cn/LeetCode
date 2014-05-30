package Solutions;

public class RomanToInteger implements ISolution {

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
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String testRoman = "MCMXCVI";
		System.out.println(romanToInt(testRoman));
	}

}
