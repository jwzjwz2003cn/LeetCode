package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack implements ISolution {
	
	int min = Integer.MAX_VALUE;
	Deque<Integer> stack = new ArrayDeque<Integer> ();
	Deque<Integer> minStack = new ArrayDeque<Integer> ();
	public void push (int x){
		stack.push(x);
		if (x <= min){
			min = x;
			minStack.push(min);
		}

	}
	
	public void pop() {
		int x = stack.pop();
		if (x == minStack.peek()){
			minStack.pop();
			if (!minStack.isEmpty())
				min = minStack.peek();
			else
				min = Integer.MAX_VALUE;
		}

	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin(){
		return min;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		push(2147483646);
		push(2147483646);
		push(2147483647);
		System.out.println(top());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		push(2147483647);
		System.out.println(top());
		System.out.println(getMin());
		push(-2147483648);
		System.out.println(top());
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		
	}

}
