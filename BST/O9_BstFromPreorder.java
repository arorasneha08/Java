public class O9_BstFromPreorder {
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
    private TreeNode func(TreeNode root , int data){
        if(root == null) {
            return new TreeNode(data); 
        }
        if(data > root.val){
            root.right = func(root.right , data); 
        }
        else{
            root.left = func(root.left , data); 
        }
        return root; 
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length ; 
        TreeNode root = null ; 
        for(int i = 0 ; i < n ; i++){
            root = func(root , preorder[i]); 
        }
        return root; 
    }
}
