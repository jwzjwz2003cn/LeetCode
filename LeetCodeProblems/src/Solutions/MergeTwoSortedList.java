package Solutions;
import Common.ListNode;
import Common.Utility;
public class MergeTwoSortedList implements ISolution {

	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		
		ListNode head = (l1.val <= l2.val) ? l1: l2;

		ListNode node2 = (head == l1)? l2: l1;
		head.next = mergeTwoLists(head.next, node2);
		return head;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,7,9};
		int[] b = {2,4,6,8,10};
		ListNode l1 = Utility.createList(a, 10);
		ListNode l2 = Utility.createList(b, 10);
		ListNode head = mergeTwoLists(l1, l2);
		Utility.printList(head);
	}

}
