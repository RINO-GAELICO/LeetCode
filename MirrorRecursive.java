package leetCode;

public class MirrorRecursive {

	public MirrorRecursive() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSymmetric(TreeNode root) {

		if (root != null) {
			return isMirror(root.left, root.right);
		} else {
			return false;
		}

	}

	private boolean isMirror(TreeNode root1, TreeNode root2) {
		// // System.out.println("ROUND");
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				boolean mirror = isMirror(root1.right, root2.left);
				if (mirror)
					return isMirror(root1.left, root2.right);
				else
					return false;
			}
		}
		// System.out.println("FALSE_END");
		return false;

	}
}
