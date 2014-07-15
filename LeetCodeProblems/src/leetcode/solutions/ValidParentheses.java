package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses implements ISolution {

	public boolean isValid(String s){
		
		/**
		 *  use an int array to store the flag for validness
		 *  + 1 for having left parentheses
		 *  -1 for having right parentheses
		 *  Return false if it ever goes to negative number
		 *  Check if the end result is 0
		 *  Use a stack to store the next closing parenthese
		 */
		char[] charArray = s.toCharArray();
		int [] intArray = new int[3];
		Deque<Integer> nextClosing = new ArrayDeque<Integer>();
		
		for (int i = 0; i<charArray.length; i++){
			switch(charArray[i]){
			case '(': 
				intArray[0]+=1;
				nextClosing.push(0);
				break;
			case ')':
				intArray[0]-=1;
				if(intArray[0]<0 || nextClosing.peek()!=0)
					return false;
				nextClosing.pop();
				break;
			case '[': 
				intArray[1]+=1;
				nextClosing.push(1);
				break;
			case ']':
				intArray[1]-=1;
				if(intArray[1]<0 || nextClosing.peek()!=1)
					return false;
				nextClosing.pop();
				break;
			case '{': 
				intArray[2]+=1;
				nextClosing.push(2);
				break;
			case '}':
				intArray[2]-=1;
				if(intArray[2]<0 || nextClosing.peek()!=2)
					return false;
				nextClosing.pop();
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i<intArray.length; i++){
			if(intArray[i]!=0)
				return false;
		}
		return true;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String s = "([)]";
		System.out.println(isValid(s));
	}

}
