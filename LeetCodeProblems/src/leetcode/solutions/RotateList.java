package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

public class RotateList implements ISolution {
	/**
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 * 
	 * - keep a reference of the original head
	 * - fast & slow pointer to find the new tail
	 * - reassign head and tail
	 * 
	 * special cases:
	 *  length < k
	 *  null head
	 *  k = 0;
	 */

    public ListNode rotateRight(ListNode head, int k) {
    	
    	if (head == null || k == 0)
    		return head;
    	
    	ListNode newHead = head;
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	int counter = 0;
    	while (fast != null){
    		fast = fast.next;
    		counter ++;
    	}
    	k = k % counter;
    	
    	fast = head;
    	//fast pointer
    	for (int i = 1; i <= k; i++){
    		
    		if (fast.next != null)
    			fast = fast.next;
    		else
    			fast = head;
    	}
    	
    	if (fast == slow)
    		return head;
    	
    	//slow pointer
    	while (fast.next != null){
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	newHead = slow.next;
    	slow.next = null;
    	fast.next = head;
    	return newHead;
    	
        
    }
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,3,4,5};
		ListNode head = Utility.createList(a, 50);
		ListNode newHead = rotateRight(head, 5);
		Utility.printList(newHead);
		
		
	}

}
