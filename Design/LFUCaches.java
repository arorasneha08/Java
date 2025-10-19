import java.util.HashMap;

public class LFUCaches {
    class Node {
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    class DLLNode {
        Node head;
        Node tail;
        int size;

        DLLNode() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        boolean isEmpty() {
            return size == 0;
        }

        Node removeLast() {
            if (size == 0)
                return null;
            Node prevNode = tail.prev;
            removeNode(prevNode);
            return prevNode;
        }
    }

    class LFUCache {
        HashMap<Integer, Node> nodeMap;
        HashMap<Integer, DLLNode> freqMap;
        int capacity;
        int minFreq;
        int size;

        public LFUCache(int capacity) {
            nodeMap = new HashMap<>();
            freqMap = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 0;
            this.size = 0;
        }

        public int get(int key) {
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                updateFreq(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                node.val = value;
                updateFreq(node);
            } else {
                if (size == capacity) {
                    DLLNode minNodeList = freqMap.get(minFreq);
                    Node last = minNodeList.removeLast();
                    nodeMap.remove(last.key);
                    size--;
                }
                Node node = new Node(key, value);
                nodeMap.put(key, node);
                if (!freqMap.containsKey(1)) {
                    freqMap.put(1, new DLLNode());
                }
                freqMap.get(1).addNode(node);
                minFreq = 1;
                size++;
            }
        }

        void updateFreq(Node node) {
            DLLNode nodeList = freqMap.get(node.freq);
            nodeList.removeNode(node);
            // if the node we removed was the node with the minFreq and no other node with
            // the same freq exists then we need to increase the freq
            if (node.freq == minFreq && nodeList.isEmpty()) {
                minFreq++;
            }
            node.freq++;
            if (!freqMap.containsKey(node.freq)) {
                freqMap.put(node.freq, new DLLNode());
            }
            freqMap.get(node.freq).addNode(node);
        }
    }
}
