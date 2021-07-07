package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class LowestCommonDescendant {

	public LowestCommonDescendant() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		ArrayList<TreeNode> listParentsP = new ArrayList<TreeNode>();
		ArrayList<TreeNode> listParentsQ = new ArrayList<TreeNode>();

		TreeNode currentNode = root;
		queue1.push(currentNode);

		while (currentNode != p) {
       
			if (queue1.isEmpty()) {
				while (!queue2.isEmpty() && currentNode != p) {
					currentNode = queue2.pop();
					if (currentNode != p) {
						if (currentNode.left != null) {
							queue1.push(currentNode.left);
						}
						if (currentNode.right != null) {
							queue1.push(currentNode.right);
						}
						stack.push(currentNode);
					}
				}
			} else {
				while (!queue1.isEmpty()&& currentNode != p) {
					currentNode = queue1.pop();
					if (currentNode != p) {
						if (currentNode.left != null) {
							queue2.push(currentNode.left);
						}
						if (currentNode.right != null) {
							queue2.push(currentNode.right);
						}
						stack.push(currentNode);
					}
				}
			}

		}
		listParentsP.add(currentNode);
		while (!stack.isEmpty()) {
			if (currentNode == stack.peek().left || currentNode == stack.peek().right) {
				currentNode = stack.pop();
				listParentsP.add(currentNode);

			} else {
				stack.pop();
			}

		}
        queue1.clear();
        queue2.clear();
		currentNode = root;
		queue1.push(currentNode);
		while (currentNode != q) {
            
			if (queue1.isEmpty()) {
				while (!queue2.isEmpty() && currentNode != q) {
                    
					currentNode = queue2.pop();
					if (currentNode != q) {
						if (currentNode.left != null) {
							queue1.push(currentNode.left);
						}
						if (currentNode.right != null) {
							queue1.push(currentNode.right);
						}
						stack.push(currentNode);
					}
				}
			} else {
				while (!queue1.isEmpty() && currentNode != q) {
                    
					currentNode = queue1.pop();
					if (currentNode != q) {
						if (currentNode.left != null) {
							queue2.push(currentNode.left);
						}
						if (currentNode.right != null) {
							queue2.push(currentNode.right);
						}
						stack.push(currentNode);
					}
				}
			}

		}
		listParentsQ.add(currentNode);
        
		while (!stack.isEmpty()) {
			if (currentNode == stack.peek().left || currentNode == stack.peek().right) {
				currentNode = stack.pop();
				listParentsQ.add(currentNode);

			} else {
				stack.pop();
			}

		}
        for(TreeNode var:listParentsQ) {
			System.out.println(var.val);
		}
		for(TreeNode var:listParentsP) {
			System.out.println(var.val);
		}

		int indexP = 0, indexQ = 0;

		TreeNode candidateP = listParentsP.get(indexP);

		TreeNode candidateQ = listParentsQ.get(indexQ);

		while (candidateQ != candidateP && indexP<listParentsP.size()) {

			while (candidateQ != candidateP && indexQ<listParentsQ.size()) {
				candidateQ = listParentsQ.get(indexQ);
                indexQ++;

			}
			    if (candidateQ != candidateP) {
				    candidateP = listParentsP.get(indexP);
                    indexP++;
                    indexQ=0;
			}

		}
		return candidateQ;

	}

}
