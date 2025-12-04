import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class O16_SumOfLeafNodesAtMinLevel {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public int minLeafSum(Node root) {
        if (root == null)
            return 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int min = Integer.MAX_VALUE;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    min = Math.min(min, level);
                    mpp.put(level, mpp.getOrDefault(level, 0) + curr.data);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            level++;
        }
        if (min == Integer.MAX_VALUE)
            return 0;
        return mpp.get(min);
    }
}
