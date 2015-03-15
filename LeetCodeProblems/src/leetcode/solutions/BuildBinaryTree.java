package leetcode.solutions;

import java.util.Arrays;

import leetcode.common.TreeNode;

public class BuildBinaryTree implements ISolution {

	/**
	 * 
	 *  - recursive
	 *  - find root node from pre order
	 *  - split the inorder array based on the root value
	 *  - split the pre order array based on the property that inorder[length-1] = preorder[length-1]
	 *  - do that recursively for left and right 
	 *  - return root
	 * 
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder){
		
		if (preorder == null || preorder.length == 0)
			return null;
		
		if(preorder.length == 1 || inorder.length == 1)
			return new TreeNode(preorder[0]);
		
		
		int rootVal = preorder[0];
		TreeNode root = new TreeNode(rootVal);
		
		int rootInOrderIndex = 0;
		for (int i = 0; i < inorder.length; i++){
			if (inorder[i] == root.val) {
				rootInOrderIndex = i;
				break;
			}
				
		}
		
		int[] leftInOrder = null;
		int[] leftPreOrder = null;
		int[] rightInOrder = null;
		int[] rightPreOrder = null;
		//when there is left subtree
		if (rootInOrderIndex > 0){
			leftInOrder = Arrays.copyOfRange(inorder, 0, rootInOrderIndex);
			leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1);
		} 
		
		//when there is right subtree
		if (rootInOrderIndex < inorder.length -1){
			rightInOrder = Arrays.copyOfRange(inorder, rootInOrderIndex + 1, inorder.length);
			rightPreOrder = Arrays.copyOfRange(preorder, rootInOrderIndex + 1, preorder.length);
		}

		
		root.left = buildTree(leftPreOrder, leftInOrder);
		root.right = buildTree(rightPreOrder, rightInOrder);
		
		
		return root;
		
	}
	
	/**
	 * - recursive
	 * - find root
	 * - find left and right subtree of the root from both inorder and postorder
	 * - build the tree
	 * - return root
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTreePostOrder(int[] inorder, int[] postorder){
		
		if (inorder == null || inorder.length == 0) 
			return null;

		if (inorder.length == 1)
			return new TreeNode(inorder[0]);
		
		//find the root, last element of postorder
		int length = inorder.length;
		TreeNode root = new TreeNode(postorder[length - 1]);
		
		//find the root from inorder
		int rootInorderIndex = 0;
		for (int i = 0; i < length; i++){
			if (root.val == inorder[i]){
				rootInorderIndex = i;
				break;
			}
		}
		
		int[] inorderLeftTree = null;
		int[] inorderRightTree = null;
		int[] postorderLeftTree = null;
		int[] postorderRightTree = null;
		
		//when there is a left subTree
		if (rootInorderIndex > 0){
			inorderLeftTree = Arrays.copyOfRange(inorder, 0, rootInorderIndex);
			postorderLeftTree = Arrays.copyOfRange(postorder, 0, inorderLeftTree.length);
		}
		
		//when there is a right subTree
		if (rootInorderIndex < length - 1){
			inorderRightTree = Arrays.copyOfRange(inorder, rootInorderIndex + 1, inorder.length);
			postorderRightTree = Arrays.copyOfRange(postorder, rootInorderIndex, rootInorderIndex + inorderRightTree.length);
		}
		
		root.left = buildTreePostOrder(inorderLeftTree, postorderLeftTree);
		root.right = buildTreePostOrder(inorderRightTree, postorderRightTree);
		
		return root;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
