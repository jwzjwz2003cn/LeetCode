package leetcode.solutions;
import java.util.*;

import leetcode.common.TreeLinkNode;
import leetcode.common.TreeNode;

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
	
	public List<Integer> postorderTraversal(TreeNode root){
		
		List<Integer> allElements = new ArrayList<Integer>();
		if (root!= null){
			List<Integer> leftElements = postorderTraversal(root.left);
			allElements.addAll(leftElements);
			List<Integer> rightElements = postorderTraversal(root.right);
			allElements.addAll(rightElements);		
			allElements.add(root.val);
		}
		return allElements;
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
	
	public ArrayList<String> inorderTraversalString (TreeNode root){
		ArrayList<String> allElements = new ArrayList<String>();
		if (root != null)
		{
			if (!(root.left == null && root.right == null))
			{
				ArrayList<String> leftElements = inorderTraversalString(root.left);
				ArrayList<String> rightElements = inorderTraversalString(root.right);
				allElements.addAll(leftElements);
				allElements.add(Integer.toString(root.val));
				allElements.addAll(rightElements);				
			}
			else
				allElements.add(Integer.toString(root.val));

		}
		else
		{
			allElements.add("#");
		}
		return allElements;
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if (root == null)
        	return retList;
        Queue<TreeNode> currentLevel = new PriorityQueue<TreeNode>(); 
        Queue<TreeNode> nextLevel = new PriorityQueue<TreeNode>();
        currentLevel.add(root);
        TreeNode currentNode;
        List<Integer> levelList = new ArrayList<Integer>();
        while(!currentLevel.isEmpty()){
        	currentNode = currentLevel.remove();
        	if (currentNode.left != null)
        		nextLevel.add(currentNode.left);
        	if (currentNode.right != null)
        		nextLevel.add(currentNode.right);
        	levelList.add(currentNode.val);
        	if (currentLevel.isEmpty()){
                retList.add(levelList);
                levelList = new ArrayList<Integer>();
                while(!nextLevel.isEmpty()){
                	currentLevel.add(nextLevel.remove());
                }        		
        	}
        }

        return retList;
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
	
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
		ArrayList<String> nodesList = inorderTraversalString(root);
		boolean retVal = true;
		for (int i = 0; i < nodesList.size(); i++)
		{
			retVal = (nodesList.get(i).equals(nodesList.get(nodesList.size()-1-i)));
			if (!retVal)
				break;
		}
		return retVal;
	}        
	
    public boolean isSymmetricNew(TreeNode root){
    	if (root == null)
    		return true;
    	
    	return isSymmetricLR(root.left, root.right);
    }
    
    public boolean isSymmetricLR(TreeNode a, TreeNode b){
    	if (a == null && b == null)
    		return true;
    	if (a == null || b == null)
    		return false;
    	if (a.val != b.val)
    		return false;
    	return isSymmetricLR(a.left, b.right) && isSymmetricLR(a.right, b.left);
    }
    
	public void Test()
	{
		/*
		TreeNode t1 = new TreeNode(1);
		TreeNode t2l = new TreeNode(2);
		TreeNode t3r = new TreeNode(3);
		TreeNode t3l = new TreeNode(3);
		TreeNode t2r = new TreeNode(2);
		
		t1.left = t2l;
		t1.right = t3r;
		t2l.left = t3l;
		t3r.left = t2r;
		System.out.println(isSymmetric(t1));*/
		
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t1 = new TreeNode(1);
		
		t5.right = t4;
		t4.left = t1;
		
		List<List<Integer>> al = levelOrder(t5);
		
		for (List<Integer> i: al){
			System.out.println(i);
		}
	}
}
