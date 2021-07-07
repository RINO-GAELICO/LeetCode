package leetCode;

public class SumPath {

	public SumPath() {
		// TODO Auto-generated constructor stub
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {

		int count = 0;
		boolean found = false;

		if (root != null) {
			if (root.left==null && root.right==null && root.val == targetSum) {
				return true;
			}else if(root.left==null && root.right==null && root.val != targetSum)
			{
				return false;
			}
			return hasPathRecursion(root, targetSum, count, found);
		}else {
			return false;
		}

	}

	public boolean hasPathRecursion(TreeNode root, int targetSum, int count, boolean found) {

		if (found == true) {
			return true;
		}
		count += root.val;

		
		if (root.right == null && root.left == null) {
			if (count == targetSum) {
				found = true;
				return true;
			}else {
				count -= root.val;
				return false;
			}
			
		}

		if (root.left != null) {
			found = hasPathRecursion(root.left, targetSum, count, found);
		}

		if (root.right != null) {
			found = hasPathRecursion(root.right, targetSum, count, found);
		}
		return found;

	}

}
