import java.util.HashMap;

public class LRUCaches {
    class Node {
        Node next;
        Node prev;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    class LRUCache {
        HashMap<Integer, Node> mpp = new HashMap<>();
        Node head;
        Node tail;
        int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (mpp.containsKey(key)) {
                Node node = mpp.get(key);
                removeKey(node);
                insertEnd(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (mpp.containsKey(key)) {
                Node existing = mpp.get(key);
                removeKey(existing);
                mpp.remove(key);
            }

            Node newNode = new Node(key, value);
            mpp.put(key, newNode);
            insertEnd(newNode);

            if (mpp.size() > cap) {
                Node lru = head.next;
                removeKey(lru);
                mpp.remove(lru.key);
            }
        }

        private void insertEnd(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        private void removeKey(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }
}
