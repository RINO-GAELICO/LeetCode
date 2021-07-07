package leetCode;

public class BuildTreePostIn {

	public BuildTreePostIn() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		
		return recursiveMethod(inorder,postorder,0,inorder.length-1, postorder.length-1);
		
		
		
	}
	
	public TreeNode recursiveMethod(int[] inorder, int[] postorder,int indexStart,int indexEnd, int index) {
		
		if (indexStart>indexEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[index]);
		
		int inRootIndex = indexStart;
		
		while(postorder[index] != inorder[inRootIndex])
		{
			inRootIndex++;
		}
		
		root.right = recursiveMethod(inorder, postorder, inRootIndex+1, indexEnd, index-1);
				
		root.left = recursiveMethod(inorder, postorder, indexStart, inRootIndex-1, index -(indexEnd-inRootIndex)-1);
			
		
		return root;
		
		
		
		
		
		
	}
}