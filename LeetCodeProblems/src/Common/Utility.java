package Common;

public class Utility {

	public static void printList(ListNode head)
	{
		String s = "";
		ListNode node = head;
		while (node != null)
		{
			s = s.concat(Integer.toString(node.val));
			s = s.concat(" ");
			node = node.next;
		}
		System.out.println(s);
	}
	
	public static ListNode createList(int[] intArray, int linkIndex)
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

}
