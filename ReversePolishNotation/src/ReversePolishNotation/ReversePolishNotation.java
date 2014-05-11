package ReversePolishNotation;

public class ReversePolishNotation {

	public static int evalRPN (String[] tokens){

		if (tokens.length>=3)
		{
			String[] s1 = {tokens[0], tokens[1], tokens[2]};
			String op = tokens[2];
			int operand;
			if (op == "+" || op == "-")
			{
				if (op == "-")
					operand = Integer.parseInt(tokens[0])-Integer.parseInt(tokens[1]);
				operand = Integer.parseInt(tokens[0])+Integer.parseInt(tokens[1]);
			}
			else if (op == "*" || op == "/")
			{
				if (op =="/")
					operand = Integer.parseInt(tokens[0])/Integer.parseInt(tokens[1]);
				operand = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[1]);
			}
			else
			{
				throw new Error("Wrong Operand detected");
			}
			String operandString = new Integer(operand).toString();
			String [] newArray = new String[tokens.length-2];
			newArray[0] = operandString;
			if (tokens.length-2>1)
				System.arraycopy(tokens, 3, newArray, 1, tokens.length-3);
			return evalRPN(newArray);
		}
		else if (tokens.length == 1)
		{
		    return Integer.parseInt(tokens[0]);
		}
		else
		{
			throw new Error("something's wrong");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s1 = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(s1));
	}

}
