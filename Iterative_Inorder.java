package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Iterative_Inorder {

	List<Integer> listNodes = new ArrayList<Integer>();

	public Iterative_Inorder() {

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		TreeNode currentNode = null;

		if (root != null) {

			Stack<TreeNode> stack = new Stack<TreeNode>();

			currentNode = root;
			stack.push(root);

			while (!stack.isEmpty() && currentNode != null) {
				currentNode = currentNode.left;

				if (currentNode != null) {
					stack.push(currentNode);
				} else {

					while (currentNode == null && !stack.isEmpty()) {
						currentNode = stack.pop();
						if (currentNode != null)
							listNodes.add(currentNode.val);
						currentNode = currentNode.right;
					}
					if (currentNode != null) {
						stack.push(currentNode);
					}

				}

			}
			return listNodes;

		}
		return listNodes;

	}
}
