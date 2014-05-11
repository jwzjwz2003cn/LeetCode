package Solutions;
import Common.ListNode;
public class LinkedList {
	public boolean hasCycle(ListNode head){
		if (head == null)
			return false;
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode!= null && fastNode.next != null)
		{
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if (fastNode == slowNode)
				return true;
		}
		return false;
	}
	
	public ListNode detectCycle(ListNode head)
	{
		if (head == null)
			return null;
		boolean isCycle = false;
		int cycleLength = 0;
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode != null && fastNode.next != null)
		{
			if(!isCycle)
			{
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}
			else
			{
				fastNode = fastNode.next;
				cycleLength += 1;
			}

			if (fastNode == slowNode)
			{
				if (!isCycle)
					isCycle = true;
				else
					break;
			}
		}
		if (fastNode == null || fastNode.next == null)
			return null;
		else
		{
			fastNode = head;
			slowNode = head;
			for (int i = 0; i < cycleLength; i++)
			{
				fastNode = fastNode.next;
			}
			while(fastNode != slowNode)
			{
				slowNode = slowNode.next;
				fastNode = fastNode.next;
			}
			return fastNode;
		}
	}
	
	public ListNode createList(int[] intArray, int linkIndex)
	{
		ListNode head = new ListNode(intArray[0]);
		ListNode previousNode = head;
		ListNode linkedBackNode = null;
		for (int i = 1; i < intArray.length; i++)
		{
			ListNode node = new ListNode(intArray[i]);
			if (linkIndex == i)
				linkedBackNode = node;
			previousNode.next = node;
			previousNode = node;
		}
		previousNode.next = linkedBackNode;

		return head;
	}
	
	public void test()
	{
		int[] intArray = {0,1,2,3,4};
		ListNode head = createList(intArray, 2);
		ListNode cycleHead = detectCycle(head);
		System.out.println(cycleHead.val);
	}
	

}
