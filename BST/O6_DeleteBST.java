public class O6_DeleteBST {
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
    private TreeNode successor(TreeNode root){
        while(root.left != null){
            root = root.left; 
        }
        return root ; 
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null ; 
        if(key < root.val){
            root.left = deleteNode(root.left, key); 
        }
        else if(key > root.val){
            root.right = deleteNode(root.right , key); 
        }
        else{
            if(root.left == null && root.right == null){
                return null; 
            }
            else if(root.left == null){
                return root.right ; 
            }
            else if(root.right == null){
                return root.left; 
            }
            else{
                TreeNode succ = successor(root.right);
                root.val = succ.val ; 
                root.right = deleteNode(root.right, succ.val); 
            }
        }
        return root; 
    }
}
