public class O12_BSTtoGreaterSumTree {
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

    static int sum;

    private static void func(Node root) {
        if (root == null)
            return;
        func(root.right);
        sum += root.data;
        root.data = sum - root.data;
        func(root.left);
    }

    public static void transformTree(Node root) {
        if (root == null)
            return;
        sum = 0;
        func(root);
    }
}
