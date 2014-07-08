package leetcode.solutions;

import leetcode.common.TreeNode;

public class SumRootToLeafNumbers implements ISolution {

	public int sumNumbers(TreeNode root){
		if (root == null)
			return 0;
		return sumNum(root, 0);

	}
	
	public int sumNum(TreeNode root, int parentSum){
		if (root.left == null && root.right == null){
			return (parentSum * 10 + root.val);
		}
		int left = 0, right = 0;
		if (root.left != null){
			left = sumNum(root.left, parentSum * 10 + root.val);
		}
		if (root.right != null){
			right = sumNum(root.right, parentSum * 10 + root.val);
		}
		int retVal = left + right;
		return retVal;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeNode n4 = new TreeNode(4);
		TreeNode n9 = new TreeNode(9);
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);

		
		n4.left = n9;
		n4.right = n0;
		n9.right = n1;
		System.out.println(sumNumbers(n4));
	}
}
