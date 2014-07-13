package leetcode.solutions;

import leetcode.common.ListNode;
import leetcode.common.Utility;

public class RemoveFromEndOfList implements ISolution {

	public ListNode removeNthFromEnd(ListNode head, int n){
		/**
		 *  - Use two pointers, one start n steps before the second one
		 *  When leading pointer reaching the last node, assign the second.next to the leading pointer to skip the nth from end node
		 */
		if (n == 0 || head == null)
			return head;
		else
		{
			ListNode leadPointer = head;
			ListNode trailPointer = head;
			int count = 1;
			while(leadPointer.next != null){
				leadPointer = leadPointer.next;
				if (count <= n){
					count += 1;
				}else{
					trailPointer = trailPointer.next;
				}
			}
			if (trailPointer == head){
				return head.next;
			}
			trailPointer.next = trailPointer.next.next;
		}
		return head;

	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] numArray = {1,2};
		ListNode head = Utility.createList(numArray, 10);
		ListNode newHead = removeNthFromEnd(head, 1);
		Utility.printList(newHead);
		
	}

}
