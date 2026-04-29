public class T4_LargestBST {
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
    static class NodeValue {
        int maxNode, minNode, maxSize;
        
        NodeValue(int maxNode, int minNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    static NodeValue helper(Node root) {
        // Base case: empty subtree is a BST
        if (root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        // Recursive calls for left and right subtrees
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // If the current subtree is a BST
        if (left.maxNode < root.data && root.data < right.minNode) {
            return new NodeValue(
                Math.max(root.data, right.maxNode),  // maxNode
                Math.min(root.data, left.minNode),  // minNode
                left.maxSize + right.maxSize + 1   // maxSize
            );
        }

        // If not a BST, return an invalid range with the maximum size so far
        return new NodeValue(
            Integer.MAX_VALUE,
            Integer.MIN_VALUE,
            Math.max(left.maxSize, right.maxSize)
        );
    }

    static int largestBst(Node root) {
        return helper(root).maxSize;
    }
}
