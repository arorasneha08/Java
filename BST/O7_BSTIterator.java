import java.util.Stack;

public class O7_BSTIterator {
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
    class BSTIterator {
    Stack<TreeNode> st ; 

    private void inorder(TreeNode root){
        if(root == null) return ; 
        inorder(root.right);
        st.push(root); 
        inorder(root.left); 
    }

    public BSTIterator(TreeNode root) {
        st = new Stack<>(); 
        inorder(root); 
    }
    
    public int next() {
        TreeNode top = st.peek(); 
        st.pop(); 
        return top.val; 
    }
    
    public boolean hasNext() {
        return !st.isEmpty() ; 
    }
}
}
