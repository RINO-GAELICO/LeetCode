package leetCode;

public class BuildTreePreIn {

	public BuildTreePreIn() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return recursiveMethod(inorder, preorder, 0, inorder.length - 1, 0);

	}

	public TreeNode recursiveMethod(int[] inorder, int[] preorder, int indexStart, int indexEnd, int index) {

		if (indexStart > indexEnd||index>inorder.length - 1) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[index]);

		int inRootIndex = indexStart;

		while (inorder[inRootIndex] != preorder[index]) {
			inRootIndex++;
		}

		

		root.left = recursiveMethod(inorder, preorder, indexStart, inRootIndex - 1, index + 1);
		root.right = recursiveMethod(inorder, preorder, inRootIndex + 1, indexEnd,
				index + (inRootIndex - indexStart) + 1);

		return root;

	}

}
