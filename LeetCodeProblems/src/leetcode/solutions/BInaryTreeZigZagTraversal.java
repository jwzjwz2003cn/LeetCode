package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.common.TreeNode;

public class BInaryTreeZigZagTraversal implements ISolution {
	
	/**
	 * - need a direction boolean value (true = left, false = right)
	 * - current level queue and next level stack
	 * - start by adding root to the current and its child the the next
	 * - Pop all elements from the current (depends on the direction boolean)
	 * - add the children to next level depends on the direction (add left then right || add right then left) 
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
    	
    	Deque<TreeNode> currentLevel = new ArrayDeque<TreeNode>(); //queue
    	Deque<TreeNode> nextLevel = new ArrayDeque<TreeNode>(); //statck
    	boolean isGoingLeft = false;
    	List<Integer> currentList = new ArrayList<Integer>();
    	currentLevel.add(root);
    	
    	while(!currentLevel.isEmpty()){
    		
    		
    		TreeNode current = null;
    		current = currentLevel.remove();
    		
    		if (current != null){
    			currentList.add(current.val);
    			if (!isGoingLeft){
        			if (current.left!= null)
        				nextLevel.push(current.left);
        			if (current.right != null)
        				nextLevel.push(current.right);
    			} else {
        			if (current.right!= null)
        				nextLevel.push(current.right);
        			if (current.left != null)
        				nextLevel.push(current.left);
    			}

    		}

			
			if (currentLevel.isEmpty()){
				retList.add(currentList);
				while(!nextLevel.isEmpty()){
					currentLevel.add(nextLevel.pop());
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
		left.right = rightRight;
		
		List<List<Integer>> list = zigzagLevelOrder(root);
		System.out.println(list);
	}

}
