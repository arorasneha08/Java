import java.util.ArrayList;
import java.util.List;

public class O14_SumRootToLeaf {
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
    private void func(TreeNode root , StringBuilder str , List<Integer> list){
        if(root == null) return ; 
        str.append(root.val); 

        if(root.left == null && root.right == null){
            list.add(Integer.parseInt(str.toString())); 
        }
        else {
            func(root.left , str , list); 
            func(root.right , str , list); 
        }
        str.deleteCharAt(str.length()-1); 
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0; 
        List<Integer> list = new ArrayList<>(); 
        func(root , new StringBuilder() , list); 
        int sum = 0 ; 
        for(int num : list){
            sum += num ; 
        }
        return sum ; 
    }
}
