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
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		
		t7.left = t1;
		t7.right = t9;
		t1.left = t0;
		t1.right = t3;
		t9.left = t8;
		t9.right = t10;
		t3.left = t2;
		t3.right = t5;
		t5.left = t4;
		t5.right = t6;
		
		ArrayList<Integer> aB = inorderTraversal(t7);
		System.out.println(aB);
		
	}
}
