package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

public class SortList implements ISolution {

	/**
	 *  1. break the list into 2 (fast and slow node)
	 *  2. merge sort on h1 and h2 recursively
	 *  3. merge h1 and h2 (merge two sorted list)
	 *  
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head){
		
		//special cases
		if (head == null || head.next == null)
			return head;
		
		return sortListHelper(head, null);
	}
	
	public ListNode sortListHelper(ListNode head, ListNode tail){
		//break the list into 2
		if (head == tail || head.next == tail)
			return head;
		ListNode fast = head;
		ListNode slow = head;
	
		while(fast != tail && fast.next != tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode h1 = sortListHelper(head, slow);
		ListNode h2 = sortListHelper(slow, tail);
		ListNode newHead = mergeList(h1, h2);
		return newHead;		
	}
	
	/*  1. if any of h1 and h2 is null, return the non null pointer (base case)
	 *  2. set the smaller value as the return node (head)
	 *  3. solve the next recursively using the previous smaller.next and the previous bigger node
	 * 
	 */
	public ListNode mergeList(ListNode h1, ListNode h2){
		
		if (h1 != null && h2 != null){
			ListNode smaller = h1.val <= h2.val ? h1: h2;
			ListNode bigger = h1.val > h2.val ? h1: h2;
			smaller.next = mergeList(smaller.next, bigger);
			return smaller;
		}
		else if (h1 != null){
			return h1;
		}
		else if (h2 != null){
			return h2;
		}
		return null;
		
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {9,7,5,3,1};
		int [] B = {2,4,6,8,10};
		ListNode head1 = Utility.createList(A, 9);
		ListNode head2 = Utility.createList(B, 9);
		ListNode newHead = sortList(head1);
		Utility.printList(newHead);
	}

}
