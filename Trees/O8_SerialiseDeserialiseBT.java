import java.util.LinkedList;
import java.util.Queue;

class O8_SerialiseDeserialiseBT {
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
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder(); 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root) ; 
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                res.append("n ");
                continue; 
            } 
            res.append(curr.val).append(" "); 
            q.offer(curr.left);
            q.offer(curr.right); 
        }
        return res.toString(); 
    }

    public TreeNode deserialize(String data) {
        data = data.trim(); 
        if(data.equals("n")) return null;  
        String[] ch = data.split("\\s+"); 
        TreeNode root = new TreeNode(Integer.parseInt(ch[0])); 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root); 
        for(int i = 1 ; i < ch.length ; i ++){
            TreeNode curr = q.poll(); 
            if(i < ch.length && !ch[i].equals("n")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(ch[i])); 
                curr.left = leftNode; 
                q.offer(leftNode); 
            }
            i++; 
            if(i < ch.length && !ch[i].equals("n")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(ch[i])); 
                curr.right = rightNode; 
                q.offer(rightNode); 
            }
        }
        return root ;
    }
}