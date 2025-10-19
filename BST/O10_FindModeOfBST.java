import java.util.ArrayList;
import java.util.List;

public class O10_FindModeOfBST {
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
    int prev = Integer.MAX_VALUE ; 
    int count = 1 ; 
    int max = 0 ; 

    private void func(TreeNode root , List<Integer> list){
        if(root == null) return ; 
        func(root.left , list);
        if(prev != Integer.MAX_VALUE){
            if(root.val == prev){
                count ++; 
            }
            else{
                count = 1; 
            }
        }
        if(count > max){
            max = count ; 
            list.clear() ;
            list.add(root.val); 
        }
        else if(count == max){
            list.add(root.val); 
        }
        prev = root.val ; 
        func(root.right , list); 
    }
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>(); 
        func(root , list); 
        int res[] = new int[list.size()]; 
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i); 
        }
        return res ; 
    }
}
