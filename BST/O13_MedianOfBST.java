import java.util.ArrayList;
import java.util.List;

public class O13_MedianOfBST {
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
    private void inorder(Node root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public int findMedian(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();

        return list.get((n - 1) / 2); 
    }
}
