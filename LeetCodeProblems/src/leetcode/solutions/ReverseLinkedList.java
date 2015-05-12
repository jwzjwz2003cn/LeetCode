package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

public class ReverseLinkedList implements ISolution {
	
	//iterative
	/**
	 * prev and current pointer
	 * add current pointer in front of prev
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head){
		
		if (head == null)
			return null;
		
		ListNode prev = head;
		ListNode current = head.next;
		
		//need to set the end of the list here
		prev.next = null;
		while (current != null){
			// important! save a copy of current.next
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
		
	}
	//recursive
    public ListNode reverseList(ListNode head) {
    	
    	//break condition
    	if (head == null)
    		return null;
    	if (head.next == null){
    		return head;
    	}
    	ListNode temp = head.next;
    	ListNode newHead = reverseList(head.next);
    	temp.next = head;
    	head.next = null;
    	return newHead;

        
    }
	

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		ListNode head = Utility.createList(a, 10);
		ListNode newHead = reverseList(head);
		Utility.printList(newHead);
		
	}

}
