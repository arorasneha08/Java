import java.util.HashMap;

public class DP_MaxNonAdjSumNodes {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    HashMap<Node, Integer> mpp = new HashMap<>();

    private int func(Node root) {
        if (root == null)
            return 0;
        if (mpp.containsKey(root))
            return mpp.get(root);
        int take = root.data;
        if (root.left != null) {
            take += func(root.left.left);
            take += func(root.left.right);
        }
        if (root.right != null) {
            take += func(root.right.left);
            take += func(root.right.right);
        }
        int nottake = func(root.left) + func(root.right);
        int val = Math.max(take, nottake);
        mpp.put(root, val);
        return val;
    }

    public int getMaxSum(Node root) {
        if (root == null)
            return 0;
        return func(root);
    }
}
