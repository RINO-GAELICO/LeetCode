package leetCode;

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class NodeNext {

	public NodeNext() {
		// TODO Auto-generated constructor stub
	}

	public Node connect(Node root) {
		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<Node> otherQueue = new LinkedList<Node>();
		Node currentNode;

		if (root != null) {
//				currentNode = root;
			queue.add(root);

			while (!queue.isEmpty() || !otherQueue.isEmpty()) {

				if (queue.isEmpty()) {
					while (!otherQueue.isEmpty()) {
						currentNode = otherQueue.pop();
						if (currentNode.left != null) {
							queue.add(currentNode.left);
							
						}
						if (currentNode.right!=null)
						{
							queue.add(currentNode.right);
						}
						
						if (!otherQueue.isEmpty()) {
							currentNode.next = otherQueue.peek();
							
						} else {
							currentNode.next = null;
						}

					}

				} else {
					while (!queue.isEmpty()) {
						currentNode = queue.pop();
						if (currentNode.left != null) {
							otherQueue.add(currentNode.left);
						}
						if (currentNode.right!=null)
						{
							otherQueue.add(currentNode.right);
						}
						
						if (!queue.isEmpty()) {
							currentNode.next = queue.peek();
							
						} else {
							currentNode.next = null;
						}

					}

				}

			}
		}
		return root;
	}
}
