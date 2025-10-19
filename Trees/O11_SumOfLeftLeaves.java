import java.util.LinkedList;
import java.util.Queue;

public class O11_SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0 ; 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root); 
        int res = 0; 
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll(); 
                if(curr.left != null){
                    if(curr.left.left == null && curr.left.right == null){
                        res += curr.left.val ;
                    }
                    else{
                        q.offer(curr.left); 
                    }
                }
                if(curr.right != null){
                    q.offer(curr.right); 
                }
            }
        }
        return res ;
    }
}
