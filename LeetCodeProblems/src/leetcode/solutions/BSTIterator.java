package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import leetcode.common.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */


public class BSTIterator implements ISolution {

    Stack<TreeNode> stack =  null ;            
    TreeNode current = null ;

    public BSTIterator() {

  }
    public BSTIterator(TreeNode root) {
          current = root;        
          stack = new Stack<TreeNode> ();
          
          //point to the left most child's null left children as starting point
      	  while (current != null){
    		  stack.push(current);
    		  current = current.left;
    	  }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {        
          return !stack.isEmpty();
    }

        /** push all the left subtree onto the stack
         *  set the current node to stack pop
         * if current node has right node, push all the left subtree onto the stack
         * 
         *  
         * */
    public int next() {

    	// pop the head of the stack as current
    	current = stack.pop();
    	int retVal = current.val; //save the return value
    	
    	//if current has right sub child, add the right child and its subtree to the stack
    	if (current.right != null){
    		current = current.right;
    		while(current != null){
    			stack.push(current);
    			current = current.left;
    		}
    	}
    	return retVal;
    }


	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		
		n3.left = n1;
		n3.right = n4;
		
		n1.right = n2;
		
		BSTIterator b = new BSTIterator(n3);
		while(b.hasNext()){
			System.out.println(b.next());
		}
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */