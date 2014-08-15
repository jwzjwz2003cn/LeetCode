package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

public class ReorderList implements ISolution {

	/**
	 * 1. find middle pointer
	 * 2. reverse the second half exclude middle pointer
	 * 3. merge two list
	 * @param head
	 */
	public void reorderList(ListNode head){
		
		/**
		 * find middle pointer
		 */
		if (head == null || head.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		/**
		 * reorder second half of the list
		 */
		
		ListNode head2 = null;
		ListNode list2 = slow.next;
		slow.next = null;
		while (list2 != null){
			ListNode temp = head2;
			head2 = list2;
			list2 = list2.next;
			head2.next = temp;
		}
		
		/**
		 * merge the two lists
		 */
		mergeTwoLists(head, head2);

	}
	
	public ListNode mergeTwoLists(ListNode head1, ListNode head2){
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode temp = head1.next;
		head1.next = head2;
		head2.next = mergeTwoLists(temp, head2.next);
		return head1;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,7};
		ListNode head = Utility.createList(A, 9);
		reorderList(head);
		Utility.printList(head);
	}

}
