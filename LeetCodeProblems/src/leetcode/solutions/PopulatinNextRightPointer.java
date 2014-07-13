package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.common.TreeLinkNode;

public class PopulatinNextRightPointer implements ISolution {

    public void connect(TreeLinkNode root) {
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
    
    
    //use BFS (level order traversal)
    /**
     * - Key thoughts and facts:
     * 		Use level order traversal
     * 		use ArrayQueue to store current level nodes and next level nodes
     * 		link the next when dequeue the stored node
     * 		
     * @param root
     */
    public void connect2 (TreeLinkNode root){
    	if (root == null){
    		return;
    	}
    	Queue<TreeLinkNode> currentLevel = new ArrayDeque<TreeLinkNode> ();
    	Queue<TreeLinkNode> nextLevel = new ArrayDeque<TreeLinkNode>();
    	
    	currentLevel.add(root);
    	TreeLinkNode currentNode;
    	while(!currentLevel.isEmpty()){
    		currentNode = currentLevel.remove();
    		if (currentNode.left != null){
    			nextLevel.add(currentNode.left);
    		}
    		if(currentNode.right != null){
    			nextLevel.add(currentNode.right);
    		}
    		currentNode.next = currentLevel.peek();
    		if (currentLevel.isEmpty()){
    			while (!nextLevel.isEmpty()){
    				currentLevel.add(nextLevel.remove());
    			}
    		}
    	}
    }
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		connect2(n1);
		System.out.println("Done");
	}

}
