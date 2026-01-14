public class O18_TiltOfTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
    private int func(Node root , int total[]){
        if(root == null) return 0 ; 
        int left = func(root.left, total); 
        int right = func(root.right , total);
        total[0] += Math.abs(right - left); 
        return root.data + left + right; 
    }
    public int tiltTree(Node root) {
        if(root == null) return 0 ; 
        int[] total = new int[1]; 
        func(root , total); 
        return total[0]; 
    }
}
