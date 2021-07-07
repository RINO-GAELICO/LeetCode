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
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Iterative_Preorder {

	List<Integer> listNodes = new ArrayList<Integer>();
	boolean retrievedStack = false;

	public Iterative_Preorder(){

	}

	public List<Integer> preorderTraversal(TreeNode root) {

		TreeNode currentNode = root;

		if (root != null) {

			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);

			while(!stack.isEmpty()){
				
				currentNode = stack.pop();
				listNodes.add(currentNode.val);
				
				if(currentNode.right != null)
				{
					stack.push(currentNode.right);
				}
				if(currentNode.left != null)
				{
					stack.push(currentNode.left);
				}	

			} 
			return listNodes;

		}
		return listNodes;

	}

}
