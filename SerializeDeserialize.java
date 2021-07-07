package leetCode;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeDeserialize {

	public SerializeDeserialize() {
		// TODO Auto-generated constructor stub
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();

	}

	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append('#');
			sb.append(',');
			return;
		} else {
			sb.append(root.val);
			sb.append(',');
			buildString(root.left, sb);
			buildString(root.right, sb);
		}

		return;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(list);
    }

	private TreeNode buildTree(LinkedList<String> list) {
		String first = list.removeFirst();
		if (first.equals("#"))
		{
			return null;
		}else {
			TreeNode root = new TreeNode(Integer.valueOf(first));
			root.left = buildTree(list);
			root.right = buildTree(list);
			return root;
		}
		
    	
	}

}
