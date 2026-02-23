import java.util.ArrayList;

public class O19_CheckIfSubtree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    private static boolean check(Node t1 , Node t2){
        if(t1 == null && t2 == null) return true; 
        if(t1 == null || t2 == null) return false; 
        if(t1.data != t2.data) return false; 
        
        boolean left = check(t1.left , t2.left); 
        boolean right = check(t1.right , t2.right); 
        return left && right ; 
    }
    private static void findNode(Node root , int target , ArrayList<Node> list){
        if(root == null) return ; 
        if(root.data == target) {
            list.add(root); 
        }
        findNode(root.left , target , list); 
        findNode(root.right , target , list); 
    }
    public static boolean isSubtree(Node t, Node s) {
        ArrayList<Node> list = new ArrayList<>(); 
        
        findNode(t , s.data, list); 
        
        for(Node a : list){
            if(check(a , s)){
                return true ; 
            }
        }
        return false;
    }
}
