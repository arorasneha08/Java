public class E_FloorAndCeil {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    int findCeil(Node root, int x) {
        if (root == null)
            return -1;
        int res = -1;
        while (root != null) {
            if (root.data == x) {
                res = root.data;
                return res;
            } else if (root.data < x) {
                root = root.right;
            } else {
                res = root.data;
                root = root.left;
            }
        }
        return res;
    }
    public int findMaxFork(Node root, int k) {
        if(root == null) return 0 ; 
        int res = -1 ; 
        while(root != null){
            if(root.data <= k){
                res = root.data ; 
                root = root.right ;
            }
            else{
                root = root.left ;
            }
        }
        return res; 
    }
}
