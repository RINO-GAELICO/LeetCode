package leetCode;

import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.List;

import javax.swing.tree.TreeNode;

public class Solution {

	List<Integer> listNodes = new ArrayList<Integer>();

	public Solution() {

	}

	public List<Integer> preorderTraversal(TreeNode root) {

		recursiveHelper(root);
		return listNodes;

	}

	public void recursiveHelper(TreeNode root) {

		if (root != null)
			listNodes.add(root.val);
		else {
			return;
		}

		if (root.left != null)
			recursiveHelper(root.left);
		if (root.right != null)
			recursiveHelper(root.right);
		return;
	}

}
