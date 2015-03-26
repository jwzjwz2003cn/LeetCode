package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.common.TreeNode;

public class BInaryTreeZigZagTraversal implements ISolution {
	
	/**
	 * - need a direction boolean value (true = left, false = right)
	 * - current level deque and next level deque
	 * - start by adding root to the current and its child the the next
	 * - Pop or remove all elements from the current (depends on the direction boolean)
	 * - add the children to next level (always add as a queue)
	 * - when current is empty, assign next to current
	 * - return when both current and next are empty
	 * 
	 * @param root
	 * @return
	 */
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        

    	//init
    	List<List<Integer>> retList = new ArrayList<List<Integer>>();
    	
    	if (root == null)
    		return retList;
    	
    	Deque<TreeNode> currentLevel = new ArrayDeque<TreeNode>();
    	Deque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
    	boolean isGoingLeft = false;
    	List<Integer> currentList = new ArrayList<Integer>();
    	currentLevel.addLast(root);
    	
    	while(!currentLevel.isEmpty()){
    		
    		
    		TreeNode current = null;
    		if(!isGoingLeft){
    			current = currentLevel.removeFirst();
    		} else {
    			current = currentLevel.removeLast();
    		}
    		
    		if (current != null){
    			currentList.add(current.val);
    			if (current.left!= null)
    				nextLevel.addLast(current.left);
    			if (current.right != null)
    				nextLevel.addLast(current.right);
    		}

			
			if (currentLevel.isEmpty()){
				retList.add(currentList);
				while(!nextLevel.isEmpty()){
					currentLevel.addLast(nextLevel.pop());
				}
				currentList = new ArrayList<Integer>();
				isGoingLeft = !isGoingLeft;
			}
    	}
    	
    	return retList;
    	
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode leftLeft = new TreeNode(4);
		TreeNode rightRight = new TreeNode(5);
		root.left = left;
		root.right = right;
		left.left = leftLeft;
		right.right = rightRight;
		
		List<List<Integer>> list = zigzagLevelOrder(root);
		System.out.println(list);
	}

}
