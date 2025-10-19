import java.util.ArrayList;
import java.util.List;

public class O8_LargestBST {
    public class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int data) {
            this.data = data;
        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private static void inorder(Node root , List<Integer> list){
        if(root == null) return ; 
        inorder(root.left , list); 
        list.add(root.data); 
        inorder(root.right , list); 
    }
    private static int dataidBst(Node root){
        List<Integer> list = new ArrayList<>(); 
        inorder(root , list); 
        for(int i = 0 ; i< list.size() -1 ; i++){
            if(list.get(i) >= list.get(i+1)){
                return -1; 
            }
        }
        return list.size(); 
    }
    static int largestBst(Node root) {
        if(root == null) return 0 ; 
        int size = dataidBst(root); 
        int left = largestBst(root.left) ;
        int right = largestBst(root.right); 
        return Math.max(size , Math.max(left , right)); 
    }
}
