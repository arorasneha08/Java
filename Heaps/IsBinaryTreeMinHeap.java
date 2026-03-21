import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsBinaryTreeMinHeap {
    public class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    private void isHeapUtil(Node root,List<Node> list){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                if(q.isEmpty()) break;
                else q.add(null);
            } else {
                list.add(curr);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
    boolean isHeap(Node tree) {
        // code here
        List<Node> list=new ArrayList<>();
        isHeapUtil(tree,list);
        int n=list.size();
        
        for(int i=0;i<n/2;i++){
            int left=2*i+1;
            int right=2*i+2;
            Node root=list.get(i);
            
            if(left<n&&root.left!=list.get(left)) return false;
            if(right<n&&root.right!=list.get(right)) return false;
            
            if(left<n&&root.left!=null&&root.left.data>root.data) return false;
            if(right<n&&root.right!=null&&root.right.data>root.data) return false;
        }
        
        return true;
    }
}
