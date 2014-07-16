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
		return Math.max(left+1, right+1);
		
	}
	
	public int minDepth(TreeNode root){
/**
 *  use level order traversal
 *  	For the first node in the queue has null left and null right, return the Depth
 */
		if (root == null){
			return 0;
		}
		int depth = 1;
		Queue<TreeNode> currentLvl = new ArrayDeque<TreeNode>();
		Queue<TreeNode> nextLvl = new ArrayDeque<TreeNode>();
		
		currentLvl.add(root);
		
		while(!currentLvl.isEmpty()){
			TreeNode currentNode = currentLvl.remove();
			if(currentNode.left == null && currentNode.right == null)
				break;
			if (currentNode.left != null){
				nextLvl.add(currentNode.left);
			}
			if (currentNode.right != null){
				nextLvl.add(currentNode.right);
			}
			if (currentLvl.isEmpty()){
				while(!nextLvl.isEmpty()){
					currentLvl.add(nextLvl.remove());
				}
				depth+=1;
			}
		}
		return depth;
	}
	
	/**
	 * 1. check if any of the 2 are null
	 * 2. check if they have the same value
	 * 3. check if they have same left and same right
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
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
        Queue<TreeNode> currentLevel = new ArrayDeque<TreeNode>(); 
        Queue<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
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
    
	public void test()
	{
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		
		n6.left = n5;
		n6.right = n3;
		
		n5.left = n2;
		n5.right = n1;
		
		System.out.println(minDepth(n6));
	}
}
