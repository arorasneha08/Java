import java.util.*;

public class O6_MaxWidthBinaryTree {
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
    private class Pair{
        TreeNode node; 
        int idx; 
        Pair(TreeNode node , int idx){
            this.node = node; 
            this.idx = idx; 
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0 ; 
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(root , 0)); 
        int width = 0 ;  
        while(!q.isEmpty()){
            int size = q.size(); 
            int minIdx = q.peek().idx; 
            int start = 0 , end = 0; 

            for(int i = 0 ; i < size; i ++){
                Pair curr = q.poll(); 
                TreeNode currNode = curr.node; 
                int currIdx = curr.idx - minIdx ;
                if(i == 0) start = currIdx ; 
                if(i == size - 1) end =  currIdx; 

                if(currNode.left != null){
                    q.offer(new Pair(currNode.left , 2 * currIdx + 1)) ; 
                }
                if(currNode.right != null){
                    q.offer(new Pair(currNode.right , 2 * currIdx+ 2)); 
                }
            }
            width = Math.max(width , end - start + 1); 
        }
        return width; 
    }
}
