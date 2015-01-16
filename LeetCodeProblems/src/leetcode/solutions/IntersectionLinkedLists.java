package leetcode.solutions;

import leetcode.common.ListNode;

public class IntersectionLinkedLists implements ISolution {

	/**
	 * 
	 * loop through list A
	 * save the tailA
	 * loop through list B
	 * compare tail A and tail B
	 * find the difference between A and B
	 * move the difference first and then move the 2 list to find the intersection
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	
    	if (headA == null || headB == null)
    		return null;
    	
    	ListNode tailA;
    	ListNode current = headA;
    	int countA = 0, countB = 0;
    	while (current.next != null)
    	{
    		countA++;
    		current = current.next;
    	}
    	tailA = current;
    	
    	current = headB;
    	while(current.next != null)
    	{
    		countB ++;
    		current = current.next;
    	}
    	if (current != tailA){
    		return null;
    	}
    	
    	int diff = 0;
    	diff = countA > countB ? countA - countB : countB - countA;
    	
    	ListNode lead;
    	ListNode trail;
    	if (countA > countB){
    		lead = headA;
    		trail = headB;
    		
    	} else {
    		lead = headB;
    		trail = headA;
    	}
    	while (diff > 0){
    		lead = lead.next;
    		diff--;
    	}
    	while (lead != trail){
    		lead = lead.next;
    		trail = trail.next;
    	}
    	return lead;
    	
        
    }
    
	@Override
	public void test() {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(2);
		ListNode b3 = new ListNode(2);
		ListNode c1 = new ListNode(4);
		ListNode c2 = new ListNode(3);
		ListNode c3 = new ListNode(3);
		a1.next = a2;
		a2.next = c1;
		c1.next = c2;
		c2.next = c3;
		b1.next = b2;
		b2.next = b3;
		b3.next = c1;
		ListNode t = getIntersectionNode(a1, b1);
		System.out.println(t.val);
	}

}
