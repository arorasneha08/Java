public class O1_BalancedBinaryTree {
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

    private int func(TreeNode root){
        if(root == null) return 0;
        
        int left = func(root.left); 
        if(left == -1) return -1; 
        int right = func(root.right);
        if(right == -1) return -1; 
        
        if(Math.abs(left - right) > 1) return -1 ;
        
        return Math.max(left , right) + 1; 
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; 
        return func(root) != -1 ; 
        
    }
}
