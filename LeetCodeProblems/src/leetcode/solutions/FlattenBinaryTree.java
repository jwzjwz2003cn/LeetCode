package leetcode.solutions;


import leetcode.common.TreeNode;

public class FlattenBinaryTree implements ISolution {

	/**
	 *  - Need a helper method that returns root node for flatten
	 *  - flatten left, and then flatten right
	 *  - use a loop search for the end of left and connect it with the flattened right
	 * @param root
	 */
	
	public void flatten(TreeNode root){
		
		flattenReturnRoot(root);
		
	}
	
	public TreeNode flattenReturnRoot(TreeNode root){
		if (root == null)
			return root;
		if (root.left == null && root.right == null)
			return root;
		TreeNode left = flattenReturnRoot(root.left);
		TreeNode right = flattenReturnRoot(root.right);
		root.left = null;
		root.right = left;
		TreeNode current = root;
		while(current.right != null){
			current = current.right;
		}
		current.right = right;
		return root;
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;
		
		flatten(n1);
		TreeNode currentNode = n1;
		while(currentNode != null){
			System.out.println(currentNode.val);
			currentNode = currentNode.right;
		}
		
	}

}
