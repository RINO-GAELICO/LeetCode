package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class LevelOrder {

	public LevelOrder() {
		// TODO Auto-generated constructor stub
	}

List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> otherQueue = new LinkedList<TreeNode>();

		TreeNode currentNode = root;
		if (root != null) {
			currentNode = root;
			queue.add(currentNode);

			do {
                List<Integer> listSingleLevel = new ArrayList<Integer>();
				if (queue.isEmpty()) {
					while (!otherQueue.isEmpty()) {
						currentNode = otherQueue.pop(); 
                        
						listSingleLevel.add(currentNode.val);
						if (currentNode.left != null)
							queue.add(currentNode.left);
                        if (currentNode.right != null)
							queue.add(currentNode.right);
					}
                    listOfLists.add(listSingleLevel);
				} else {
					while (!queue.isEmpty()) {
						currentNode = queue.pop();
                        
						listSingleLevel.add(currentNode.val);
						if (currentNode.left != null)
							otherQueue.add(currentNode.left);
                        if (currentNode.right != null)
							otherQueue.add(currentNode.right);
					}
                    listOfLists.add(listSingleLevel);
				}
				// listLevels.add(listSingleLevel);
				// listSingleLevel.clear();
				

			} while (!queue.isEmpty()||!otherQueue.isEmpty());
		}
		return listOfLists;

	}
}