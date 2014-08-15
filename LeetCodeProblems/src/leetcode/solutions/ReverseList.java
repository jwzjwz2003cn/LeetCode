package leetcode.solutions;

import leetcode.common.ListNode;

public class ReverseList implements ISolution {
	
	/**
	 * traverse to the m-1 node, save in a temp node
	 * reverse nodes from m to n, save node n (now head), node m (now tail) and original n+1 node
	 * connect temp to node n , and node m to n+1
	 * 
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */

	public ListNode reverseBetween(ListNode head, int m, int n){
		
		if (m == n)
			return head;
		
		int count = 0;
		ListNode current = head;
		while (count < m){
			count+=1;
			current = current.next;
		}
			
		
	
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
