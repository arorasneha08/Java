import java.util.HashMap;

public class O5_ConstructInorderPostorder {
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
    private TreeNode func(int pstart , int pend , int instart , int inend , int inorder[] 
    , int postorder [] , HashMap<Integer , Integer> mpp){

        if(pstart > pend || instart > inend)  return null; 
        TreeNode root = new TreeNode(postorder[pend]);  
        int inroot = mpp.get(postorder[pend]); 
        int numsLeft = inroot - instart ; 

        root.left = func(pstart, pstart + numsLeft - 1 , instart , inroot , inorder ,postorder , mpp);
        root.right = func(pstart + numsLeft, pend-1  , inroot + 1 , inend , inorder , postorder , mpp);

        return root ; 
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < inorder.length ; i++){
            mpp.put(inorder[i] , i) ;
        }
        return func(0, postorder.length-1 , 0 , inorder.length-1 , inorder ,postorder , mpp); 
    }
}
