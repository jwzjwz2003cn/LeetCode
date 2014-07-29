package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

public class InsertionSortList implements ISolution {

	/**
	 * use Pre pointer to keep track of the newHead -> Pre.next
	 * use a current pointer and a next pointer to keep track of the current.next
	 * use a test pointer to compare loop from Pre pointer to null(sorted list)
	 * always compare the test.next and current
	 * 
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode current = head;
		ListNode next = current.next;
		ListNode test;
		while (current != null){
			next = current.next;
			test = pre;
			while(test.next != null && current.val >= test.next.val){
				test = test.next;
			}
			ListNode temp = test.next;
			test.next = current;
			current.next = temp;
			current = next;
		}
		return pre.next;
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {0,2,3,1,5,6,4};
		ListNode head = Utility.createList(A, 8);
		ListNode newHead = insertionSortList(head);
		Utility.printList(newHead);
		
	}

}
