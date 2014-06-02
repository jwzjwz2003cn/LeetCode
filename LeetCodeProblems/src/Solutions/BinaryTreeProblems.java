package Solutions;
import Common.TreeLinkNode;
import Common.TreeNode;

import java.util.*;

public class BinaryTreeProblems {
	
	public int maxDepth(TreeNode root)
	{
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return (left > right)? left+1:right+1;
		
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;
		else
		{
			if (p == null || q == null)
				return false;
			boolean isSameValue = (p.val == q.val);
			boolean isSameLeft = isSameTree(p.left, q.left);
			boolean isSameRight = isSameTree(p.right, q.right);
			return isSameValue && isSameLeft && isSameRight;
		}

	}
	
	public int numTrees(int n)
	{
		if (n == 0)
			return 1;
		else
		{
			int result = 0;
			for (int i = 0; i < n; i++)
			{
				result += numTrees(i)*numTrees(n-1-i);
			}			
			return result;
		}

	}
	
	public ArrayList<Integer> preorderTraversal (TreeNode root)
	{
		ArrayList<Integer> allElements = new ArrayList<Integer>();
		if (root != null)
		{
			allElements.add(root.val);
			ArrayList<Integer> leftElements = preorderTraversal(root.left);
			ArrayList<Integer> rightElements = preorderTraversal(root.right);
			allElements.addAll(leftElements);
			allElements.addAll(rightElements);
		}
		return allElements;
		
	}
	
	public ArrayList<Integer> inorderTraversal (TreeNode root){
		ArrayList<Integer> allElements = new ArrayList<Integer>();
		if (root != null)
		{
			ArrayList<Integer> leftElements = inorderTraversal(root.left);
			allElements.addAll(leftElements);
			allElements.add(root.val);
			ArrayList<Integer> rightElements = inorderTraversal(root.right);
			allElements.addAll(rightElements);
		}
		return allElements;
	}
	
	public boolean isBalanced(TreeNode root){
		if (root == null)
			return true;
		if (Math.abs(maxDepth(root.left)-maxDepth(root.right))>1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public TreeNode sortedArrayToBST(int[] num){
		if (num.length == 0)
			return null;
		int midIndex = (num.length)/2;
		TreeNode root = new TreeNode(num[midIndex]);
		if (num.length > 1)
		{
		    root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, midIndex));
		    root.right = sortedArrayToBST(Arrays.copyOfRange(num, midIndex+1, num.length));		    
		}
		return root;
	}
	
	public void connect(TreeLinkNode root)
	{
		if (root == null)
			return;
		else
		{
			if (root.left != null && root.right != null)
			{
				root.left.next = root.right;
				if (root.next != null)
					root.right.next = root.next.left;
			}
			connect(root.left);
			connect(root.right);
		}
	}
	
	public void Test()
	{
		int[] num = {1,2};
		
		TreeNode root = sortedArrayToBST(num);
		ArrayList<Integer> al = preorderTraversal(root);
		for (Integer i: al)
		{
			System.out.println(i);
		}
	}
}
