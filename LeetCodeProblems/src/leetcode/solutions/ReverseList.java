package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

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
		
 		if (m == n || head == null || head.next == null )
			return head;
		
		int count = 0;
		ListNode preHead = new ListNode(Integer.MIN_VALUE);
		preHead.next = head;
		ListNode current = preHead;
		while (count < m-1){
			count+=1;
			current = current.next;
		}
			
		ListNode temp = current; //temp is m-1
		ListNode nodeM = current.next;
		current = current.next;  //move to node M
		
		ListNode head2 = null;
		
		while (count < n){
			count +=1;
			ListNode temp2 = head2;
			head2 = current;
			current = current.next;
			head2.next = temp2;
		}
		//head2 is now nodeN, current.next is now n+1
		temp.next = head2;
		nodeM.next = current;
		
		return preHead.next;
		
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {3,5};
		ListNode head = Utility.createList(A, 8);
		ListNode newHead = reverseBetween(head, 1, 2);
		Utility.printList(newHead);
		
	}

}
