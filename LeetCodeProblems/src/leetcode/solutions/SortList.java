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
		
		ListNode fast = head;
		ListNode slow = head;
	
		while(fast.next != null && fast.next.next != null){ //ensure fast would stop on last node, or the second last node
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode temp = slow;
		ListNode head2 = slow.next;
		temp.next  = null;
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(head2);
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
			ListNode newHead = h1.val < h2.val ? h1 : h2;
			if (newHead == h1)
				h1 = h1.next;
			else
				h2 = h2.next;
			ListNode currentNode = newHead;
			while(h1 != null && h2 != null){
				currentNode.next = h1.val < h2.val ? h1 : h2;
				currentNode = currentNode.next;
				if (currentNode == h1)
					h1 = h1.next;
				else
					h2 = h2.next;
			}
			if (h1 != null)
				currentNode.next = h1;
			if (h2 != null)
				currentNode.next = h2;
			return newHead;
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
		int[] A = {1,4,3,2,5};
		int [] B = {2,4,6,8,10};
		ListNode h1 = Utility.createList(A, 9);
		ListNode h2 = Utility.createList(B, 9);
		ListNode newHead = sortList(h1);
		Utility.printList(newHead);
	}

}
