import java.util.ArrayList;
import java.util.List;

public class O5_PreSucc {
    private class Node{
        int left ; 
        int right ; 
        int data ;
        Node(int data){
            this.data = data ; 
        }
    }
    // private void inorder(Node root, List<Node> res) {
    //     if (root == null) return;
    //     inorder(root.left, res);
    //     res.add(root);
    //     inorder(root.right, res);
    // }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> res = new ArrayList<>();
        if (root == null) return res;

        Node pre = null;
        Node succ = null;
        List<Node> list = new ArrayList<>();

        // inorder(root, list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).data < key) {
                pre = list.get(i);
            } else if (list.get(i).data > key) {
                succ = list.get(i);
                break;
            }
        }

        res.add(pre);
        res.add(succ);
        return res;
    }
}
