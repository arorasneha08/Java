public class O3_KthSmallest {
    int count = 0 ; 
    int res = 0 ; 
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
    private void func(TreeNode root , int k){
        if(root == null) return ;
        func(root.left , k);
        count ++ ; 
        if(count == k){
            res = root.val;
            return ;
        }
        func(root.right , k);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0 ; 
        func(root , k) ; 
        return res; 
    }
}
