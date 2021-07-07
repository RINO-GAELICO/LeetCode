package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorIterative {

	public MirrorIterative() {
		// TODO Auto-generated constructor stub
	}
	public boolean isSymmetric(TreeNode root) {
        if (root!=null)
        {
            
            Queue<TreeNode> q1 = new LinkedList<TreeNode>();
            Queue<TreeNode> q2 = new LinkedList<TreeNode>();
            q1.offer(root.left);
            q2.offer(root.right);
            
            while((!q1.isEmpty())&&(!q2.isEmpty()))
            {
                TreeNode c1 = q1.poll();
                TreeNode c2 = q2.poll();
                // System.out.println(c1);
                if((c1 == null && c2 != null) || (c2 == null && c1 != null))
                {
                    // System.out.println("FALSE");
                    return false;
                }if(c1 != null)
                {
                    if (c1.val!=c2.val)
                    {
                        return false;
                    }
                        
                    q1.offer(c1.left);
                    q1.offer(c1.right);
                    q2.offer(c2.right);
                    q2.offer(c2.left);
                }
                    
            
            }
            // System.out.println("END");
            return true;
        }return true;
           
    }

}
