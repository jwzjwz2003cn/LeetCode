package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import leetcode.common.TreeNode;

public class BinaryTreeRightSideView implements ISolution {
	
	
	/**
	 *  - level order traversal from right to left 
	 *  - add the first retrieval from the queue
	 *  - 
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root){
		
		List<Integer> retList = new ArrayList<Integer>();
		
		Queue<TreeNode> currentQueue = new ArrayDeque<TreeNode>();
		
		currentQueue.add(root);
		
		Queue<TreeNode> nextQueue = new ArrayDeque<TreeNode>();
		
		boolean firstInTheQueue = true;
		
		while(!currentQueue.isEmpty()){
			
			if (firstInTheQueue){
				retList.add(currentQueue.peek().val);
				firstInTheQueue = false;
			}
			TreeNode currentNode =  currentQueue.remove();
			if (currentNode.right != null)
				nextQueue.add(currentNode.right);
			if (currentNode.left != null)
				nextQueue.add(currentNode.left);
			
			
			if (currentQueue.isEmpty()){
				while(!nextQueue.isEmpty()){
					currentQueue.add(nextQueue.remove());
				}
				firstInTheQueue = true;
			}
		}
		
		return retList;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.right = node5;
		node3.right = node4;
		
		System.out.println(rightSideView(node1));
		
		
	}

}
