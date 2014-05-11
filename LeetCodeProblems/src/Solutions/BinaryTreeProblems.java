package Solutions;
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
	
	public void Test()
	{

		TreeNode t1 = new TreeNode(23);
		TreeNode t2 = new TreeNode(12);
		TreeNode t3 = new TreeNode(24);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(25);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		
		ArrayList<Integer> aB = preorderTraversal(t1);
		System.out.println(aB);
		
	}
}
