package leetcode.solutions;

import leetcode.common.ListNode;

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
		ListNode list2 = slow.next;
		ListNode tail = slow.next;
		while (list2.next != null){
			ListNode temp = list2;
			list2 = list2.next;
			list2.next = temp;
		}
		tail.next = null;
		
		/**
		 * merge the two lists
		 */
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
