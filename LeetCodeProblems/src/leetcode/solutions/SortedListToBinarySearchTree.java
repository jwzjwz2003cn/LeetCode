package leetcode.solutions;

import java.util.List;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;
import leetcode.common.Utility;

public class SortedListToBinarySearchTree implements ISolution {
	
	public TreeNode sortedListToBST(ListNode head){
		
		if (head == null)
			return null;
		int length = 0;
		ListNode current = head;
		while (current != null){
			length += 1;
			current = current.next;
		}
		return sortList(head, 0, length-1);
		
	}
	
	public TreeNode sortList(ListNode head, int start, int end){
		
		if (start > end)
			return null;
		
		int mid = start + (end - start)/2;
		
		TreeNode left = sortList(head, start, mid-1);
		TreeNode parent = new TreeNode(head.val);
		parent.left = left;
		if (head.next != null){
			head.val = head.next.val;
			head.next = head.next.next;
		}
		TreeNode right = sortList(head, mid+1, end);
		parent.right = right;
		return parent;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] A = {-1,0,1,2};
		ListNode head = Utility.createList(A, 9);
		TreeNode root = sortedListToBST(head);
		BinaryTreeProblems btp = new BinaryTreeProblems();
		List<List<Integer>> list = btp.levelOrder(root);
		for (List l: list){
			System.out.println(l);
		}
	}

}
