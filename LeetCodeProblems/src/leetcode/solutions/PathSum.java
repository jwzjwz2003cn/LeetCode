package leetcode.solutions;
import leetcode.common.TreeNode;
public class PathSum implements ISolution {

	/**
	 * return true when root is a leaf node and the sum equals to root's value
	 * recursively to check left and right node
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum){
		    if (root.left == null && root.right == null)
		        return true;
		}
		return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode tn2 = new TreeNode(-2);
		TreeNode tn3 = new TreeNode(-3);
		TreeNode t1 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode tn22 = new TreeNode(-2);
		TreeNode tn1 = new TreeNode(-1);
		
		
		root.left = tn2;
		root.right = tn3;
		tn2.left = t1;
		tn2.right = t3;
		tn3.left = tn22;
		t1.left = tn1;
		
		System.out.println(hasPathSum(root, -1));
		
	}

}
