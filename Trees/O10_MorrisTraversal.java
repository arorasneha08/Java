import java.util.ArrayList;
import java.util.List;

public class O10_MorrisTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        if(root == null) return res ; 
        // func(root , res);
        // return res; 

        TreeNode curr = root; 
        while(curr != null){
            if(curr.left == null){
                res.add(curr.val); 
                curr = curr.right; 
            }
            else {
                TreeNode prev = curr.left; 
                while(prev.right != null && prev.right != curr){
                    prev = prev.right; 
                }
                if(prev.right == null){
                    prev.right = curr; 
                    curr = curr.left; 
                }
                else{
                    prev.right = null ;
                    res.add(curr.val); 
                    curr = curr.right; 
                }
            }
        }
        return res; 
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        if(root == null) return res ; 
        // func(root , res);
        // return res; 

        TreeNode curr = root; 
        while(curr != null){
            if(curr.left == null){
                res.add(curr.val); 
                curr = curr.right; 
            }
            else{
                TreeNode prev = curr.left; 
                while(prev.right != null && prev.right != curr){
                    prev = prev.right; 
                }
                if(prev.right == null){
                    prev.right = curr; 
                    res.add(curr.val); 
                    curr = curr.left ; 
                }   
                else{
                    prev.right = null ; 
                    curr = curr.right;
                }
            }
        }
        return res ; 
    }
    public void flatten(TreeNode root) {
        if(root == null) return ; 
        TreeNode curr = root; 
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left; 
                while(prev.right != null){
                    prev = prev.right ; 
                }
                prev.right = curr.right;     
                curr.right = curr.left; 
                curr.left = null ; 
            }
            curr = curr.right;
        }
    }
}
