package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.tree.TreeNode;

public class Iterative_Postorder {

	List<Integer> listNodes = new ArrayList<Integer>();

	public Iterative_Postorder() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> postorderTraversal(TreeNode root) {

		TreeNode currentNode = null, visitedNode = null;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root != null) {
             

			currentNode = root;
			while ((!stack.isEmpty()) || currentNode != null) {
          
				if (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.left;
				} else if (currentNode == null) {
               
					if (stack.peek().right == null && stack.peek().left == null) {
                        
						visitedNode = stack.pop();
						listNodes.add(visitedNode.val);
					} else if (stack.peek().right != visitedNode) {
						if (stack.peek().right != null)
							currentNode = stack.peek().right;
						else {
							visitedNode = stack.pop();
							listNodes.add(visitedNode.val);
						}
					} else {
						visitedNode = stack.pop();
						listNodes.add(visitedNode.val);

					}
				}

			}

		}
		return listNodes;

	}

}
