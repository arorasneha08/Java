import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class O7_VerticalTraversalBT {
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
    private void dfs(TreeNode root , int col , int level , TreeMap<Integer ,TreeMap<Integer , ArrayList<Integer>>> mpp){
        if(root == null) return ; 
        if(!mpp.containsKey(col)){
            mpp.put(col , new TreeMap<>());
        }
        if(!mpp.get(col).containsKey(level)){
            mpp.get(col).put(level , new ArrayList<>()); 
        }
        mpp.get(col).get(level).add(root.val); 
        dfs(root.left , col - 1 , level + 1, mpp); 
        dfs(root.right , col + 1 , level + 1, mpp); 
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        TreeMap<Integer , TreeMap<Integer , ArrayList<Integer>>> mpp = new TreeMap<>(); 
        dfs(root, 0 , 0 , mpp);

        for(Map.Entry<Integer , TreeMap<Integer, ArrayList<Integer>>> entry : mpp.entrySet()){
            List<Integer> list = new ArrayList<>(); 
            TreeMap<Integer , ArrayList<Integer>> levelMap = entry.getValue();
            for(Map.Entry<Integer , ArrayList<Integer>> subentry : levelMap.entrySet()){
                List<Integer> sublist = subentry.getValue();
                Collections.sort(sublist) ;  
                list.addAll(sublist); 
            }
            res.add(list); 
        } 
        return res; 
    }
}
